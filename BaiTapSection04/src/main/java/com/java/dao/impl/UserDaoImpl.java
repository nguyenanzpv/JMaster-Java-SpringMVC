package com.java.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.UserDao;
import com.java.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void add(User user) {
		String sql = "INSERT INTO User(username , password , role ,img) VALUE(?,? , ? ,?)";
		jdbcTemplate.update(sql, user.getUsername(),user.getPassword(), user.getRole(),user.getImg());
	}

	public void update(User user) {
		String sql = "Update  User Set username=? , password = ?  and role = ? , img = ? where id = ? ";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getRole(), user.getImg(),  user.getId());
	}

	public void delete(int id) {
		String sql = "DELETE FROM  User where id = ? ";
		jdbcTemplate.update(sql, id);
	}

	public User get(int id) {
		String sql = "SELECT * FROM  User  where id = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setImg(rs.getString("img"));
				user.setRole(rs.getString("role"));
				return user;
			}
		});
	}

	public List<User> getAll() {
		String sql = "SELECT * FROM  User  ";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setImg(rs.getString("img"));
				user.setRole(rs.getString("role"));
				return user;
			}
		});
	}

}
