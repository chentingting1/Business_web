package com.neuedu.test;

import com.neuedu.dao.UserOrderDao;
import com.neuedu.dao.UserOrderItemDao;
import com.neuedu.dao.impl.mybatis.UserOrderMybatisImpl;
import com.neuedu.entity.UserOrder;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;
import org.junit.Test;

public class UserOrderTest {
    OrderService orderService=null;

    public void before(){
        orderService= new OrderServiceImpl();
    }
    @Test
    public void tsetOrder(){

        orderService.createOrder();

    }

    public void after(){
        orderService=null;
    }
}
