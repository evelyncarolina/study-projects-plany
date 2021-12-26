package com.plany.project.control;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plany.project.model.ProductModel;
import com.plany.project.repository.ProductRepository;
import com.plany.project.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductControl {
	
	private @Autowired ProductRepository repository;
	private @Autowired ProductService service;
	
	@PostMapping("/created")
	public ResponseEntity<Object> registerProduct(@Valid @RequestBody ProductModel newProduct){
		Optional<Object> objetcOptional = Optional.ofNullable(service.registerProduct(newProduct));
				
		if(objetcOptional.isEmpty()) {
			return ResponseEntity.status(400).build();
		} else {
			return ResponseEntity.status(200).body(objetcOptional.get());
		}	
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long idProduct){
		Optional<ProductModel> productId = repository.findById(idProduct);
		
		if(productId.isEmpty()) {
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}	
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductModel>> getAll() {
		List<ProductModel> listObjetic = repository.findAll();
		if (listObjetic.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listObjetic);
		}
	}
	
	@PutMapping("/update{id}")
	public ResponseEntity<Object> upProduct(@Valid @RequestBody ProductModel upProduct) {
		Optional<?> productUp = service.updateProduct(upProduct);
		
		if (productUp.isPresent()) {
			return ResponseEntity.status(201).body(productUp.get());
		}else {
			return ResponseEntity.status(404).build();
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long idProduct){
		Optional<ProductModel> deteleId = repository.findById(idProduct);
		
		if(deteleId.isEmpty()) {
			return ResponseEntity.status(404).build();
		} else {
			return ResponseEntity.status(200).body(idProduct);
		}
	}
	
}












