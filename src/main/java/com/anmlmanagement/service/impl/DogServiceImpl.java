package com.anmlmanagement.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.anmlmanagement.dao.DogDao;
import com.anmlmanagement.model.Dog;
import com.anmlmanagement.model.DogDto;
import com.anmlmanagement.service.DogService;
import com.anmlmanagement.util.DtoUtil;
import com.anmlmanagement.util.exception.AnimalManagementException;

@Service
public class DogServiceImpl implements DogService {

	@Autowired
	private DogDao dogDao;
	
	@Autowired
	DtoUtil dtoUtil;

	@Override
	public DogDto save(DogDto dogDto) throws AnimalManagementException {
		DogDto dog = dtoUtil.dogEntityToDto(dogDao.save(dtoUtil.dogDtoToEntity(dogDto)));
		if(null != dog) {
			return dog;
		} else throw new AnimalManagementException("Dog not added");
	}

	public List<DogDto> findAll() throws AnimalManagementException {
		List<Dog> dogs = dogDao.findAll();
		if(dogs.isEmpty()) {
			throw new AnimalManagementException("No data available");
		} else { 
			return dtoUtil.dogEntityToDto(dogs);
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
