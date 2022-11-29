package com.anmlmanagement.model;

import java.util.List;

public class FoodDto {
	private int id;
	private String name;
    private String type;
    private List<DogDto> dogs;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<DogDto> getDogs() {
		return dogs;
	}
	public void setDogs(List<DogDto> dogs) {
		this.dogs = dogs;
	}
	@Override
	public String toString() {
		return "FoodDto [id=" + id + ", name=" + name + ", type=" + type + ", dogs=" + dogs + "]";
	}


}
