package com.anmlmanagement.service;

import java.util.List;

import org.hibernate.annotations.Where;
import org.springframework.stereotype.Service;

import com.anmlmanagement.model.PetStore;
import com.anmlmanagement.util.exception.AnimalManagementException;

@Service
@Where(clause = "is_deleted='0'")
public interface PetStoreService {


    /**
     * This method is used to add the petStore in the list of petStores.
     *
     * @param name  It is used to set the name of petStore.
     * @param breed It is used to set the breed of the petStore.
     * @param weight It is used to set the weight of the petStore.
     * @param colour It is used to set the color of the petStore.
     * @param gender It is used to set the color of the petStore.
     * @param dob it Is used to set the date of birth of the petStore.
     * @param furType It is used to set the fur type of the petStore.
     * @param eyeColour It is used to service the eye colour of the petStore.
     * @return petStore. It returns the petStore to the method from where it is called.
     */
   
    public void save(PetStore petStore) throws AnimalManagementException;
    public List<PetStore> findAll() throws AnimalManagementException;
    public PetStore findById(int id) throws AnimalManagementException;
    public List<PetStore> findByName(String name) throws AnimalManagementException;
    public void updatePetStore(PetStore petStore, int id) throws AnimalManagementException;
    public void deleteById(int id) throws AnimalManagementException;
    //public void deletePetStoreById(int id) throws AnimalManagementException;
    //public boolean assigFoods(int petStoreId, List<String> foodIds) throws AnimalManagementException;

   


}