package com.example.comicheroes.data.network.model;

import com.google.gson.annotations.SerializedName;

public class HeroResponse {

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;

	@SerializedName("slug")
	private String slug;

	@SerializedName("powerstats")
	private PowerstatsResponse powerstats;

	@SerializedName("appearance")
	private AppearanceResponse appearance;

	@SerializedName("biography")
	private BiographyResponse biography;

	@SerializedName("work")
	private WorkResponse work;

	@SerializedName("connections")
	private ConnectionsResponse connections;

	@SerializedName("images")
	private ImagesResponse images;

	/** GETTERS & SETTERS */

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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public PowerstatsResponse getPowerstats() {
		return powerstats;
	}

	public void setPowerstats(PowerstatsResponse powerstats) {
		this.powerstats = powerstats;
	}

	public AppearanceResponse getAppearance() {
		return appearance;
	}

	public void setAppearance(AppearanceResponse appearance) {
		this.appearance = appearance;
	}

	public BiographyResponse getBiography() {
		return biography;
	}

	public void setBiography(BiographyResponse biography) {
		this.biography = biography;
	}

	public WorkResponse getWork() {
		return work;
	}

	public void setWork(WorkResponse work) {
		this.work = work;
	}

	public ConnectionsResponse getConnections() {
		return connections;
	}

	public void setConnections(ConnectionsResponse connections) {
		this.connections = connections;
	}

	public ImagesResponse getImages() {
		return images;
	}

	public void setImages(ImagesResponse images) {
		this.images = images;
	}
}