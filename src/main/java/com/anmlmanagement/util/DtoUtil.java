package com.anmlmanagement.util;

import com.anmlmanagement.model.Dog;
import com.anmlmanagement.model.DogDto;
import com.anmlmanagement.model.Food;
import com.anmlmanagement.model.FoodDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.anmlmanagement.model.Breed;
import com.anmlmanagement.model.BreedDto;
import com.anmlmanagement.model.PetStore;
import com.anmlmanagement.model.PetStoreDto;


public class DtoUtil {
	
	
	public Dog dogDtoToEntity(DogDto dogDto) {
		if(dogDto != null) {
			Dog dog = new Dog();
			dog.setName(dogDto.getName());
			//dog.setBreed(dogDto.getBreedDto());
			dog.setColour(dogDto.getColour());
			dog.setDateOfBirth(dogDto.getDateOfBirth());
			dog.setDogCode(dogDto.getDogCode());
			dog.setId(dogDto.getId());
			dog.setFoods(null);
			dog.setGender(dogDto.getGender());
			//dog.setPetStore(getPetStoreDao(dogDto.getPetStoreDto()));	
		return dog;	
		}else {
			return null;
		}
		
	}

	public List<Dog> dogDtoToEnity(List<DogDto> dogDtos){
		if(dogDtos.isEmpty()) {
			return null;
		}else {
	    return dogDtos.stream().map(d->dogDtoToEntity(d)).collect(Collectors.toList());
		}
	}
	
		
		
    public DogDto dogEntityToDto(Dog dog) {
    	DogDto dogDto = new DogDto();
    	if(null != dog) {
    		dogDto.setName(dog.getName());
    		dogDto.setColour(dog.getColour());
    		dogDto.setWeight(dog.getWeight());
    		dogDto.setDateOfBirth(dog.getDateOfBirth());
    		dogDto.setGender(dog.getGender());
    		dogDto.setDogCode(dog.getDogCode());
    		//dogDto.setFood()dog.getFood());
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

	
	public PetStore getPetStoreDao(PetStoreDto petStoreDto) {
		PetStore petStore = new PetStore();
		petStore.setName(petStoreDto.getName());
		petStore.setAddress(petStoreDto.getAddress());
		petStore.setId(petStoreDto.getId());
		// set dogs list
		return petStore;
	}
	
	public PetStoreDto getPetStoreDto(PetStore petStore) {
		if(null!= petStore) {
		    PetStoreDto petStoreDto = new PetStoreDto();
		    petStoreDto.setAddress(petStore.getAddress());
		    petStoreDto.setId(petStore.getId());
		    petStoreDto.setName(petStore.getName());
		    //dogs list todo
		    return petStoreDto;
		}else {
			return null;
		}
	}
	

	public Food getFoodDao(FoodDto foodDto) {
		if(null != foodDto) {
			Food food = new Food();
			food.setName(foodDto.getName());
			food.setType(foodDto.getType());
			food.setId(foodDto.getId());
			//food.setDogs(null);
			return food;
			
		}else {
			return null;
		}
	}
	
	public FoodDto getFoodDto(Food food) {
		if(null != food) {
			FoodDto foodDto = new FoodDto();
			foodDto.setName(food.getName());
			foodDto.setType(food.getType());
			foodDto.setId(food.getId());
			return foodDto;
		}else {
			return null;
		}
	}
	
	public Breed getBreedDao(BreedDto breedDto) {
		if(null != breedDto) {
			Breed breed = new Breed();
			breed.setName(breedDto.getName());
			breed.setCountryOfOrigin(breedDto.getCountryOfOrigin());
			breed.setId(breedDto.getId());
			// dog list TODO
			return breed;
		}else {
			return null;
		}
	}
	
	public BreedDto getBreedDto(Breed breed) {
		if(null != breed) {
			BreedDto breedDto = new BreedDto();
			breedDto.setCountryOfOrigin(breed.getCountryOfOrigin());
			breedDto.setId(breed.getId());
			breedDto.setName(breed.getName());
			// god TODO
			return breedDto;
		}else {
			return null;
		}
	}
}
