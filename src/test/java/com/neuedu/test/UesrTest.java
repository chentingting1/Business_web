package com.neuedu.test;

import com.neuedu.dao.*;
import com.neuedu.dao.impl.mybatis.*;
import com.neuedu.entity.Product;
import org.junit.Test;



public class UesrTest {

    @Test
    public void tsetLogin(){
        LoginDao loginDao=new LoginMybatisImpl();
        loginDao.LogonLogic("admin","21232f297a57a5a743894a0e4a801fc3");

    }

    @Test
    public void tsetProduct(){
        ProductDao productDao=new productDaoMybaitsImpl();

        Product p = new Product("qw","qw",123,"123",12);
        productDao.addProduct(p);
        System.out.println(productDao.findProductById(1));
        Product pr = new Product(1,"shouji","haoka",123,"shoiji",123);
        productDao.updateProduct(pr);
        productDao.deleteProduct(2);

    }
}

