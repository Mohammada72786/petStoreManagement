package com.animalmanagement.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animalmanagement.dao.DogDao;
import com.animalmanagement.dao.impl.DogDaoImpl;
import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.model.PetStore;
import com.animalmanagement.service.DogService;
import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.exception.AnimalManagementException;
@Service
public class DogServiceImpl implements DogService {
	
    @Autowired
	private DogDao dogDao;

	@Override
	public void insertDog(Dog dog) throws AnimalManagementException{
	    dogDao.insertDog(dog);
	}
	public List<Dog> getAllDogs() throws AnimalManagementException {
		return dogDao.getAllDogs();
	}
	public Dog getDogById(int id) throws AnimalManagementException{
		return dogDao.getDogById(id);
	}
}
