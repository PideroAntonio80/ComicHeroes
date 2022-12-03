package com.example.comicheroes.data.localdb.mapper;

import com.example.comicheroes.data.localdb.model.HeroDB;
import com.example.comicheroes.domain.model.HeroHome;
import com.example.comicheroes.domain.model.Statistics;

public class Mapper {

    public HeroDB fromHeroHomeToHeroDB(HeroHome heroHome) {

        return new HeroDB(
                heroHome.getId(),
                heroHome.getImage(),
                heroHome.getName(),
                heroHome.getStatistics().getIntelligence(),
                heroHome.getStatistics().getStrength(),
                heroHome.getStatistics().getSpeed(),
                heroHome.getStatistics().getDurability(),
                heroHome.getStatistics().getPower(),
                heroHome.getStatistics().getCombat(),
                heroHome.getFavourite());
    }

    public HeroHome fromHeroDBToHeroHome(HeroDB heroDB) {

        return new HeroHome(
                heroDB.getId(),
                heroDB.getImage(),
                heroDB.getName(),
                new Statistics(
                        heroDB.getIntelligence(),
                        heroDB.getStrength(),
                        heroDB.getSpeed(),
                        heroDB.getDurability(),
                        heroDB.getPower(),
                        heroDB.getCombat()
                ),
                heroDB.isFavourite());
    }
}
