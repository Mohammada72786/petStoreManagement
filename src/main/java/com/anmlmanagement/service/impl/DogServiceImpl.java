package com.anmlmanagement.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anmlmanagement.dao.DogDao;
import com.anmlmanagement.dao.FoodDao;
import com.anmlmanagement.model.Dog;
import com.anmlmanagement.model.Food;
import com.anmlmanagement.model.PetStore;
import com.anmlmanagement.service.DogService;
import com.anmlmanagement.service.FoodService;
import com.anmlmanagement.util.constant.Gender;
import com.anmlmanagement.util.exception.AnimalManagementException;

@Service
public class DogServiceImpl implements DogService {

	@Autowired
	private DogDao dogDao;
	@Autowired
	private FoodService foodService;

	@Override
	public Dog save(Dog dog) throws AnimalManagementException {
		return dogDao.save(dog);
	}

	public List<Dog> findAll() throws AnimalManagementException {
		return dogDao.findAll();
	}

	public Dog findById(int id) throws AnimalManagementException {
		return dogDao.findById(id);
	}

	public List<Dog> findByName(String name) throws AnimalManagementException {
		return dogDao.findByName(name);
	}
	
	public void updateDog(Dog dog, int id) throws AnimalManagementException{
		try {
			Dog oldDog = dogDao.findById(id);
			oldDog.setName(dog.getName());
			oldDog.setBreed(dog.getBreed());
			oldDog.setColour(dog.getColour());
			oldDog.setDateOfBirth(dog.getDateOfBirth());
			oldDog.setFoods(dog.getFoods());
			oldDog.setGender(dog.getGender());
			dogDao.save(oldDog);
		}catch(Exception exception) {
			throw new AnimalManagementException(exception.getMessage());
		}
	}
	
	public void deleteById(int id) throws AnimalManagementException{
		try {
			dogDao.deleteById(id);
		}catch(Exception exception) {
			throw new AnimalManagementException("Error while deleting");
		}
	}
}
