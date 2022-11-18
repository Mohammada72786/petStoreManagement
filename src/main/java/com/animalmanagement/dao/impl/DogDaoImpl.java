package com.animalmanagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
	
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	@Override
	public void insertDog(Dog dog) throws AnimalManagementException {
		try {
			System.out.println("Hibernate Dao");
			this.hibernateTemplate.saveOrUpdate(dog);
			this.hibernateTemplate.save(dog);
		} catch (HibernateException exception) {
			throw new AnimalManagementException("Dog not created, Please check your input");
		}
	}

	public List<Dog> getAllDogs() throws AnimalManagementException {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Dog> criteriaQuery = criteriaBuilder.createQuery(Dog.class);

		Root<Dog> dog = criteriaQuery.from(Dog.class);

		Predicate predicate = criteriaBuilder.equal(dog.get("isDeleted"),0);
		criteriaQuery.where(predicate);

		TypedQuery<Dog> query = entityManager.createQuery(criteriaQuery);
		
		return query.getResultList();
		/*
		 * List<Dog> dogs; try { dogs = this.hibernateTemplate.loadAll(Dog.class); }
		 * catch (HibernateException exception) { throw new
		 * AnimalManagementException("Error while fetching" + exception.getMessage()); }
		 * return dogs;
		 */
	}

	public Dog getDogById(int id) throws AnimalManagementException {
		Dog dog;
		try {
			dog = this.hibernateTemplate.get(Dog.class, id);
		} catch (HibernateException exception) {
			throw new AnimalManagementException("Error while fetching data from database");
		}
		return dog;
	}	
	
	public List<Dog> getDogsByName(String name) throws AnimalManagementException {
		try {
			System.out.println(name);
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Dog> criteriaQuery = criteriaBuilder.createQuery(Dog.class);

			Root<Dog> dog = criteriaQuery.from(Dog.class);

			Predicate namePredicate = criteriaBuilder.like(dog.get("name"), "%" + name + "%");
			criteriaQuery.where(namePredicate);

			TypedQuery<Dog> query = entityManager.createQuery(criteriaQuery);
			
			return query.getResultList();

		} catch (HibernateException exception) {
			throw new AnimalManagementException("Error occured while fetching");
		}
	}
	
	@Transactional
	public void deleteDogById(int id) throws AnimalManagementException{
		try {
			Dog dog = this.hibernateTemplate.get(Dog.class, id);
			this.hibernateTemplate.delete(dog);
		}catch(HibernateException exception) {
			throw new AnimalManagementException("Not deleted" + exception.getMessage());
		}
	}
}