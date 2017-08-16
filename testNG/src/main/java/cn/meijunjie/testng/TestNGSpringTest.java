package cn.meijunjie.testng;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
@Test
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestNGSpringTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private EmailGenerator emailGenerator;

    @Test
    public void testSpringTestNG()
    {
        String email = emailGenerator.createEmail();
        log.info("成功生成邮件名，{}",email);

        Assert.assertNotNull(email);
        Assert.assertEquals(email,"mmeijunjie@13.com");
    }
}
