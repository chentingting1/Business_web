package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.UserOrderItemDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrderItem;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class productDaoMybaitsImpl implements ProductDao{



    @Override
    public boolean addProduct(Product product) {
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

        ProductDao productDao=session.getMapper(ProductDao.class);
        productDao.addProduct(product);
        session.commit();
        session.close();
        return false;
   }

    @Override
    public List<Product> findAll() {

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
        ProductDao productDao=session.getMapper(ProductDao.class);
        List<Product> products=productDao.findAll();
        session.close();
        return products;
    }

    @Override
    public boolean updateProduct(Product product) {

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

        ProductDao productDao=session.getMapper(ProductDao.class);

        productDao.updateProduct(product);
        session.commit();
        session.close();
        return false;

    }

    @Override
    public boolean deleteProduct(int id) {

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
        ProductDao productDao=session.getMapper(ProductDao.class);
        productDao.deleteProduct(id);
        session.commit();
        session.close();
        return false;

    }

    @Override
    public Product findProductById(int id) {
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
        ProductDao productDao=session.getMapper(ProductDao.class);
        Product products=productDao.findProductById(id);
        session.commit();
        session.close();
        return products;

}

    @Override
    public PageModel<Product> findProductByPage(int pageNo, int pageSize) {

        return null;
    }

    //扣除库存
    @Override
    public void deletestock(Product product) {

    }

}
