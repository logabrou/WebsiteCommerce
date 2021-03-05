package com.tts.commerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.commerce.model.Product;
import com.tts.commerce.model.User;
import com.tts.commerce.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;	
	
	public List<Product> findAll() {
        return productRepository.findAll();
    }
	
	 public Product findById(long id) {
		 return productRepository.findById(id);
	 }
	 
	 public List<String> findDistinctBrands() {
//		 return productRepository.findDistinctBrands();
		return new ArrayList<>(productRepository.findDistinctBrands());
	 }
	 
	 public List<String> findDistinctCategories() {
//		 return productRepository.findDistinctCategories();
		 return new ArrayList<>(productRepository.findDistinctCategories());
	 }
	 
	 public void save(Product product) {
	        productRepository.save(product);
	 }
	 
	 public void deleteById(long id) {
	        productRepository.deleteById(id);
	 }
	 
	 public List<Product> findByBrandOrCategory(String brand, String category) {	
		 if (brand == null && category == null) {
			 return productRepository.findAll();
		 } else if (category == null) {
			 return productRepository.findByBrand(brand);
		 } else if (brand == null) {
			 return productRepository.findByCategory(category);
		 } else {
			 return productRepository.findByBrandOrCategory(brand, category);
		 }		 
				
	 }
	
	 
	
}
