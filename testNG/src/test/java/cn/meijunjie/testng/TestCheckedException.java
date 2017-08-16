package cn.meijunjie.testng;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Slf4j
public class TestCheckedException {

    OrderBo orderBo;
    Order order;

    @BeforeTest
    public void beforeTest()
    {
        orderBo = new OrderBo();
        order = new Order();
        order.setOrderName("hello");
        order.setOrderId("dsdcssc");
    }

    @Test(enabled = false,expectedExceptions = OrderSaveException.class)
    public void testCheckedException() throws OrderSaveException
    {
        orderBo.save(order);
    }

    @Test(enabled = false) //enabled属性可以忽略该测试
    public void testcheckedException1() throws OrderUpdateException,OrderNotFindException
    {
        orderBo.update(null);
    }

    @Test(enabled = false,timeOut = 1000)
    public void timeout() throws InterruptedException
    {
        Thread.sleep(30000);
    }

    @Test(enabled = false,timeOut = 10)
    public void testTimeOut()
    {
        while (true)
        {
            log.info("............");
        }
    }
}
