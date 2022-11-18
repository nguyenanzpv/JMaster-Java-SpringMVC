package com.java.springmvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.java.model.Product;
import com.java.validator.ProductValidator;

@Controller
public class ProductController {
	@Autowired
	private ProductValidator productValidator;
	
	List<Product> lstProduct = new ArrayList<Product>();
	
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
		productValidator.validate(product, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addProduct";
		}
		lstProduct.add(product);
		//lay file luu xuong o cung
		MultipartFile file = product.getImageUrl();
		try {
			File newFile = new File("C:\\nntan\\Project\\ASPNETCORE\\Jmaster\\Java-SpringMVC\\JMaster-Java-SpringMVC\\BaiTapSection03\\src\\main\\resources\\FileUpload\\"+file.getOriginalFilename());
			FileOutputStream fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lstProduct", lstProduct);
		return "searchProduct";
	}
	
	@RequestMapping(value="/update-product/{name}", method = RequestMethod.GET)
	public String updateProduct(HttpServletRequest request, @PathVariable(name ="name") String name) {
		Iterator itr = lstProduct.iterator();
		while(itr.hasNext()) {
			Product p = (Product) itr.next();
			if(p.getName().equals(name)) {
				request.setAttribute("product", p);
				return "updateProduct";
			}
		}	
		return "searchProduct";
	}
	
	@RequestMapping(value = "/update-product/{name}", method = RequestMethod.POST)
	public String updateProduct(HttpServletRequest request, @ModelAttribute("product") Product product,
			BindingResult bindingResult) {
		productValidator.validate(product, bindingResult);
		if(bindingResult.hasErrors()) {
			request.setAttribute("product", product);
			return "updateProduct";
		}
		Iterator itr = lstProduct.iterator();
		while(itr.hasNext()) {
			Product p = (Product) itr.next();
			if(p.getName().equals(product.getName())) {
				itr.remove();
				lstProduct.add(product);
				request.setAttribute("lstProduct", lstProduct);
				return "searchProduct";
			}
		}	
		return "searchProduct";
	}
	
	@RequestMapping(value = "/delete-product/{name}", method = RequestMethod.GET)
	public String deleteProduct(HttpServletRequest request, @PathVariable(name="name") String name) {
		for(Product p : lstProduct) {
			Product prod = p;
			if(p.getName().contains(name)) {
				request.setAttribute("product", prod);
				return "deleteProduct";
			}
		}
		return "searchProduct";
	}
	
	@RequestMapping(value = "/delete-product/{name}", method = RequestMethod.POST)
	public String deleteProduct(HttpServletRequest request, @ModelAttribute("product") Product product,
			BindingResult bindingResult) {
		
		Iterator itr = lstProduct.iterator();
		while(itr.hasNext()) {
			Product p = (Product) itr.next();
			if(p.getName().equals(product.getName())) {
				itr.remove();
				request.setAttribute("lstProduct", lstProduct);
				return "searchProduct";
			}
		}	
		return "searchProduct";
	}
	

	  @RequestMapping(value = "/search-product", method = RequestMethod.GET) 
	  public String searchProduct(HttpServletRequest request) 
	  { 
		  if(lstProduct.size()>0) {
			  request.setAttribute("lstProduct", lstProduct);
			  return "searchProduct"; 
		  }
		  else {
			  return "searchProduct";
		  }
	  }
	 

	@RequestMapping(value = "/search-product", method = RequestMethod.POST)
	public String searchProduct(HttpServletRequest request, @ModelAttribute("product") Product product,
			BindingResult bindingResult) {
		Iterator itr = lstProduct.iterator();
		while(itr.hasNext()) {
			Product p = (Product) itr.next();
			if(p.getName().equals(product.getName())) {
				request.setAttribute("product", p);
				return "viewProduct";
			}
		}	
		return "searchProduct";
	}
	
	 @RequestMapping(value = "/download-file/{name}", method = RequestMethod.GET) 
	  public void downloadFile(HttpServletRequest request, HttpServletResponse response,@PathVariable(name="name")String name) 
	  { 
		 
		  String dataDirectory = "C:\\nntan\\Project\\ASPNETCORE\\Jmaster\\Java-SpringMVC\\JMaster-Java-SpringMVC\\BaiTapSection03\\src\\main\\resources\\FileUpload\\";
		  Path file = Paths.get(dataDirectory,name+".png");
		  if(Files.exists(file)) {
			  response.setContentType("image/png");
			  response.addHeader("Content-Disposition", "attachment;filename=anh.png");
			  try {
				  Files.copy(file, response.getOutputStream());
				  response.getOutputStream().flush();
			  }catch(IOException e) {
				  e.printStackTrace();
			  }
		  }
	  }
}
