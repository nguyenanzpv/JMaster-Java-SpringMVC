package com.java.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello") //annotation map /hello voi method sayHello
	public String sayHello(ModelMap map) {
		//su dung ModelMap truyen du lieu qua view
		map.addAttribute("msg","Trung Tam Java");
		return "hello"; // tra model ve view hello.jsp
	}
}
