package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.UserDao;
import com.java.entity.User;
import com.java.model.UserDTO;
import com.java.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	public void add(UserDTO userDTO) {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setRole(userDTO.getRole());
		user.setImg(userDTO.getImg());

		userDao.add(user);
	}

	public void update(UserDTO userDTO) {
		User user = userDao.get(userDTO.getId());
		if (user != null) {
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setRole(userDTO.getRole());
			user.setImg(userDTO.getImg());
			userDao.update(user);
		}
	}

	public void delete(int id) {
		User user = userDao.get(id);
		if (user != null) {
			userDao.delete(id);
		}
	}

	public UserDTO getById(int id) {
		User user = userDao.get(id);
		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole());
		userDTO.setImg(user.getImg());

		return userDTO;
	}

	public List<UserDTO> getAll() {
		List<User> users = userDao.getAll();
		List<UserDTO> userDTOS = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setRole(user.getRole());
			userDTO.setImg(user.getImg());
			userDTOS.add(userDTO);
		}
		return userDTOS;
	}

}
