package com.plany.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ProductModel {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idProduct;
	private @NotBlank String name;
	private @NotBlank String description;
	private @NotNull Double price;
	
	
	

}
