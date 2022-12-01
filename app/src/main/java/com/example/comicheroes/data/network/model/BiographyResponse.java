package com.example.comicheroes.data.network.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BiographyResponse {

	@SerializedName("fullName")
	private String fullName;

	@SerializedName("alterEgos")
	private String alterEgos;

	@SerializedName("aliases")
	private List<String> aliases;

	@SerializedName("placeOfBirth")
	private String placeOfBirth;

	@SerializedName("firstAppearance")
	private String firstAppearance;

	@SerializedName("publisher")
	private String publisher;

	@SerializedName("alignment")
	private String alignment;

	/** GETTERS & SETTERS */

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAlterEgos() {
		return alterEgos;
	}

	public void setAlterEgos(String alterEgos) {
		this.alterEgos = alterEgos;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getFirstAppearance() {
		return firstAppearance;
	}

	public void setFirstAppearance(String firstAppearance) {
		this.firstAppearance = firstAppearance;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
}