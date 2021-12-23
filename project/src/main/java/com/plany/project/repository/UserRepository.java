package com.plany.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plany.project.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

	public List<UserModel> findAllByNameContainingIgnoreCase(String name);
	Optional<UserModel> findByEmail(String email);
}
