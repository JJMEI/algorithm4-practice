package test.bean;

import cn.meijunjie.po.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import java.util.LinkedList;

public class ApplicationContextTest {

    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/beans.xml");

        System.out.println(ctx.getApplicationName());



        System.out.println(ctx.getBean("user", User.class));

        System.out.println(ctx.getBean("user2",test.pojo.User.class).getList().toString());

        System.out.println(ctx.getBean("user2",test.pojo.User.class).getHashMap().toString());


        System.out.println(ctx.getBean("expressionList", LinkedList.class).toString());

        System.out.println();
    }
}












