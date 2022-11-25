package com.java.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.java.model.ProductDTO;
import com.java.service.ProductService;
import com.java.validator.ProductValidator;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductValidator productValidator;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct(HttpServletRequest httpServletRequest) {

		httpServletRequest.setAttribute("product", new ProductDTO());
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest httpServletRequest, @ModelAttribute("product") ProductDTO product,
			BindingResult bindingResult) throws IOException {
		productValidator.validate(product, bindingResult);
		if (bindingResult.hasErrors()) {
			return "addProduct";
		}
		MultipartFile file = product.getImageUrl();
		File newFile = new File(
				"C:\\nntan\\Project\\ASPNETCORE\\Jmaster\\Java-SpringMVC\\JMaster-Java-SpringMVC\\BaiTapSection04\\src\\main\\webapp\\resources\\images\\"
						+ file.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();

		product.setImg(file.getOriginalFilename());
		productService.add(product);
		return "redirect:/product/view-product";
	}

	@RequestMapping(value = "/view-product", method = RequestMethod.GET)
	public String getAllUsers(HttpServletRequest httpServletRequest) {

		List<ProductDTO> prodcuts = productService.getAll();
		httpServletRequest.setAttribute("prodcuts", prodcuts);
		return "viewProduct";
	}

	@RequestMapping(value = "/detail/{productId}", method = RequestMethod.GET)
	public String inDetail(HttpServletRequest request, @PathVariable(name = "productId") int productId) {
		request.setAttribute("product", productService.getById(productId));
		return "viewProductInDetail";
	}

	@RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
	public String editUser(HttpServletRequest request, @PathVariable(name = "productId") int productId) {

		request.setAttribute("product", productService.getById(productId));
		return "editProduct";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUser(HttpServletRequest httpServletRequest, @ModelAttribute(value = "product") ProductDTO product,
			BindingResult bindingResult) throws IOException {
		productValidator.validate(product, bindingResult);
		if (bindingResult.hasErrors()) {
			return "editProduct";
		}
		MultipartFile file = product.getImageUrl();
		File newFile = new File(
				"C:\\nntan\\Project\\ASPNETCORE\\Jmaster\\Java-SpringMVC\\JMaster-Java-SpringMVC\\BaiTapSection04\\src\\main\\webapp\\resources\\images\\"
						+ file.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();

		product.setImg(file.getOriginalFilename());
		productService.update(product);
		return "redirect:/product/view-product";
	}

	@RequestMapping("/delete/{productId}")
	public String deleteProduct(HttpServletRequest httpServletRequest,
			@PathVariable(name = "productId") int productId) {

		productService.delete(productId);
		return "redirect:/product/view-product";
	}
}
