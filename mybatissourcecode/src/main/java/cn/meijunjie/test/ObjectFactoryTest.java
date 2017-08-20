package cn.meijunjie.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.invoker.Invoker;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ObjectFactoryTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ObjectFactory objectFactory = new DefaultObjectFactory();
        List<String> list = objectFactory.create(ArrayList.class);
        list.add("hello");

        log.info(list.toString());

        //反射创建一个User实例
        User user = objectFactory.create(User.class);

        //保存一个类class的反射Invoker信息集合
        Reflector reflector = new Reflector(User.class);

        //反射类Class的Method Field封装
        Invoker invoker = reflector.getSetInvoker("id");

        invoker.invoke(user,new Object[]{20});
        invoker = reflector.getGetInvoker("id");

        log.info("id is {}",invoker.invoke(user,null));


    }
}
