package com.anmlmanagement.util;

import com.anmlmanagement.model.Dog;
import com.anmlmanagement.model.DogDto;
import com.anmlmanagement.model.Food;
import com.anmlmanagement.model.FoodDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.anmlmanagement.model.Breed;
import com.anmlmanagement.model.BreedDto;
import com.anmlmanagement.model.PetStore;
import com.anmlmanagement.model.PetStoreDto;


public class DtoUtil {
	
	
	@Autowired
	ModelMapper modelMapper;
	/*
	 *   This method is used to convert an object of DogDto to Dog Model object
	 *   
	 *   @param DogDto. it is an object of dog DTO.
	 *   @return Model object of dog.   
	 */
	
	public Dog dogDtoToEntity(DogDto dogDto) {
		Dog dog = this.modelMapper.map(dogDto, Dog.class);
	/*	if(dogDto != null) {
			dog = new Dog();
			dog.setName(dogDto.getName());
			dog.setBreed(breedDtoToEntity(dogDto.getBreedDto()));
			dog.setColour(dogDto.getColour());
			dog.setDateOfBirth(dogDto.getDateOfBirth());
			dog.setDogCode(dogDto.getDogCode());
			dog.setId(dogDto.getId());
			dog.setFoods(foodDtoToEnity(dogDto.getFoods()));
			dog.setGender(dogDto.getGender());
			dog.setPetStore(petStoreDtoToEntity(dogDto.getPetStoreDto()));		
		}*/
	return dog;
	}	
	
    public DogDto dogEntityToDto(Dog dog) {
    	if(null != dog) {
    		DogDto dogDto = modelMapper.map(dog, DogDto.class);
			/*
			 * dogDto.setName(dog.getName()); dogDto.setColour(dog.getColour());
			 * dogDto.setWeight(dog.getWeight());
			 * dogDto.setDateOfBirth(dog.getDateOfBirth());
			 * dogDto.setGender(dog.getGender()); dogDto.setDogCode(dog.getDogCode());
			 * dogDto.setBreedDto(breedEntityToDto(dog.getBreed()));
			 * dogDto.setPetStoreDto(petStoreEntityToDto(dog.getPetStore()));
			 * dogDto.setFoods(foodEntityToDto(dog.getFoods())); return dogDto;
			 */
    	return dogDto;	
    	} else {
    		return null;
    	}	
    }
    
    
	public List<DogDto> dogEntityToDto(List<Dog> dogs){
		if(dogs.isEmpty()) {
			return null;
		}else {
	    return dogs.stream().map(d->dogEntityToDto(d)).collect(Collectors.toList());
		}
	}
	
	public List<Dog> dogDtoToEnity(List<DogDto> dogDtos){
		if(dogDtos.isEmpty()) {
			return null;
		}else {
	    return dogDtos.stream().map(d->dogDtoToEntity(d)).collect(Collectors.toList());
		}
	}

	
	public PetStore petStoreDtoToEntity(PetStoreDto petStoreDto) {
		PetStore petStore = modelMapper.map(petStoreDto, PetStore.class);
		/*
		 * PetStore petStore = new PetStore(); petStore.setName(petStoreDto.getName());
		 * petStore.setAddress(petStoreDto.getAddress());
		 * petStore.setId(petStoreDto.getId());
		 */
		return petStore;
	}
	
	
	
	public PetStoreDto petStoreEntityToDto(PetStore petStore) {
		PetStoreDto petStoreDto = null;
		if(null!= petStore) {
			petStoreDto = modelMapper.map(petStoreDto, PetStoreDto.class);
			
			/*
			 * PetStoreDto petStoreDto = new PetStoreDto();
			 * petStoreDto.setAddress(petStore.getAddress());
			 * petStoreDto.setId(petStore.getId()); petStoreDto.setName(petStore.getName());
			 */
		}
		return petStoreDto;
	}
	
	public List<PetStoreDto> petStoreEntiyTodto(List<PetStore> petStores) {
		if(petStores.isEmpty()) {
			return null;
		}else {
	    return petStores.stream().map(p->petStoreEntityToDto(p)).collect(Collectors.toList());
		}
	}
	
	
	public List<PetStore> petStoreDtoToEnity(List<PetStoreDto> petStores){
		if(petStores.isEmpty()) {
			return null;
		}else {
	    return petStores.stream().map(d->petStoreDtoToEntity(d)).collect(Collectors.toList());
		}
	}
	
	

	public Food foodDtoToEntity(FoodDto foodDto) {
		Food food = null;
		if(null != foodDto) {
			food = modelMapper.map(foodDto, Food.class);
			/*
			 * Food food = new Food(); food.setName(foodDto.getName());
			 * food.setType(foodDto.getType()); food.setId(foodDto.getId()); return food;
			 */	
		}
		return food;
	}
	
	public FoodDto foodEntityToDto(Food food) {
		FoodDto foodDto = null;
		if(null != food) {
			foodDto = modelMapper.map(food, FoodDto.class);
			/*
			 * FoodDto foodDto = new FoodDto(); 
			 * foodDto.setName(food.getName());
			 * foodDto.setType(food.getType());
			 *  foodDto.setId(food.getId()); 
			 */
		}
		return foodDto;
	}
	
	public List<FoodDto> foodEntityToDto(List<Food> foods){
		if(foods.isEmpty()) {
			return null;
		}else {
	    return foods.stream().map(d->foodEntityToDto(d)).collect(Collectors.toList());
		}
	}
	
	public List<Food> foodDtoToEnity(List<FoodDto> foods){
		if(foods.isEmpty()) {
			return null;
		}else {
	    return foods.stream().map(d->foodDtoToEntity(d)).collect(Collectors.toList());
		}
	}

	
	public Breed breedDtoToEntity(BreedDto breedDto) {
		Breed breed = null;
		if(null != breedDto) {
			breed = modelMapper.map(breedDto, Breed.class);
			/*
			 * Breed breed = new Breed(); breed.setName(breedDto.getName());
			 * breed.setCountryOfOrigin(breedDto.getCountryOfOrigin());
			 * breed.setId(breedDto.getId()); // dog list TODO return breed;
			 */
		}
		return breed;
	}
	
	public BreedDto breedEntityToDto(Breed breed) {
		BreedDto breedDto = null;
		if(null != breed) {
			breedDto = modelMapper.map(breed, BreedDto.class);
			/*
			 * BreedDto breedDto = new BreedDto();
			 * breedDto.setCountryOfOrigin(breed.getCountryOfOrigin());
			 * breedDto.setId(breed.getId()); breedDto.setName(breed.getName());
			 */
		}
		return breedDto;
	}
	
	
	public List<BreedDto> breedEntityToDto(List<Breed> breeds){
		if(breeds.isEmpty()) {
			return null;
		}else {
	    return breeds.stream().map(d->breedEntityToDto(d)).collect(Collectors.toList());
		}
	}
	
	public List<Breed> breedDtoToEntity(List<BreedDto> breeds){
		if(breeds.isEmpty()) {
			return null;
		}else {
	    return breeds.stream().map(d->breedDtoToEntity(d)).collect(Collectors.toList());
		}
	}

}
