package com.animalmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.animalmanagement.model.Dog;
import com.animalmanagement.service.DogService;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.util.exception.AnimalManagementException;

@Controller
public class HomeController {
	@Autowired
	DogService dogService;
	
	@RequestMapping("/index")
    public String home() {
		System.out.println(" Home controller index method got a call");
	 return "index";
 }
	
	@RequestMapping("/aaa")
    public String home(Model model) {
		model.addAttribute("dog", new Dog());
	 return "adddog";
 }
	@RequestMapping(value="/add-dog", method= RequestMethod.POST)
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
	@RequestMapping("/displaydogs")
	public String displayDogs(Model dog) {
		try {
			List<Dog> dogs = this.dogService.getAllDogs();
			dog.addAttribute("dogs", dogs);
		}catch(AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
		return "dogs";	 
	}
	public String updateDog() {
		return "updateDog";
	}
	@RequestMapping("/getdogbyid")
	public String getDogById(HttpServletRequest request, Model model) {
		try {
			model.addAttribute("dog", dogService.getDogById(Integer.parseInt(request.getParameter("id"))));
		} catch(AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
		return "dogs";
	}
    @RequestMapping("/update/{id}")
    public String updateDog(@PathVariable("id") int id, Model model) {
    	try {
    		Dog dog = this.dogService.getDogById(id);
    		model.addAttribute(dog);
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
    	return "updateDog";
    }
}
