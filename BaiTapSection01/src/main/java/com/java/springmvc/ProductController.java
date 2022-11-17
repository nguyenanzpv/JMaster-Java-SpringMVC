package com.java.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.model.Product;

@Controller
public class ProductController {
	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public String addProduct(HttpServletRequest request) {
		Product product = new Product();
		product.setName("adidas");
		request.setAttribute("product", product);
		return "addProduct";
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request, @ModelAttribute("product") Product product,
			BindingResult bindingResult) {
		request.setAttribute("product", product);
		return "viewProduct";
	}
	
	@RequestMapping(value="/update-product", method = RequestMethod.GET)
	public String updateProduct(HttpServletRequest request) {
		Product product = new Product();
		product.setName("adidas");
		product.setPrice(100);
		product.setQuantity(10);
		request.setAttribute("product", product);
		return "updateProduct";
	}
	
	@RequestMapping(value = "/update-product", method = RequestMethod.POST)
	public String updateProduct(HttpServletRequest request, @ModelAttribute("product") Product product,
			BindingResult bindingResult) {
		request.setAttribute("product", product);
		return "viewProduct";
	}
	
	@RequestMapping(value = "/delete-product", method = RequestMethod.POST)
	public String DeleteProduct(HttpServletRequest request, @ModelAttribute("product") Product product,
			BindingResult bindingResult) {
		request.removeAttribute("product");
		return "viewProduct";
	}
	
	@RequestMapping(value = "/search-product", method = RequestMethod.GET)
	public String searchProduct(HttpServletRequest request) {
		Product product = new Product();
		//product.setName("adidas");
		request.setAttribute("product", product);
		return "searchProduct";
	}

	@RequestMapping(value = "/search-product", method = RequestMethod.POST)
	public String searchProduct(HttpServletRequest request, @ModelAttribute("product") Product product,
			BindingResult bindingResult) {
		//request.setAttribute("product", product);
		request.setAttribute("product", request.getAttribute("product"));
		return "viewProduct";
	}
}
