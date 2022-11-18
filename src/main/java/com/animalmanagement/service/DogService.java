package com.animalmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.model.PetStore;
import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.exception.AnimalManagementException;

@Service
public interface DogService {


    /**
     * This method is used to add the dog in the list of dogs.
     *
     * @param name  It is used to set the name of dog.
     * @param breed It is used to set the breed of the dog.
     * @param weight It is used to set the weight of the dog.
     * @param colour It is used to set the color of the dog.
     * @param gender It is used to set the color of the dog.
     * @param dob it Is used to set the date of birth of the dog.
     * @param furType It is used to set the fur type of the dog.
     * @param eyeColour It is used to service the eye colour of the dog.
     * @return dog. It returns the dog to the method from where it is called.
     */
   
    public void insertDog(Dog dog) throws AnimalManagementException;
    public List<Dog> getAllDogs() throws AnimalManagementException;
    public Dog getDogById(int id) throws AnimalManagementException;
    public List<Dog> getDogsByName(String name) throws AnimalManagementException;
    public void deleteDogById(int id) throws AnimalManagementException;

   


}