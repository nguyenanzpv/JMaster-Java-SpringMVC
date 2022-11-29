package com.java.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Download {
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void Download(@RequestParam(value = "image") String image) {

	}
}
