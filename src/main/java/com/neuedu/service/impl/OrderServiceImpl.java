package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.UserOrderDao;
import com.neuedu.dao.UserOrderItemDao;
import com.neuedu.dao.impl.mybatis.CartDaoMybaitsImpl;
import com.neuedu.dao.impl.mybatis.UserOrderItemMybatis;
import com.neuedu.dao.impl.mybatis.UserOrderMybatisImpl;
import com.neuedu.dao.impl.mybatis.productDaoMybaitsImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.utils.Utils;

public class OrderServiceImpl implements OrderService {

	UserOrderDao od = new UserOrderMybatisImpl();
	UserOrderItemDao oid = new UserOrderItemMybatis();
	CartDao cd = new CartDaoMybaitsImpl();
	ProductDao pd = new productDaoMybaitsImpl();
	/*UserOrderDao od = new UserOrderDaoImpl();
	UserOrderItemDao oid = new UserOrderItemDaoImpl();
	CartDao cd = new CartDaoImpl();
	productDaoMySql pd = new productDaoMySql();*/

	public boolean createOrder() {

		List<Cart> carts = cd.findCart();
		if (carts == null || carts.size() <= 0) {
			return false;
		}

		UserOrder uorder = createUserOrder();

		List<UserOrderItem> orderItems = new ArrayList<UserOrderItem>();
		for (int i = 0; i < carts.size(); i++) {
			Cart cart = carts.get(i);
			UserOrderItem orderItem = Utils.convertToOrderItem(oid.getOrderItemId(), uorder.getOrder_no(), cart);

			//检验库存
			if (orderItem.getQuantity() <= cart.getProduct().getStock()) {
				orderItems.add(orderItem);
			} else {
				return false;
			}
		}

		uorder.setPayment(getOrderPrice(orderItems));

		od.createOrder(uorder);
		oid.addOrderItem(orderItems);

		//扣库存
		for (int i = 0; i < carts.size(); i++) {
			Cart cart = carts.get(i);
			Product product = cart.getProduct();
			int leftStock = product.getStock() - cart.getProductnum();

			//修改商品库存
			product.setStock(leftStock);
			pd.updateProduct(product);
		}

		//清空购物车
		cd.clearCart();

		return true;
	}


	private double getOrderPrice(List<UserOrderItem> items) {
		double price = 0;
		for (int i = 0; i < items.size(); i++) {
			UserOrderItem ui = items.get(i);
			price += ui.getTotal_price();
		}
		return price;
	}


	private UserOrder createUserOrder() {
		UserOrder uorder = new UserOrder();
		//uorder.setId(od.getOrderId());
		uorder.setOrder_no(orderNo());
		uorder.setCreate_time(System.currentTimeMillis());

		return uorder;
	}


	public long orderNo() {

		return System.currentTimeMillis();
	}


	public List<UserOrder> findOrder() {

		return od.findOrder();
	}

	@Override
	public List<UserOrderItem> findOrderItem() {

		return oid.findOrderItem();
	}

}
