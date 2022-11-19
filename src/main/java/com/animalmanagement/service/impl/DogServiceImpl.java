package com.animalmanagement.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animalmanagement.dao.DogDao;
import com.animalmanagement.dao.FoodDao;
import com.animalmanagement.dao.impl.DogDaoImpl;
import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.model.PetStore;
import com.animalmanagement.service.DogService;
import com.animalmanagement.service.FoodService;
import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.exception.AnimalManagementException;

@Service
public class DogServiceImpl implements DogService {

	@Autowired
	private DogDao dogDao;
	@Autowired
	private FoodService foodService;

	@Override
	public void insertDog(Dog dog) throws AnimalManagementException {
		dogDao.insertDog(dog);
	}

	public List<Dog> getAllDogs() throws AnimalManagementException {
		return dogDao.getAllDogs();
	}

	public Dog getDogById(int id) throws AnimalManagementException {
		return dogDao.getDogById(id);
	}

	public List<Dog> getDogsByName(String name) throws AnimalManagementException {
		return dogDao.getDogsByName(name);
	}

	public void deleteDogById(int id) throws AnimalManagementException {
		this.dogDao.deleteDogById(id);
	}

	public boolean assigFoods(int dogId, List<String> foodIds) throws AnimalManagementException {
		Dog dog = dogDao.getDogById(dogId);
		List<Food> foods = foodService.getFoodsByIds(foodIds);
		if (!foods.isEmpty() && null != dog) {
			dog.setFoods(foods);
			dogDao.insertDog(dog);
			return true;
		}else {
			return false;
		}
	}
}
