package com.anmlmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.anmlmanagement.model.Breed;
import com.anmlmanagement.model.Food;
import com.anmlmanagement.model.PetStore;
import com.anmlmanagement.util.constant.Gender;
import com.anmlmanagement.util.exception.AnimalManagementException;

@Service
public interface BreedService {


    /**
     * This method is used to add the breed in the list of breeds.
     *
     * @param name  It is used to set the name of breed.
     * @param breed It is used to set the breed of the breed.
     * @param weight It is used to set the weight of the breed.
     * @param colour It is used to set the color of the breed.
     * @param gender It is used to set the color of the breed.
     * @param dob it Is used to set the date of birth of the breed.
     * @param furType It is used to set the fur type of the breed.
     * @param eyeColour It is used to service the eye colour of the breed.
     * @return breed. It returns the breed to the method from where it is called.
     */
   
    public void save(Breed breed) throws AnimalManagementException;
    public List<Breed> findAll() throws AnimalManagementException;
    public Breed findById(int id) throws AnimalManagementException;
    public List<Breed> findByName(String name) throws AnimalManagementException;
    public void updateBreed(Breed breed, int id) throws AnimalManagementException;
    public void deleteById(int id) throws AnimalManagementException;
    //public void deleteBreedById(int id) throws AnimalManagementException;
    //public boolean assigFoods(int breedId, List<String> foodIds) throws AnimalManagementException;

   


}