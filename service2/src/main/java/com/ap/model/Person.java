package com.ap.model;

import org.springframework.lang.NonNull;

public class Person {

	@NonNull
	private String name;
	@NonNull
	private String surname;

	public Person() {
		super();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}