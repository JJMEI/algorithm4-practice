package cn.meijunjie.web.controller;

import cn.meijunjie.web.dao.Spitter;
import cn.meijunjie.web.dao.Spittle;
import cn.meijunjie.web.execption.ImageUploadException;
import cn.meijunjie.web.service.SpitterService;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/spitters")
public class SpitterController {

    @Autowired
    private SpitterService spitterService;

    @Value("${AccessKey}")
    private String accessKey;

    @Value("${SecretKey}")
    private String secretKey;

    @RequestMapping(value = "/spittles/{spitter}")
    public @ResponseBody String  listSpittlesForSpitter(@PathVariable("spitter") String username, Model model)
    {
        Spitter spitter = spitterService.findSpitter(username);
        model.addAttribute("spitter",spitter);
        model.addAttribute("spittles",spitterService.getSpittlesForSpitter(username));
        return "list";
    }


    @RequestMapping(value = "/register")
    public String createNewSpitter(Model model)
    {
        model.addAttribute("spitter",new Spitter());
        return "spitters/register";
    }

    @RequestMapping(value = "/createSpitter",method = RequestMethod.POST)
    public String addSpitterToDataBase(@Valid Spitter spitter, BindingResult bindingResult,
                                       @RequestParam(value = "image", required = false)MultipartFile image)
            throws IOException {
        //查看是否出现校验错误，如果出现错误则之间返回注册页面
        if(bindingResult.hasErrors())
        {
            return "spitters/register";
        }
        //调用SpitterService服务registerSpitter方法入库
        spitterService.registerSpitter(spitter);
        try
        {
            //如果上传照片非空
            if(!image.isEmpty())
            {
                //校验image是否为指定的格式
                validateImage(image);

                //存储image，可以选择存储到本地或者云端
                saveImage(spitter.getId() + spitter.getUsername()+".jpg",image);
                saveImageToColude(spitter.getId() + spitter.getUsername()+".jpg",image);

            }

        }catch (ImageUploadException e)
        {
            bindingResult.reject(e.getMessage());
            return "spitters/register";
        }
        return "redirect:/spitters/" + spitter.getUsername();
    }



    @RequestMapping(value = "/{username}")
    public String showSpitterProfile(@PathVariable("username") String username, Model model)
    {
        List<Spittle> spittles = spitterService.getSpittlesForSpitter(username);
        model.addAttribute("spittles",spittles);

        model.addAttribute("spitter",spitterService.findSpitter(username));

        return "spitters/views";
    }


    private void validateImage(MultipartFile image) {
        //调用image.getContentType()方法获取，上传内容的类型
        if(!image.getContentType().equals("image/jpeg"))
            throw new ImageUploadException("Only JPG image accepted");
    }

    private void saveImage(String imageName,MultipartFile image) throws ImageUploadException
    {
        try
        {
            File file = new File("/Users/leeco/IdeaProjects/algorithm4-practice/spitter/src/main/webapp/resources/images"+imageName);
            FileUtils.writeByteArrayToFile(file,image.getBytes());
        }catch (IOException e)
        {
            throw new ImageUploadException("unable save image",e);
        }
    }

    /**
     * 将图片上传到七牛云存储
     * @param imageName
     * @param image
     * @throws ImageUploadException
     * @throws IOException
     */
    private void saveImageToColude(String imageName, MultipartFile image) throws ImageUploadException, IOException {
        //设置配置对象
        Configuration configuration = new Configuration(Zone.zone2());
        //获取上传管理
        UploadManager manager = new UploadManager(configuration);

        //生成权限控制器
        Auth auth = Auth.create(accessKey,secretKey);

        String key = imageName;

        byte[] imageBytes = image.getBytes();

        String upToken = auth.uploadToken("markdown-image",key);

        try
        {
            Response response = manager.put(imageBytes,key,upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
            log.info(putRet.key);
            log.info(putRet.hash);
        }catch (QiniuException e)
        {
            Response response = e.response;
            log.info(response.toString());
            try
            {
                log.info(response.bodyString());
            }catch (QiniuException e1)
            {

            }
        }
    }
}
