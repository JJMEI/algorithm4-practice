package cn.meijunjie.commons;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {

   public static  void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
       User user = new User();
       user.setAge(12);
       user.setUsername("meijunjie");
       user.setPassword("13r4");

       System.out.println(user.getAge());

       User user1 = (User) BeanUtils.cloneBean(user);  // 克隆对象
       System.out.println(user1.getPassword());


       BeanUtils.copyProperties(user1,user); //属性拷贝
       System.out.println(user1.getUsername());

       String[] beanProperties = BeanUtils.getArrayProperty(user,"username");
       for(String s : beanProperties)
           System.out.print(s);


   }
}
