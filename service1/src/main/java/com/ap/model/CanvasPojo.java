package com.ap.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CanvasPojo {

	@JsonProperty(value = "Name")
	private String name;
	@JsonProperty(value = "Sub Classes")
	private List<SubCan> list;

	public CanvasPojo() {
		super();
	}

	public CanvasPojo(String name, List<SubCan> list) {
		super();
		this.name = name;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubCan> getList() {
		return list;
	}

	public void setList(List<SubCan> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "CanvasPojo [name=" + name + ", list=" + list + "]";
	}

}
