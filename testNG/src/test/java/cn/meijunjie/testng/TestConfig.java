package cn.meijunjie.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestConfig {

    @BeforeSuite
    public void beforeSuit()
    {
        System.out.println("@BeforeSuit.......");
    }

    @AfterSuite
    public void afterSuit()
    {
        System.out.println("@AfterSuit.......");
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("@BeforeTest....");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("@AfterTest....");
    }
}
