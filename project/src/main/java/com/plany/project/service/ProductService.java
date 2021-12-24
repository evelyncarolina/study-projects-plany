package com.plany.project.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plany.project.model.ProductModel;
import com.plany.project.repository.ProductRepository;

@Service
public class ProductService {
	
	private @Autowired ProductRepository repository;
	
	public Optional<?> registerProduct(ProductModel productToChange) {
		return repository.findById(productToChange.getIdProduct()).map(productExists -> {
			productExists.setName(productToChange.getName());
			productExists.setDescription(productToChange.getDescription());
			productExists.setPrice(productToChange.getPrice());
			return Optional.ofNullable(repository.save(productExists));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	public Optional<?> updateProduct(@Valid ProductModel updateProduct) {
		// TODO Auto-generated method stub
		return null;
	}

}
