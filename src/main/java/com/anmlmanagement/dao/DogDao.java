package com.anmlmanagement.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anmlmanagement.model.Dog;

public interface DogDao extends JpaRepository<Dog, Integer>{
	public List<Dog> findByName(String name);
	
}
