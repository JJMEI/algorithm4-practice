package cn.meijunjie.test;

import cn.meijunjie.jdkproxy.Play;
import lombok.extern.slf4j.Slf4j;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class MapperTest {

    public static void main(String[] args)
    {
        MapperProxy proxy = new MapperProxy();

        UserMapper mapper = proxy.newInstance(UserMapper.class);

        log.info(mapper.toString());
        log.info("...{}",mapper.hashCode());
        User user  = mapper.getUserById(1001);

        log.info("ID is {}",user.getId());
        log.info("Name is {}",user.getUsername());
        log.info("Password is {}",user.getPassword());

        log.info(mapper.toString());
        createProxyClassFile();
    }

    private static void createProxyClassFile()
    {
        String proxyName = "ProxyMapper";

        //动态代理中，最核心的一条代码 生成代理类（字节码）
        byte[] data = ProxyGenerator.generateProxyClass(proxyName, new Class[]{UserMapper.class});

        FileOutputStream outputStream = null;
        try
        {
            outputStream = new FileOutputStream(proxyName + ".class");
            log.info("文件路径{}...",new File("hello").getAbsolutePath());
            outputStream.write(data);
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            if(outputStream!=null)
            {
                try{
                    outputStream.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}
