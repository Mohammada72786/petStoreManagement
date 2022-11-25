package com.anmlmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anmlmanagement.model.PetStore;

public interface PetStoreDao extends JpaRepository<PetStore, Integer>{
	
	
	public PetStore save(PetStore petStore);
	
	@Query(value="select * from petStore where is_deleted='0' and name=:name", nativeQuery = true)
	public List<PetStore> findByName(String name);
	
	@Query(value="select * from petStore where is_deleted='0'", nativeQuery = true)
	public List<PetStore> findAll();
	
	@Query(value="select * from petStore where is_deleted='0' and id=:petStoreId", nativeQuery=true)
	public PetStore findById(int petStoreId);
	
	public void deleteById(int id);
}
