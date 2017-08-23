package cn.meijunjie.test;

import cn.meijunjie.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;



@Slf4j
//@Test
//@ContextConfiguration(locations = {"classpath:MyBatis-Spring.xml"})
public class MybatisSpirngTest {

//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void test(){
//        log.info(userService.getUser(222).toString());
//    }

    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("MyBatis-Spring.xml");

        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

//        UserService userService = applicationContext.getBean(UserService.class);
//        log.info(userService.getUser(222).toString());
    }

}
