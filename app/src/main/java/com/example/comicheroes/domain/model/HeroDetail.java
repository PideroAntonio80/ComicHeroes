package com.example.comicheroes.domain.model;

public class HeroDetail {

    private String id;
    private String image;
    private String name;
    private Boolean isFavourite;
    private Statistics statistics;
    private Appearance appearance;
    private Biography biography;

    /** CONSTRUCTOR */

    public HeroDetail(String id, String image, String name, Boolean isFavourite, Statistics statistics, Appearance appearance, Biography biography) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.isFavourite = isFavourite;
        this.statistics = statistics;
        this.appearance = appearance;
        this.biography = biography;
    }

    /** GETTERS & SETTERS */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }
}
