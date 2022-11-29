package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDao;
import com.java.entity.User;
import com.java.model.UserDTO;
import com.java.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void add(UserDTO userDTO) {
		User user = new User();

		user.setId(userDTO.getId());
		user.setFullname(userDTO.getFullname());
		user.setAddress(userDTO.getAddress());
		user.setImage(userDTO.getImage());
		user.setInfomation(userDTO.getInfomation());
		user.setPassword(userDTO.getPassword());
		user.setUsername(userDTO.getUsername());
		user.setPhone(userDTO.getPhone());

		userDao.add(user);

	}

	public void update(UserDTO userDTO) {
		User user = userDao.getById(userDTO.getId());
		if (user != null) {
			user.setId(userDTO.getId());
			user.setFullname(userDTO.getFullname());
			user.setAddress(userDTO.getAddress());
			user.setImage(userDTO.getImage());
			user.setInfomation(userDTO.getInfomation());
			user.setPassword(userDTO.getPassword());
			user.setUsername(userDTO.getUsername());
			user.setPhone(userDTO.getPhone());

			userDao.update(user);
		}

	}

	public UserDTO getById(int id) {
		User userEntity = userDao.getById(id);
		UserDTO user = new UserDTO();
		user.setId(userEntity.getId());
		user.setFullname(userEntity.getFullname());
		user.setAddress(userEntity.getAddress());
		user.setImage(userEntity.getImage());
		user.setInfomation(userEntity.getInfomation());
		user.setPassword(userEntity.getPassword());
		user.setUsername(userEntity.getUsername());
		user.setPhone(userEntity.getPhone());
		return user;
	}

	public void delete(int id) {
		User user = userDao.getById(id);
		if (user != null) {
			userDao.delete(id);
		}

	}

	public UserDTO getByUsername(String username) {
		User user = userDao.getByUsername(username);
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFullname(user.getFullname());
		userDTO.setAddress(user.getAddress());
		userDTO.setImage(user.getImage());
		userDTO.setInfomation(user.getInfomation());
		userDTO.setPassword(user.getPassword());
		userDTO.setUsername(user.getUsername());
		userDTO.setPhone(user.getPhone());
		return userDTO;
	}

	public List<UserDTO> getAll() {
		List<User> users = userDao.getAll();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setFullname(user.getFullname());
			userDTO.setAddress(user.getAddress());
			userDTO.setImage(user.getImage());
			userDTO.setInfomation(user.getInfomation());
			userDTO.setPassword(user.getPassword());
			userDTO.setUsername(user.getUsername());
			userDTO.setPhone(user.getPhone());
			userDTOs.add(userDTO);
		}

		return userDTOs;
	}

}
