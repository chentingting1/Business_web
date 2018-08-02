package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.UserOrderDao;
import com.neuedu.entity.UserOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserOrderMybatisImpl implements UserOrderDao {
    @Override
    public boolean createOrder(UserOrder order) {
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
        UserOrderDao userOrderDao=session.getMapper(UserOrderDao.class);
        userOrderDao.createOrder(order);
        session.commit();
        session.close();
        return false;

    }

    @Override
    public List<UserOrder> findOrder() {
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
        UserOrderDao userOrderDao=session.getMapper(UserOrderDao.class);
        List<UserOrder> userOrders=userOrderDao.findOrder();
        session.close();
        return userOrders;
    }


    @Override
    public int getOrderId() {
        return 0;
    }
}
