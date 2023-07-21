package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Expense {// Addexpense
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String date;
	private String time;
	private String description;
	private String price;
	
	
	@ManyToOne
	private UserData user;

	
	
	public Expense() {
		super();
	}


	public Expense(String title, String date, String time, String description, String price, UserData user) {
		super();
		this.user=user;
		this.title = title;
		this.date = date;
		this.time = time;
		this.description = description;
		this.price = price;
	}

	
	public UserData getUser() {
		return user;
	}


	public void setUser(UserData user) {
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
