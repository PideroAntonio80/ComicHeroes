package com.example.comicheroes.data.localdb.mapper;

import com.example.comicheroes.data.localdb.model.HeroDB;
import com.example.comicheroes.domain.model.Appearance;
import com.example.comicheroes.domain.model.Biography;
import com.example.comicheroes.domain.model.HeroDetail;
import com.example.comicheroes.domain.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    // Function that maps from a HeroDetail object to a HeroDB object
    public HeroDB fromHeroDetailToHeroDB(HeroDetail heroDetail) {

        return new HeroDB(
                heroDetail.getId(),
                heroDetail.getImage(),
                heroDetail.getName(),
                heroDetail.getStatistics().getIntelligence(),
                heroDetail.getStatistics().getStrength(),
                heroDetail.getStatistics().getSpeed(),
                heroDetail.getStatistics().getDurability(),
                heroDetail.getStatistics().getPower(),
                heroDetail.getStatistics().getCombat(),
                false,
                heroDetail.getAppearance().getGender(),
                heroDetail.getAppearance().getRace(),
                heroDetail.getAppearance().getHeight().get(0),
                heroDetail.getAppearance().getHeight().get(1),
                heroDetail.getAppearance().getWeight().get(0),
                heroDetail.getAppearance().getWeight().get(1),
                heroDetail.getAppearance().getEyeColor(),
                heroDetail.getAppearance().getHairColor(),
                heroDetail.getBiography().getFullName(),
                heroDetail.getBiography().getAlterEgos(),
                heroDetail.getBiography().getAliases().get(0),
                heroDetail.getBiography().getPlaceOfBirth(),
                heroDetail.getBiography().getFirstAppearance(),
                heroDetail.getBiography().getPublisher(),
                heroDetail.getBiography().getAlignment()
        );
    }

    // Function that maps from a HeroDB object to a HeroDetail object
    public HeroDetail fromHeroDBToHeroDetail(HeroDB heroDB) {

        List<String> heightList = new ArrayList<>();
        heightList.add(heroDB.getHeightInFeet());
        heightList.add(heroDB.getHeightInMetres());

        List<String> weightList = new ArrayList<>();
        weightList.add(heroDB.getWeightInPounds());
        weightList.add(heroDB.getWeightInKilos());

        List<String> aliasList = new ArrayList<>();
        aliasList.add(heroDB.getAlias());

        return new HeroDetail(
                heroDB.getId(),
                heroDB.getImage(),
                heroDB.getName(),
                heroDB.isFavourite(),
                new Statistics(
                        heroDB.getIntelligence(),
                        heroDB.getStrength(),
                        heroDB.getSpeed(),
                        heroDB.getDurability(),
                        heroDB.getPower(),
                        heroDB.getCombat()
                ),
                new Appearance(
                        heroDB.getGender(),
                        heroDB.getRace(),
                        heightList,
                        weightList,
                        heroDB.getEyeColor(),
                        heroDB.getHairColor()
                ),
                new Biography(
                        heroDB.getFullName(),
                        heroDB.getAlterEgos(),
                        aliasList,
                        heroDB.getPlaceOfBirth(),
                        heroDB.getFirstAppearance(),
                        heroDB.getPublisher(),
                        heroDB.getAlignment()
                )
        );
    }
}
