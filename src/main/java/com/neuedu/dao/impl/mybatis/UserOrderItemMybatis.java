package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.UserOrderDao;
import com.neuedu.dao.UserOrderItemDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserOrderItemMybatis implements UserOrderItemDao {
    @Override
    public boolean addOrderItem(List<UserOrderItem> orderItem) {
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
        UserOrderItemDao userOrderItemDao=session.getMapper(UserOrderItemDao.class);
        userOrderItemDao.addOrderItem(orderItem);
        session.commit();
        session.close();
        return false;

    }

    @Override
    public List<UserOrderItem> findOrderItem() {
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
        UserOrderItemDao userOrderItemDao=session.getMapper(UserOrderItemDao.class);
        List<UserOrderItem> userOrderItems=userOrderItemDao.findOrderItem();
        session.close();
        return userOrderItems;
    }



    @Override
    public int getOrderItemId() {
        return 0;
    }

}
