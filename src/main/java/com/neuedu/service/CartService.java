package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart;

public interface CartService {

	boolean addCart(Cart cart);// ��

	List<Cart> findCart();// ��

	boolean updateCart(Cart cart);// ��

	boolean deleteCart(int id);// ɾ

	public int getOrderId();

	Cart getCartById(int id);
}
