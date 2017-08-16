package cn.meijunjie.web.controller;

import cn.meijunjie.dao.User;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@Slf4j
public class RegisterController {

//private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping(value = "/register.html")
    public String registerUser(@ModelAttribute("user") User user) //添加一个User对象
    {
        log.info("跳转至登录页面，并创建表单对象添加至隐含数据模型中。。");
        return "registeruser";
    }

    @RequestMapping(value = "/createUser.html", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute("user")User user, BindingResult bindingResult)
    {
        log.info("执行表单验证....");
        if(bindingResult.hasErrors())
        {
            log.info("表单校验不通过，存在以下错误信息");
            return "registeruser";
        }else
        {
            log.info("校验提供，跳转至欢迎页.....");
            return "createSuccess";
        }
    }
}
