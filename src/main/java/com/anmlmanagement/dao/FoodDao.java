package com.anmlmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anmlmanagement.model.Food;

public interface FoodDao extends JpaRepository<Food, Integer>{
	public List<Food> findByName(String name);
	public List<Food> findAll();
	public Food findById(int id);
	public void deleteById(int id);
	

}
