package cn.meijunjie.testng;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHelloWorld {

    @Test
    public void testEmailGenerator()
    {
        RandomEmailGenerator randomEmailGenerator = new RandomEmailGenerator();
        String email = randomEmailGenerator.generate();

        Assert.assertNotNull(email);
        Assert.assertEquals(email,"feddback@163.com");

    }


}
