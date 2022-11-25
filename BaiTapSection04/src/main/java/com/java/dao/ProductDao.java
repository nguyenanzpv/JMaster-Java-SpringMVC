package com.java.dao;

import java.util.List;

import com.java.entity.Product;

public interface ProductDao {
	 void add(Product product);

	 void update(Product product);

	 void delete(int id);

	 Product get(int id);

	 List<Product> getAll();
}
