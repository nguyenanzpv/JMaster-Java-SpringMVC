package com.java.dao;

import java.util.List;

import com.java.entity.User;

public interface UserDao {
	void add(User user);

    void update(User user);

    void delete(int id);

    User get(int id);

    List<User> getAll();
}
