package com.java.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.model.UserDTO;
import com.java.service.UserService;

@Controller
public class Login {
	@Autowired
	UserService userService;
	private static Logger logger = Logger.getLogger(Login.class);
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public String LoginPage(HttpServletRequest request, @RequestParam(value = "err", required = false) String err) {
		if (err != null && err.equals("100")) {
			request.setAttribute("msg", "Tài khoản hoặc mật khẩu sai");
			logger.error(err);
		}
		return "login";
	}

	/*
	 * @RequestMapping(value = "/dang-nhap", method = RequestMethod.POST) public
	 * String login(HttpServletRequest request, @ModelAttribute UserDTO user) {
	 * request.setAttribute("user", user); UserDTO user2 =
	 * userService.getByUsername(user.getUsername()); if (user2 != null &&
	 * user2.getPassword().equals(user.getPassword())) { return
	 * "redirect:/admin/list-user"; } return "redirect:/dang-nhap?err=100"; }
	 */
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/dang-nhap";
	}

}
