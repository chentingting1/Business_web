package com.neuedu.utils;

import java.util.Scanner;

import com.neuedu.entity.Cart;
import com.neuedu.entity.UserOrderItem;

public class Utils {

	public static int inputSZ(String msg) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(msg);
		return scanner.nextInt();
	}

	public static String input(String msg) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(msg);
		return scanner.next();
	}

	/*
	 * �����ﳵ��Ϣʵ����ת��Ϊ������ϸʵ����
	 */
	public static UserOrderItem convertToOrderItem(int id, long order_no, Cart cart) {
		UserOrderItem uorderItem = new UserOrderItem();
		uorderItem.setId(id);

		uorderItem.setOrder_no(order_no);
		uorderItem.setProduct_id(cart.getProduct().getId());// ��Ʒid
		uorderItem.setProduct_name(cart.getProduct().getName());
		uorderItem.setProduct_image(cart.getProduct().getImage());
		uorderItem.setCurrent_unit_price(cart.getProduct().getPrice());// ��Ʒ�۸�
		uorderItem.setQuantity(cart.getNum()); // ��Ʒ����������
		uorderItem.setTotal_price(cart.getProduct().getPrice() * cart.getNum());
		uorderItem.setCreate_time(System.currentTimeMillis());

		return uorderItem;

	}

}
