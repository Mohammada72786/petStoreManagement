package com.anmlmanagement.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anmlmanagement.dao.PetStoreDao;
import com.anmlmanagement.dao.FoodDao;
import com.anmlmanagement.model.PetStore;
import com.anmlmanagement.model.Food;
import com.anmlmanagement.model.PetStore;
import com.anmlmanagement.service.PetStoreService;
import com.anmlmanagement.service.FoodService;
import com.anmlmanagement.util.constant.Gender;
import com.anmlmanagement.util.exception.AnimalManagementException;

@Service
public class PetStoreServiceImpl implements PetStoreService {

	@Autowired
	private PetStoreDao petStoreDao;
	@Autowired
	private FoodService foodService;

	@Override
	public void save(PetStore petStore) throws AnimalManagementException {
		petStoreDao.save(petStore);
	}

	public List<PetStore> findAll() throws AnimalManagementException {
		return petStoreDao.findAll();
	}

	public PetStore findById(int id) throws AnimalManagementException {
		return petStoreDao.findById(id);
	}

	public List<PetStore> findByName(String name) throws AnimalManagementException {
		return petStoreDao.findByName(name);
	}
	
	public void updatePetStore(PetStore petStore, int id) throws AnimalManagementException{
		try {
			PetStore oldPetStore = petStoreDao.findById(id);
			oldPetStore.setName(petStore.getName());
			oldPetStore.setAddress(petStore.getAddress());
			petStoreDao.save(oldPetStore);
		}catch(Exception exception) {
			throw new AnimalManagementException(exception.getMessage());
		}
	}
	
	public void deleteById(int id) throws AnimalManagementException{
		try {
			petStoreDao.deleteById(id);
		}catch(Exception exception) {
			throw new AnimalManagementException("Error while deleting");
		}
	}
}
