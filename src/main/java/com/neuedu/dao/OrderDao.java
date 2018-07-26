package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrder;

public interface OrderDao {

	// ��������
	boolean createOrder(UserOrder order);

	// �鿴����
	List<UserOrder> findOrder();

	// ��ȡ����ID
	int getOrderId();
}
