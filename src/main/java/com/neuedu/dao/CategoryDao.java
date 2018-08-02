package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface CategoryDao {


		boolean addCategory(Category category);

		List<Category> findAll();

		boolean updateCategory(Category category);

		boolean deleteCategory(int id);

		Category findCategoryById(int id);

		PageModel<Category> findCategoryByPage(int pageNo, int pageSize);
}
