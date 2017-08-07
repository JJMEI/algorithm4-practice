package test.aop;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJProxyTest {

    public static void main(String[] args)
    {
//        Waiter target = new NaiveWaiter();
//        AspectJProxyFactory factory = new AspectJProxyFactory();
//
//        //设置目标对象
//        factory.setTarget(target);
//        //添加切面类
//        factory.addAspect(PreGreetingAspect.class);
//
//        //生成织入切面的代理对象
//        Waiter proxy = factory.getProxy();
//
//        proxy.greetTo("John");
//        proxy.serveTo("john");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/aopbeans.xml");
//
//        Waiter waiter = (Waiter) applicationContext.getBean("waiter2");
//        waiter.greetTo("jhon");

        Waiter waiter1 = (Waiter) applicationContext.getBean("waiter3");

        waiter1.greetTo("jhon");


        Seller seller = (Seller) waiter1;

        seller.sellSomething();
    }
}
