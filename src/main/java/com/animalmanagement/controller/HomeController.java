package com.animalmanagement.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.model.PetStore;
import com.animalmanagement.model.Breed;
import com.animalmanagement.service.BreedService;
import com.animalmanagement.service.DogService;
import com.animalmanagement.service.FoodService;
import com.animalmanagement.service.PetStoreService;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.util.exception.AnimalManagementException;

@Controller
public class HomeController {
	@Autowired
	DogService dogService;
	@Autowired
	FoodService foodService;
	//@Autowired
	//PetStoreService petStoreService;
	//@Autowired
	//BreedService breedService;
	
	@RequestMapping("/index")
    public RedirectView home(HttpServletRequest request) {
	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl(request.getContextPath()+"/");
	    System.out.println(redirectView);
		System.out.println(" Home controller index method got a call");
	 return redirectView;
 }
	
	@PostMapping(value="/add-dog")
	public RedirectView insertDog(@ModelAttribute("dog") Dog dog, BindingResult result, HttpServletRequest request, Model model) {
		RedirectView redirectView = new RedirectView();
		if(result.hasErrors()) {
			model.addAttribute("error",result.getAllErrors());
			System.out.println(result.getAllErrors());
			redirectView.setUrl("adddog");
			return redirectView;
		} else {
			try {
			    this.dogService.insertDog(dog);
			    redirectView.setUrl("displaydogs");
			} catch(AnimalManagementException exception) {
				PetLogger.error("Error while trying to add data");
			} 
			return redirectView;
		}

	} 
	
	@RequestMapping("/adddog")	
	public String addDog(Model model) {
		model.addAttribute("dog",new Dog());
		return "adddog";
	}
	
	
	
	@GetMapping("/displaydogs")
	public String displayDogs(Model dog) {
		String temp = (String) dog.getAttribute("eror");
		System.out.println(temp);
		try {
			List<Dog> dogs = this.dogService.getAllDogs();
			dog.addAttribute("dogs", dogs);
			dog.addAttribute("eror", dog.getAttribute("eror"));
		}catch(AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
		return "dogs";	 
	}
	
	public String updateDog() {
		return "updateDog";
	}
	
	@GetMapping("/getdogbyid")
	public String getDogById(HttpServletRequest request, Model model) {
		try {
			model.addAttribute("dog", dogService.getDogById(Integer.parseInt(request.getParameter("id"))));
		} catch(AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
		return "dogs";
	}
    @RequestMapping("/update/{id}")
    public RedirectView updateDog(@PathVariable("id") int id, Model model,
    		HttpServletRequest request) {
    	RedirectView redirectView = new RedirectView();
    	try {
    		Dog dog = this.dogService.getDogById(id);
    		model.addAttribute(dog);
    		redirectView.setUrl(request.getContextPath()+"/displaydogs");
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
    	return redirectView;
    }
    
    @GetMapping("/dogsByName")
    public String displayByName(Model model,HttpServletRequest request) {
    	String name = request.getParameter("name");
    	try {
    		
    		List<Dog> dogs = dogService.getDogsByName(name);
    		model.addAttribute("dogs",dogs);
    	}catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
    	return "dogs";
    }
    @GetMapping("/delete/{id}")
    public RedirectView deleteDog(@PathVariable("id") int id,Model model, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
    	try {
        	this.dogService.deleteDogById(id); 
        	model.addAttribute("dogs" , this.dogService.getAllDogs());
        	redirectView.setUrl(request.getContextPath()+"/displaydogs");
    	}catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
    	return redirectView;
    }
    
	@GetMapping("/displayFoods")
	public String displayFoods(Model food) {
		try {
			List<Food> foods = this.foodService.getAllFoods();
			food.addAttribute("foods", foods);
			System.out.println(foods);
		}catch(AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
		return "foods";	 
	}
	
	/*
	 * @PostMapping(value="/add-food") public RedirectView
	 * insertFood(@ModelAttribute("food") Food food, BindingResult result,
	 * HttpServletRequest request, Model model) { RedirectView redirectView = new
	 * RedirectView(); if(result.hasErrors()) {
	 * model.addAttribute("error",result.getAllErrors());
	 * System.out.println(result.getAllErrors());
	 * redirectView.setUrl(request.getContextPath() + "/addfood"); return
	 * redirectView; } else { try { // this.foodService.insertFood(food);
	 * redirectView.setUrl(request.getContextPath() + "/displayFood"); }
	 * catch(AnimalManagementException exception) {
	 * PetLogger.error("Error while trying to add data"); } return redirectView; } }
	 */
	
	@RequestMapping("/addFood")	
	public String addFood(Model model) {
		model.addAttribute("food",new Food());
		return "addFood";
	}
	@RequestMapping("/assignFoods/{id}")
	public String AssignFoods(Model model, @PathVariable("id") int id,HttpServletRequest request ) {
		//RedirectView redirectView = new RedirectView();
		//redirectView.setUrl(request.getContextPath() + "/assignFoods");
		try { 
			model.addAttribute("dog",dogService.getDogById(id));
			model.addAttribute("foods",this.foodService.getAllFoods());
		}catch (AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
		return "assignFoods";
	}
	
	@PostMapping("/assign-foods")
	public String assignFoodsToDog(HttpServletRequest request, Model model) {
		RedirectView redirectView = new RedirectView();
//		model.addAttribute("eror", "Assignment failed");
		redirectView.setUrl(request.getContextPath() + "/displaydogs");
		boolean flag;
		try {
			List<String> foodIds = Arrays.asList(request.getParameterValues("foodIds"));
			int dogId = Integer.parseInt(request.getParameter("dogId"));
			System.out.println(foodIds);
			if(!foodIds.isEmpty()) {
				flag = dogService.assigFoods(dogId, foodIds);
			} 
			}catch(Exception exception) {
			    model.addAttribute("error", "Assignment failed. "
			    		+ "Please assign at least one food or click on home to continue");	
			//PetLogger.error(exception.getMessage());
		}
	return displayDogs(model);	
	}
	
}