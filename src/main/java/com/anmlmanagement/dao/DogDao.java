package com.anmlmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anmlmanagement.model.Dog;
import com.anmlmanagement.util.exception.AnimalManagementException;

public interface DogDao extends JpaRepository<Dog, Integer>{
	
	
	public Dog save(Dog dog);
	
	@Query(value="select * from dog where is_deleted='0' and name=:name", nativeQuery = true)
	public List<Dog> findByName(String name);
	
	@Query(value="select * from dog where is_deleted='0'", nativeQuery = true)
	public List<Dog> findAll();
	
	@Query(value="select * from dog where is_deleted='0' and id=:dogId", nativeQuery=true)
	public Dog findById(int dogId);
	
	public void deleteById(int id);
}
