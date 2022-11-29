package com.java.dao;

import java.util.List;

import com.java.entity.User;

public interface UserDao {
	void add(User user);

	void update(User user);

	User getById(int id);

	void delete(int id);

	User getByUsername(String username);

	List<User> getAll();
}
