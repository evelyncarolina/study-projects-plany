package com.plany.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plany.project.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
	public List<ProductModel> findAllByNameContainingIgnoreCase(String name);
}
