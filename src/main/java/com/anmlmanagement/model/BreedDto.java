package com.anmlmanagement.model;

import java.util.List;

public class BreedDto {
	private int id;
	private String name;
    private String countryOfOrigin;
    private List<Dog> dogs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public List<Dog> getDogs() {
		return dogs;
	}
	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}
	@Override
	public String toString() {
		return "BreedDto [id=" + id + ", name=" + name + ", countryOfOrigin=" + countryOfOrigin + ", dogs=" + dogs
				+ "]";
	}

}
