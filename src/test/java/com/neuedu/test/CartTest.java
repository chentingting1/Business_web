package com.neuedu.test;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.mybatis.CartDaoMybaitsImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

    CartDao cartDao=null;

    @Before
    public void before(){

        cartDao=new CartDaoMybaitsImpl();
    }

    @Test
    public void tsetCart(){

        Cart cart = new Cart();
        Product product=new Product(1,"shouji","haoka",123.00,"shouji",123);
        cart.setProduct(product);
        cart.setProductnum(10);
        cartDao.addCart(cart);

       /*  System.out.println(cartDao.findCart());

       System.out.println(cartDao.getCartById(1));
        Cart carts=new Cart(1,1,12);
        cartDao.updateCart(carts);
        cartDao.deleteCart(1);*/

    }
    @After
    public void after(){
        cartDao=null;
    }


}
