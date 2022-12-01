package com.example.comicheroes.data.network.model;

import com.google.gson.annotations.SerializedName;

public class ConnectionsResponse {

	@SerializedName("groupAffiliation")
	private String groupAffiliation;

	@SerializedName("relatives")
	private String relatives;

	/** GETTERS & SETTERS */

	public String getGroupAffiliation() {
		return groupAffiliation;
	}

	public void setGroupAffiliation(String groupAffiliation) {
		this.groupAffiliation = groupAffiliation;
	}

	public String getRelatives() {
		return relatives;
	}

	public void setRelatives(String relatives) {
		this.relatives = relatives;
	}
}