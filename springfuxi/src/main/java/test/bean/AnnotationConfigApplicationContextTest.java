package test.bean;

import cn.meijunjie.po.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextTest {

    public static void main(String[] args)
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(test.config.Beans.class);

        System.out.println(ctx.getBean("user", User.class));
    }
}
