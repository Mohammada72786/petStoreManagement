package com.anmlmanagement.model;

import java.util.Date;

public class Message {
	
	private Date timestamp;
	private int statusCode;
	private String message;
	private String description;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Message(int statusCode, Date timestamp, String message, String description) {
		
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.message = message;
		this.description = description;
	}
}
