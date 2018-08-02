package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;

public interface OrderService {

	boolean createOrder();

	List<UserOrder> findOrder();

	List<UserOrderItem> findOrderItem();

	long orderNo();
}
