package cn.meijunjie.testng;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderBo {

    public void save(Order order) throws OrderSaveException
    {
        if(order == null)
            throw new OrderSaveException("order is empty");

        log.info("持久化到数据库......");
    }


    public void update(Order order) throws OrderUpdateException,OrderNotFindException
    {
        if(order == null)
            throw new OrderUpdateException("order is empty");
        if(order.getOrderName().equals(" "))
            throw new OrderNotFindException("订单未找到....");
        log.info("持久化到数据库....");
    }
}
