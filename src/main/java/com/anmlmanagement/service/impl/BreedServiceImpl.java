package com.anmlmanagement.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anmlmanagement.dao.BreedDao;
import com.anmlmanagement.dao.FoodDao;
import com.anmlmanagement.model.Breed;
import com.anmlmanagement.model.Food;
import com.anmlmanagement.model.PetStore;
import com.anmlmanagement.service.BreedService;
import com.anmlmanagement.service.FoodService;
import com.anmlmanagement.util.constant.Gender;
import com.anmlmanagement.util.exception.AnimalManagementException;

@Service
public class BreedServiceImpl implements BreedService {

	@Autowired
	private BreedDao breedDao;
	@Autowired
	private FoodService foodService;

	@Override
	public void save(Breed breed) throws AnimalManagementException {
		breedDao.save(breed);
	}

	public List<Breed> findAll() throws AnimalManagementException {
		return breedDao.findAll();
	}

	public Breed findById(int id) throws AnimalManagementException {
		return breedDao.findById(id);
	}

	public List<Breed> findByName(String name) throws AnimalManagementException {
		return breedDao.findByName(name);
	}
	
	public void updateBreed(Breed breed, int id) throws AnimalManagementException{
		try {
			Breed oldBreed = breedDao.findById(id);
			oldBreed.setName(breed.getName());
			oldBreed.setCountryOfOrigin(breed.getCountryOfOrigin());
			breedDao.save(oldBreed);
		}catch(Exception exception) {
			throw new AnimalManagementException(exception.getMessage());
		}
	}
	
	public void deleteById(int id) throws AnimalManagementException{
		try {
			breedDao.deleteById(id);
		}catch(Exception exception) {
			throw new AnimalManagementException("Error while deleting");
		}
	}
}
