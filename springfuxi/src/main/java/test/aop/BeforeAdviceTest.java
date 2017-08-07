package test.aop;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAdviceTest {

    private Waiter target;

    private BeforeAdvice beforeAdvice;
    private ProxyFactory proxyFactory;

    @BeforeTest
    public void init()
    {
        target = new NaiveWaiter();

        beforeAdvice  = new GreetingBeforeAdvice();

        //spring提供代理工厂
        proxyFactory = new ProxyFactory();

        //设置代理目标
        proxyFactory.setTarget(target);
        //添加增强方法
        proxyFactory.addAdvice(beforeAdvice);

    }

    @Test
    public void beforeAdvice()
    {
        Waiter proxy = (Waiter) proxyFactory.getProxy(); //获取代理类

        proxy.greetTo("Jhon");
        proxy.serveTo("Tom");

    }
}
