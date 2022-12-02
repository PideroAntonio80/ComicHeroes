package com.example.comicheroes.domain.model;

public class HeroHome {

    private String id;
    private String image;
    private String name;
    private Statistics statistics;
    private Boolean isFavourite;

    /** CONSTRUCTOR */

    public HeroHome(String id, String image, String name, Statistics statistics, Boolean isFavourite) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.statistics = statistics;
        this.isFavourite = isFavourite;
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

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }
}
