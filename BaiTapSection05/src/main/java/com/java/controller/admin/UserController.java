package com.java.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.model.UserDTO;
import com.java.service.UserService;
import com.java.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(HttpServletRequest httpServletRequest) {

		httpServletRequest.setAttribute("user", new UserDTO());
		return "addUser";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(HttpServletRequest httpServletRequest, @ModelAttribute(value = "user") UserDTO user,
			BindingResult bindingResult) throws IOException {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "addUser";
		}
		MultipartFile file = user.getAvatar();
		File newFile = new File(
				"C:\\nntan\\Project\\ASPNETCORE\\Jmaster\\Java-SpringMVC\\JMaster-Java-SpringMVC\\BaiTapSection05\\src\\main\\webapp\\resources\\images\\"
						+ file.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();

		user.setImage(file.getOriginalFilename());

		userService.add(user);
		return "redirect:/user/list-user";
	}

//    @RequestMapping(value = "/view-users", method = RequestMethod.GET)
//    public @ResponseBody List<UserDTO> viewUsers(HttpServletRequest httpServletRequest){
//        List<UserDTO> allUsers = userService.getAllUsers();
//        return allUsers;
//    }

	@RequestMapping(value = "/list-user", method = RequestMethod.GET)
	public String getAllUsers(HttpServletRequest httpServletRequest) {
		List<UserDTO> users = userService.getAll();
		httpServletRequest.setAttribute("users", users);
		return "viewUser";
	}

	@RequestMapping(value = "/detail/{userId}", method = RequestMethod.GET)
	public String inDetail(HttpServletRequest request, @PathVariable(name = "userId") int userId) {
		UserDTO uDTO = userService.getById(userId);
		request.setAttribute("user", uDTO);
		return "viewUserInDetail";
	}

	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public String editUser(HttpServletRequest request, @PathVariable(name = "userId") int userId) {
		request.setAttribute("user", userService.getById(userId));
		return "editUser";//tra ve tile view
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUser(HttpServletRequest httpServletRequest, @ModelAttribute(value = "user") UserDTO user,
			BindingResult bindingResult) throws IOException {
		/*
		 * userValidator.validate(user, bindingResult); if (bindingResult.hasErrors()) {
		 * return "editUser"; }
		 */
		MultipartFile file = user.getAvatar();
		File newFile = new File(
				"C:\\nntan\\Project\\ASPNETCORE\\Jmaster\\Java-SpringMVC\\JMaster-Java-SpringMVC\\BaiTapSection05\\src\\main\\webapp\\resources\\images\\"
						+ file.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();

		user.setImage(file.getOriginalFilename());
		userService.update(user);
		return "redirect:/user/list-user";
	}

	@RequestMapping("/delete/{userId}")
	public String deleteUser(HttpServletRequest request, @PathVariable(name = "userId") int userId) {

		userService.delete(userId);
		return "redirect:/user/list-user";
	}

}
