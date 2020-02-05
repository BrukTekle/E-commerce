package edu.mum.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.domain.Catagory;
import edu.mum.domain.Product;
import edu.mum.service.CatagoryService;
import edu.mum.service.ProductService;
@Controller
public class ProductController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	ProductService productService;
	@Autowired
	CatagoryService catagoryService;
	
    @RequestMapping({"/addProduct"})
    public String addProduct(@ModelAttribute("newProduct") Product product,Model model) {
    	model.addAttribute("categoryList",catagoryService.findAllCatagories());
    	System.out.println(catagoryService.findAllCatagories());
        return "addProduct";
    }
    
    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("newProduct") Product product, Model model,HttpServletRequest request) throws FileNotFoundException {
    	
//    	MultipartFile multipartFile=product.getProductImage();
////    	byte[] multipartFile=product.getProductImage();
//    	    	
//		if(multipartFile != null || !multipartFile.isEmpty()){
//			String filename=servletContext.getRealPath("/"+"resources\\images\\"+multipartFile.getOriginalFilename());
//			try {
//				multipartFile.transferTo(new File(filename));
//				System.out.println(filename);
//			}
//			catch (IOException e) {
//				throw new FileNotFoundException("Unable to save image: " + multipartFile.getOriginalFilename() );
//			}
//			
//		}
//		
//		try {
//			productService.addProduct(product);
//		} catch (Exception up) {
//	     System.out.println("Transaction Failed!!!");
	
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage!=null && !productImage.isEmpty()) {
	       try {
		      	productImage.transferTo(new File(rootDirectory + File.separator  + "resources" + File.separator  
		                   + "images" + File.separator + product.getId() + ".png"));
	       } catch (Exception e) {
			throw new RuntimeException("Product Image saving failed", e);
	       }
	   }

	try {
		productService.addProduct(product);
	} catch (Exception up) {
     System.out.println("Transaction Failed!!!");

	}
       
		 return "index";
}
	
	
	
	
	@RequestMapping(value="/productList", method = RequestMethod.GET)
    public String listProduct(Model model) {
    	
    	
		List<Product> list = productService.getAllProducts();
		model.addAttribute("product",  list);
		
		
    	return "products";
	
	
	}
	
	@RequestMapping(value="/productDetail", method = RequestMethod.POST)
    public String productDetail(@ModelAttribute("product")Product product ,Model model , @RequestParam("id") Long productId) {
    	
		productService.getProductById(productId);
		model.addAttribute(product);
		
		
    	return "productDetail";
	
	
	}
	
}
