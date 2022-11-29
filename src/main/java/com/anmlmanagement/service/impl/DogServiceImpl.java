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

	@Override
	public Dog save(Dog dog) throws AnimalManagementException {
		Dog d = dogDao.save(dog);
		if(null != d) {
			return d;
		} else throw new AnimalManagementException("Dog not added");
	}

	public List<Dog> findAll() throws AnimalManagementException {
		List<Dog> dogs = dogDao.findAll();
		if(dogs.isEmpty()) {
			throw new AnimalManagementException("No data available");
		} else {
			return dogs;
		}
	}

	public Dog findById(int id) throws AnimalManagementException {
		Dog dog = dogDao.findById(id)
				.orElseThrow(()-> new AnimalManagementException("hiadlkfajlk"));
		return dog;
	}

	public List<Dog> findByName(String name) throws AnimalManagementException {
		List<Dog> dogs = dogDao.findByName(name);
		if(dogs.isEmpty()) {
			throw new AnimalManagementException("No data found");
		} else {
			return dogs;
		}
	}
	
	public void updateDog(Dog dog, int id) throws AnimalManagementException{
		Dog oldDog = dogDao.findById(id)
				.orElseThrow(()-> new AnimalManagementException("Updation unsuccessful!.. "));
		try {
			oldDog.setName(dog.getName());
			oldDog.setBreed(dog.getBreed());
			oldDog.setColour(dog.getColour());
			oldDog.setDateOfBirth(dog.getDateOfBirth());
			oldDog.setFoods(dog.getFoods());
			oldDog.setGender(dog.getGender());
			dogDao.save(oldDog);
		}catch(Exception exception) {
			throw new AnimalManagementException(exception.getMessage()
					+"Updation unsuccessful");
		}
	}
	
	public void deleteById(int id) throws AnimalManagementException{
		try {
			dogDao.deleteById(id);
		}catch(Exception exception) {
			throw new AnimalManagementException("Not Deleted");
		}
	}
}
