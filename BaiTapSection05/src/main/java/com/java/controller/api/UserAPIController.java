package com.java.controller.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.model.UserDTO;
import com.java.service.UserService;

@RestController
public class UserAPIController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/api-add-user", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addUser(HttpServletRequest httpServletRequest, @RequestBody UserDTO user) throws IOException {
		MultipartFile file = user.getAvatar();
		File newFile = new File(
				"C:\\nntan\\Project\\ASPNETCORE\\Jmaster\\Java-SpringMVC\\JMaster-Java-SpringMVC\\BaiTapSection05\\src\\main\\webapp\\resources\\images\\"
						+ file.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();

		user.setImage(file.getOriginalFilename());

		userService.add(user);
	}
	
	@RequestMapping(value="/api-list-user", method = RequestMethod.GET)
	public List<UserDTO> getAllUser(HttpServletRequest httpServletRequest){
		List<UserDTO> allUsers = userService.getAll();
		return allUsers;
	}
	
	@RequestMapping(value="/api-user/{userId}", method = RequestMethod.GET)
	public UserDTO getUserById(HttpServletRequest httpServletRequest, @PathVariable(value = "userId") int userId){
		UserDTO user = userService.getById(userId);
		return user;
	}
	
	@RequestMapping(value="/api-user/delete/{userId}", method = RequestMethod.DELETE)
	public void delete(HttpServletRequest httpServletRequest, @PathVariable(value = "userId") int userId){
		userService.delete(userId);
	}
	
	@RequestMapping(value="/api-user/update", method = RequestMethod.POST)
	public void update(HttpServletRequest httpServletRequest, @RequestBody UserDTO user){
		userService.update(user);
	}
}
