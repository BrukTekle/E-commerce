package edu.mum.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.domain.Catagory;
import edu.mum.domain.Product;
import edu.mum.service.ProductService;
@Controller
public class ProductController {
	
	ProductService productSevice;
	
	
	
	@RequestMapping(value="/productList", method = RequestMethod.GET)
    public String listProduct(Model model) {
    	
    	
		List<Product> list = productSevice.findAllProducts();
		model.addAttribute("product",  list);
		
		
    	return "products";
	
	
	}
	
	@RequestMapping(value="/productDetail", method = RequestMethod.POST)
    public String productDetail(@ModelAttribute("product")Product product ,Model model , @RequestParam("id") int productId) {
    	
 productSevice.findOne(productId);
		model.addAttribute(product);
		
		
    	return "productDetail";
	
	
	}
	
}
