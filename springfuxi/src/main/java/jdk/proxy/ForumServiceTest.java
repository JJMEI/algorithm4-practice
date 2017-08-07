package jdk.proxy;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest {

    @Test
    public void proxy()
    {
        ForumService target = new ForumServiceImpl();

        PerformanceHandler handler = new PerformanceHandler(target);

        //目标类的 类加载器 目标类的全部接口  横切和业务的整合器 handler，所以这个代理类实现了目标类的所有接口
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler
        );

        proxy.removeForum(10);
        proxy.removeTopic(123);

    }
}
