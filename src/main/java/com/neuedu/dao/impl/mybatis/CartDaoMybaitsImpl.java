package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CartDaoMybaitsImpl implements CartDao{

    @Override
    public boolean addCart(Cart cart) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        session = sqlMapper.openSession();

        CartDao cartDao=session.getMapper(CartDao.class);
        cartDao.addCart(cart);
        session.commit();
        session.close();
        return false;
    }

    @Override
    public List<Cart> findCart() {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        session=sqlMapper.openSession();

        CartDao cartDao=session.getMapper(CartDao.class);
        List<Cart> cart= cartDao.findCart();
        session.commit();
        session.close();
        return cart;

    }

    @Override
    public boolean updateCart(Cart cart) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        session=sqlMapper.openSession();
        CartDao cartDao=session.getMapper(CartDao.class);
        cartDao.updateCart(cart);
        session.commit();
        session.close();
        return false;
 }

    @Override
    public boolean deleteCart(int id) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        session=sqlMapper.openSession();
        CartDao cartDao=session.getMapper(CartDao.class);
        cartDao.deleteCart(id);
        session.commit();
        session.close();
        return false;

    }

    @Override
    public int getOrderId() {
        return 0;
    }

    @Override
    public Cart getCartById(int id) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        session = sqlMapper.openSession();
        CartDao cartDao=session.getMapper(CartDao.class);
        Cart cart= cartDao.getCartById(id);
        //session.commit();
        session.close();
        return cart;
    }

    @Override
    public void clearCart() {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        session = sqlMapper.openSession();
        CartDao cartDao=session.getMapper(CartDao.class);
        cartDao.clearCart();
        session.commit();
        session.close();
    }
}
