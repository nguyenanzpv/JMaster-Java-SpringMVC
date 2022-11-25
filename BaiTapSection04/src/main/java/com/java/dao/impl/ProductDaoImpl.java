package com.java.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.ProductDao;
import com.java.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void add(Product product) {
		String sql = "INSERT INTO Product(name , price , quantity ,description,img) VALUE(?,?,?,?,?)";
		jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getQuantity(), product.getDescription(),
				product.getImg());
	}

	public void update(Product product) {
		String sql = "INSERT  Product Set name=? , price = ?  , quantity = ? , description = ? , img = ? where id = ? ";
		jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getQuantity(), product.getDescription(),
				product.getImg(), product.getId());
	}

	public void delete(int id) {
		String sql = "DELETE FROM  Product where id = ? ";
		jdbcTemplate.update(sql, id);
	}

	public Product get(int id) {
		String sql = "SELECT * FROM  Product  where id = ? ";
		jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getDouble("price"));
				product.setImg(rs.getString("img"));
				return product;
			}
		});
		return null;
	}

	public List<Product> getAll() {
		String sql = "SELECT * FROM  Product  ";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getDouble("price"));
				product.setImg(rs.getString("img"));
				return product;
			}
		});
	}
}
