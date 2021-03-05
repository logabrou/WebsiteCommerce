package com.tts.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.commerce.model.Product;
import com.tts.commerce.service.ProductService;

public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product/{id}")
	public String show(@PathVariable long id, Model model) {
		Product product = productService.findById(id);
		return "product";
	}
	
	@RequestMapping(value = "/product", method = {RequestMethod.POST, RequestMethod.PUT})
	public String createOrUpdate(Product product) {
		productService.save(product);
		return "redirect:/product/" + product.getId();
	}
	

}
