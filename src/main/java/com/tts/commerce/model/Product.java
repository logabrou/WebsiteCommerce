package com.tts.commerce.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	  
	  private int quantity;
	  
	  private double price;
	  
	  @NotEmpty(message = "Please provide a description")
	  private String description;
	  
	  @NotEmpty(message = "Please provide a name")
	  private String name;
	  
	  @NotEmpty(message = "Please provide a brand")
	  private String brand;
	  
	  @NotEmpty(message = "Please provide a category")
	  private String category;
	  
	  @NotEmpty(message = "Please provide a brand")
	  private String imageUrl;
	
}
