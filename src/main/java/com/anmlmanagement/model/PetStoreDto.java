package com.anmlmanagement.model;

import java.util.List;


public class PetStoreDto {
	
	private int id;
    private String name;
	private String address;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Dog> getDogs() {
		return dogs;
	}


	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}


	@Override
	public String toString() {
		return "PetStoreDto [id=" + id + ", name=" + name + ", address=" + address + ", dogs=" + dogs + "]";
	}
}
