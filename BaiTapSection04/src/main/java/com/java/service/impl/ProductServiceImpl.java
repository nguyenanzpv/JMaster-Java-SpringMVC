package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.ProductDao;
import com.java.entity.Product;
import com.java.model.ProductDTO;
import com.java.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	public void add(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setDescription(productDTO.getDescription());
		product.setImg(productDTO.getImg());
		productDao.add(product);
	}

	public void update(ProductDTO productDTO) {
		Product product = productDao.get(productDTO.getId());
		if (product != null) {
			product.setName(productDTO.getName());
			product.setQuantity(productDTO.getQuantity());
			product.setPrice(productDTO.getPrice());
			product.setDescription(productDTO.getDescription());
			product.setImg(productDTO.getImg());
			productDao.update(product);
		}
	}

	public void delete(int id) {
		Product product = productDao.get(id);
		if (product != null) {
			productDao.delete(id);
		}
	}

	public ProductDTO getById(int id) {
		Product product = productDao.get(id);
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(id);
		productDTO.setName(product.getName());
		productDTO.setQuantity(product.getQuantity());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		productDTO.setImg(product.getImg());

		return productDTO;
	}

	public List<ProductDTO> getAll() {
		List<Product> products = productDao.getAll();
		List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();

			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setQuantity(product.getQuantity());
			productDTO.setPrice(product.getPrice());
			productDTO.setDescription(product.getDescription());
			productDTO.setImg(product.getImg());

			productDTOS.add(productDTO);
		}
		return productDTOS;
	}

}
