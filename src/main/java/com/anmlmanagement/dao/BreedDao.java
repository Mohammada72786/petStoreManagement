package com.anmlmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anmlmanagement.model.Breed;

public interface BreedDao extends JpaRepository<Breed, Integer> {
	
	
	public Breed save(Breed breed);
	
	@Query(value="select * from breed where is_deleted='0' and name=:name", nativeQuery = true)
	public List<Breed> findByName(String name);
	
	@Query(value="select * from breed where is_deleted='0'", nativeQuery = true)
	public List<Breed> findAll();
	
	@Query(value="select * from breed where is_deleted='0' and id=:breedId", nativeQuery=true)
	public Breed findById(int breedId);
	
	public void deleteById(int id);
}
