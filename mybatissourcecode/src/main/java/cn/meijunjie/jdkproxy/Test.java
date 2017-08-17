package cn.meijunjie.jdkproxy;

import lombok.extern.slf4j.Slf4j;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Slf4j
public class Test {
    public static void main(String[] args)
    {
        Play realPlay = new RealPlayImpl();
        InvocationHandler handler = new InvocationHandlerImpl(realPlay);

        Play play = (Play) Proxy.newProxyInstance(realPlay.getClass().getClassLoader()
                    ,realPlay.getClass().getInterfaces()
                    ,handler);

        play.playBall("football");
        play.playGame("LOL");

        log.info("动态代理对象的类型是{}",play.getClass().getName());
        createProxyClassFile();
    }

    private static void createProxyClassFile()
    {
        String proxyName = "ProxyPlay";

        byte[] data = ProxyGenerator.generateProxyClass(proxyName, new Class[]{Play.class});
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
