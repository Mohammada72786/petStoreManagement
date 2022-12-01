package com.anmlmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anmlmanagement.model.Dog;
import com.anmlmanagement.model.DogDto;
import com.anmlmanagement.util.exception.AnimalManagementException;

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
   
    public DogDto save(DogDto dog) throws AnimalManagementException;
    public List<DogDto> findAll() throws AnimalManagementException;
    public Dog findById(int id) throws AnimalManagementException;
    public List<Dog> findByName(String name) throws AnimalManagementException;
    public void updateDog(Dog dog, int id) throws AnimalManagementException;
    public void deleteById(int id) throws AnimalManagementException;
    //public void deleteDogById(int id) throws AnimalManagementException;
    //public boolean assigFoods(int dogId, List<String> foodIds) throws AnimalManagementException;

   


}