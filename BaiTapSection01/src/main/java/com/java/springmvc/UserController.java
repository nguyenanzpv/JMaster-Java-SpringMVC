package com.java.springmvc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.model.User;
import com.java.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserValidator userValidator;
	
	List<User> lstUser = new ArrayList<User>();
	
	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		User user = new User();
		user.setName("jmaster");
		request.setAttribute("user", user);
		return "addUser";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		
		if(bindingResult.hasErrors()) { return "addUser"; }	
		
		lstUser.add(user);
		//request.setAttribute("user", user);
		request.setAttribute("lstUser", lstUser);
		return "searchUser";
	}
	
	/*
	 * @RequestMapping(value = "/search-user", method = RequestMethod.GET) public
	 * String searchUser(HttpServletRequest request) { User user = new User();
	 * request.setAttribute("user", user); return "searchUser"; }
	 */

	@RequestMapping(value = "/search-user", method = RequestMethod.POST)
	public String searchUser(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult bindingResult) {
		for(User u : lstUser) {
			User userV = u;
			if(user.getName().contains(u.getName())) {
				request.setAttribute("user", userV);
				return "viewUser";
			}
		}
		return "searchUser";
	}
	
	@RequestMapping(value = "/update-user/{name}", method = RequestMethod.GET)
	public String updateUser(HttpServletRequest request, @PathVariable(name="name") String name) {
		for(User u : lstUser) {
			User user = u;
			if(u.getName().contains(name)) {
				request.setAttribute("user", user);
				return "updateUser";
			}
		}
		return "searchUser";
	}

	@RequestMapping(value = "/update-user/{name}", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		
		if(bindingResult.hasErrors()) { return "updateUser"; }	
		lstUser.remove(user);
		lstUser.add(user);
		//request.setAttribute("user", user);
		request.setAttribute("lstUser", lstUser);
		return "searchUser";
	}
	
	@RequestMapping(value = "/delete-user/{name}", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request, @PathVariable(name="name") String name) {
		for(User u : lstUser) {
			User user = u;
			if(u.getName().contains(name)) {
				request.setAttribute("user", user);
				return "deleteUser";
			}
		}
		return "searchUser";
	}

	@RequestMapping(value = "/delete-user/{name}", method = RequestMethod.POST)
	public String deleteUser(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult bindingResult) {
		Iterator itr = lstUser.iterator();
		while(itr.hasNext()) {
			User u = (User) itr.next();
			if(u.getName().contains(user.getName())) {
				itr.remove();
				request.setAttribute("lstUser", lstUser);
				return "searchUser";
			}
		}		
		return "deleteUser";
	}
	
}
