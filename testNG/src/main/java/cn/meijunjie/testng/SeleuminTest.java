package cn.meijunjie.testng;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Slf4j
public class SeleuminTest {


    @Test(enabled = false,invocationCount = 1000)
    public void loadTestThisWebSite()
    {
        System.setProperty("webdriver.firwfox.bin","/Applications/Firefox.app/Contents/MacOS/firefox");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu" +
                ".com");
        log.info("Page Title is " + driver.getTitle());

        AssertJUnit.assertEquals("Baidu",driver.getTitle());
        driver.quit();
    }

    @Test(invocationCount = 10000,threadPoolSize = 1000)
    public void testMultiThread()
    {
        log.info("Thread Id : " + Thread.currentThread().getName() + "\n");
    }
}
