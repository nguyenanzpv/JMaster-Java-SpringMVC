package com.java.service;

import java.util.List;

import com.java.model.UserDTO;

public interface UserService {
	public void add(UserDTO userDTO);

	public void update(UserDTO userDTO);

	public void delete(int id);

	public UserDTO getById(int id);

	public UserDTO getByUsername(String username);

	List<UserDTO> getAll();
}
