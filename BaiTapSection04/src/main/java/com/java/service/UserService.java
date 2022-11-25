package com.java.service;

import java.util.List;

import com.java.model.UserDTO;

public interface UserService {
	void add(UserDTO user);

	void update(UserDTO user);

	void delete(int id);

	UserDTO getById(int id);

	List<UserDTO> getAll();
}
