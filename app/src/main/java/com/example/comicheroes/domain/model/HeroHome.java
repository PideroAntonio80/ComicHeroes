package com.example.comicheroes.domain.model;

public class HeroHome {

    public String image;
    public String name;
    public Statistics statistics;
    public Boolean isFavourite;

    /** CONSTRUCTOR */

    public HeroHome(String image, String name, Statistics statistics, Boolean isFavourite) {
        this.image = image;
        this.name = name;
        this.statistics = statistics;
        this.isFavourite = isFavourite;
    }

    /** GETTERS & SETTERS */

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
