package com.animalmanagement.dao;

import java.util.List;

import com.animalmanagement.model.Dog;
import com.animalmanagement.util.exception.AnimalManagementException;


public interface DogDao {

    /**
     * Gets object of type dog from the service and stored in the database.
     *
     * @param dog object of type Dog.
     * @return . It returns dog object to the service after the successful insertion on the table.
     */
	public void insertDog(Dog dog) throws AnimalManagementException;
	 public List<Dog> getAllDogs() throws AnimalManagementException;
	 public Dog getDogById(int id) throws AnimalManagementException;
}