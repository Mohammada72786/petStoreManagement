package com.anmlmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anmlmanagement.model.Dog;
import com.anmlmanagement.model.DogDto;
import com.anmlmanagement.model.Food;
import com.anmlmanagement.service.DogService;
import com.anmlmanagement.service.FoodService;
import com.anmlmanagement.util.exception.AnimalManagementException;

@RestController
public class HomeController {
	
	@Autowired
	DogService dogService;
	
	@Autowired 
	FoodService foodService;
	
	@RequestMapping("/home")
	public String home() {
		return "index";
		
	}
	
	@RequestMapping("index")
	public String index() {
		return"index";
	}
	
	@GetMapping("/dogs")
	public ResponseEntity<List<DogDto>> displayDogs() {
		List<DogDto> dogs = null;
		try {
			dogs = dogService.findAll();
	        if(dogs.size()<=0) {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        } else {
	        	return ResponseEntity.of(Optional.of(dogs));
	        }		
		} catch(AnimalManagementException exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/foods")
	public ResponseEntity<List<Food>> displayFoods() {
		List<Food> foods = null;
		try {
			foods = foodService.findAll();
	        if(foods.size()<=0) {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        } else {
	    		return ResponseEntity.of(Optional.of(foods));
	        }
		}catch(AnimalManagementException exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}  
	}
	
	@GetMapping("/dog/{id}")
	public ResponseEntity<Dog> displayDog(@PathVariable("id") int id) {
		Dog dog = null;
		try {
			dog = dogService.findById(id);
			if(null == dog) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}else {
				return ResponseEntity.of(Optional.of(dog));
			}
		}catch(AnimalManagementException exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@GetMapping("/food/{id}")
	public ResponseEntity<?> displayFood(@PathVariable("id") int id) {
		Food food = null;
		try {
			food = foodService.findById(id);
			if(null == food) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food Not found");
			} else {
				return ResponseEntity.of(Optional.of(food));
			}
		}catch(AnimalManagementException exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
	
	@PutMapping("/dog/{id}")
	public ResponseEntity<Dog> updateDog(@PathVariable("id") int id, @RequestBody Dog dog){
		try {
		    this.dogService.updateDog(dog, id);
		    return ResponseEntity.ok().body(dog);
		}catch(AnimalManagementException exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		} 
	}
	
	
	@PutMapping("/food/{id}")
	public ResponseEntity<Food> updateDog(@PathVariable("id") int id, @RequestBody Food food){
		try {
		    this.foodService.updateFood(food, id);
		    return ResponseEntity.ok().body(food);
		}catch(AnimalManagementException exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		} 
	}
	
	@DeleteMapping("/dog/{id}")
	public ResponseEntity<Void> deleteDog(@PathVariable("id") int id) {
		try {
			Dog dog = dogService.findById(id);
			if(null == dog) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			} else {
				dogService.deleteById(id);
				return ResponseEntity.ok().build();
			}
		} catch(AnimalManagementException exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
	
	@PostMapping("/dog")
	public ResponseEntity<DogDto> AddDog(@RequestBody DogDto dog){
        try {
        	DogDto savedDog = dogService.save(dog);
        	return ResponseEntity.ok().body(savedDog);
        }catch(AnimalManagementException exception) {
        	exception.printStackTrace();
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@PostMapping("/food")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> AddFood(@RequestBody Food food){
        try {
        	Food savedFood = foodService.save(food);
        	return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
        }catch(AnimalManagementException exception) {
        	exception.printStackTrace();
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	} 
}
