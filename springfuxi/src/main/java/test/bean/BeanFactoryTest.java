package test.bean;

import cn.meijunjie.po.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class BeanFactoryTest {

    public static void main(String[] args)
    {
        //资源读取器
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        //Resource 读取器 Resolver从磁盘中读取
        Resource resource = resourcePatternResolver.getResource("classpath:/spring/beans.xml");

        //通过BeanFactory启动的Ioc容器，并不会初始化配置文件中定义的Bean。初始化动作发生在第一次调用时，对于单实例的bean来说，BeanFactory会缓存Bean实例，第二次从Ioc容器缓存中直接获取
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        System.out.print(beanFactory.getBean("user", User.class).toString());
    }
}
