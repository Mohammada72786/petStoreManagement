package com.animalmanagement.dao.impl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.animalmanagement.dao.DogDao;
import com.animalmanagement.model.Dog;
import com.animalmanagement.util.exception.AnimalManagementException;
@Component
public class DogDaoImpl implements DogDao {
    @Autowired
	private HibernateTemplate hibernateTemplate;

    @Transactional
    @Override
	public void insertDog(Dog dog) throws AnimalManagementException {
    	try {
    		System.out.println("Hibernate Dao");
    	    this.hibernateTemplate.saveOrUpdate(dog);
    	    this.hibernateTemplate.save(dog);
    	} catch(HibernateException exception) {
    		throw new AnimalManagementException("Dog not created, Please check your input");
    	}
	}
    
    public List<Dog> getAllDogs() throws AnimalManagementException {
    	List<Dog> dogs;
    	try {
    		dogs = this.hibernateTemplate.loadAll(Dog.class);	
    	} catch(HibernateException exception) {
    		throw new AnimalManagementException("Error while fetching" 
    				+exception.getMessage());
    	}
    	return dogs;	
    }
    
    public Dog getDogById(int id) throws AnimalManagementException {
    	Dog dog;
    	try {
    		dog = this.hibernateTemplate.get(Dog.class,id);
    	} catch(HibernateException exception) {
    		throw new AnimalManagementException("Error while fetching data from database");
    	} 
    	return dog;
    }
}