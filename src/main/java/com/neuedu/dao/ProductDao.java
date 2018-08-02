package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductDao {

	boolean addProduct(Product product);

	List<Product> findAll();

	boolean updateProduct(Product product);

	boolean deleteProduct(int id);

	Product findProductById(int id);

	PageModel<Product> findProductByPage(int pageNo, int pageSize);

    void deletestock(Product product);
}
