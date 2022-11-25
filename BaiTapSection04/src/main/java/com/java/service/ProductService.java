package com.java.service;

import java.util.List;

import com.java.model.ProductDTO;

public interface ProductService {
	void add(ProductDTO product);

	void update(ProductDTO product);

	void delete(int id);

	ProductDTO getById(int id);

	List<ProductDTO> getAll();
}
