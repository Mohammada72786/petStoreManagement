package com.anmlmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anmlmanagement.model.PetStore;

public interface PetStoreDao extends JpaRepository<PetStore, Integer>{
	
	public List<PetStore> findByName(String name);
}
