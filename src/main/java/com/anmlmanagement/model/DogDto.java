package com.anmlmanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;

import com.anmlmanagement.util.constant.Gender;

public class DogDto {
	
	private int id;
	private String name;
	private float weight;
	private String colour;
	private Gender gender;
	private Date dateOfBirth;
	private float speed;
	private String dogCode;
	private PetStoreDto petStoreDto;
	private BreedDto breedDto;
	private List<FoodDto> foods;
	
	@Override
	public String toString() {
		return "DogDto [name=" + name 
				+ ", weight=" + weight 
				+ ", colour=" + colour 
				+ ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth 
				+ ", speed=" + speed 
				+ ", dogCode=" + dogCode + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public String getDogCode() {
		return dogCode;
	}
	public void setDogCode(String dogCode) {
		this.dogCode = dogCode;
	}
	public PetStoreDto getPetStoreDto() {
		return petStoreDto;
	}
	public void setPetStoreDto(PetStoreDto petStoreDto) {
		this.petStoreDto = petStoreDto;
	}
	public BreedDto getBreedDto() {
		return breedDto;
	}
	public void setBreedDto(BreedDto breedDto) {
		this.breedDto = breedDto;
	}
	public List<FoodDto> getFoods() {
		return foods;
	}
	public void setFoods(List<FoodDto> foods) {
		this.foods = foods;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
