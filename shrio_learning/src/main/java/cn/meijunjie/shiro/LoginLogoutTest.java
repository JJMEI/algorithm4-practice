package cn.meijunjie.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class LoginLogoutTest {


    @Test
    public void testHelloWorld()
    {
        //获取SecurityManager工厂
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");

        //获取SecurityManager实例并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        //得到Subject以及创建用户名/密码身份验证
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        try
        {
            subject.login(token);
        }catch (AuthenticationException e)
        {
            //身份验证失败
            log.info("身份验证失败");
        }


        Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();
    }
}
