package com.ap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubCan {
	@JsonProperty(value="Name")
	private String name;

	public SubCan() {
		super();
	}

	public SubCan(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
