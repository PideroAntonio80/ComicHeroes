package com.example.comicheroes.domain.model;

public class HeroDetail {

    private HeroHome heroHome;
    private Appearance appearance;
    private Biography biography;

    /** CONSTRUCTOR */

    public HeroDetail(HeroHome heroHome, Appearance appearance, Biography biography) {
        this.heroHome = heroHome;
        this.appearance = appearance;
        this.biography = biography;
    }

    /** GETTERS & SETTERS */

    public HeroHome getHeroHome() {
        return heroHome;
    }

    public void setHeroHome(HeroHome heroHome) {
        this.heroHome = heroHome;
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
