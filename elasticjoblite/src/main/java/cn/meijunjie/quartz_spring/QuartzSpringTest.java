package cn.meijunjie.quartz_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzSpringTest {

    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Quartz_Spring.xml");
    }
}
