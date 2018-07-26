package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;

public interface OrderService {

	// ��������
	boolean createOrder();

	// �鿴����
	List<UserOrder> findOrder();

	List<UserOrderItem> findOrderItem();

	// ��ȡ������
	long orderNo();
}
