package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;

public interface CartDao {

	boolean addCart(Cart cart);
	
	List<Cart> findCart();
	
	boolean updateCart(Cart cart);
	
	boolean deleteCart(int id);
	
	int getOrderId();

	Cart getCartById(int id);
	
	void clearCart();
}
