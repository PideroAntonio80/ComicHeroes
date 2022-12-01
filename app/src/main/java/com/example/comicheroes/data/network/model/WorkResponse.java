package com.example.comicheroes.data.network.model;

import com.google.gson.annotations.SerializedName;

public class WorkResponse {

	@SerializedName("occupation")
	private String occupation;

	@SerializedName("base")
	private String base;

	/** GETTERS & SETTERS */

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}
}