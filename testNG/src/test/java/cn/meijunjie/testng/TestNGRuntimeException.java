package cn.meijunjie.testng;

import org.testng.annotations.Test;

public class TestNGRuntimeException {

    @Test(expectedExceptions = {ArithmeticException.class})
    public void runtimeException()
    {
        int i = 1 / 0;
        System.out.println("After division the value of i is :"+ i);
    }
}
