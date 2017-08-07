package test;

import cn.meijunjie.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class UserServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser()
    {
        boolean b1 = userService.hasMatchUser("admin","123456");

        System.out.print(b1);
    }

    @Test
    public void findUserByUserName()
    {
        System.out.print(userService.findUserByUserName("admin").toString());
    }
}
