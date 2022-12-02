package com.example.comicheroes.data.network.mapper;

import com.example.comicheroes.data.network.model.AppearanceResponse;
import com.example.comicheroes.data.network.model.BiographyResponse;
import com.example.comicheroes.data.network.model.HeroResponse;
import com.example.comicheroes.data.network.model.PowerstatsResponse;
import com.example.comicheroes.domain.model.Appearance;
import com.example.comicheroes.domain.model.Biography;
import com.example.comicheroes.domain.model.HeroDetail;
import com.example.comicheroes.domain.model.HeroHome;
import com.example.comicheroes.domain.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class MapperToDomain {

    public List<HeroHome> getHeroHomeListFromHeroResponseList(List<HeroResponse> responseList) {
        List<HeroHome> heroHomeList = new ArrayList<>();

        for (int i = 0; i < responseList.size(); i++) {
            HeroHome heroHome = new HeroHome(
                    String.valueOf(responseList.get(i).getId()),
                    responseList.get(i).getImages().getMd(),
                    responseList.get(i).getName(),
                    getStatisticsFromPowerStatsResponse(responseList.get(i).getPowerstats()),
                    false);

            heroHomeList.add(heroHome);
        }

        return heroHomeList;
    }

    public HeroDetail getHeroDetailFromHeroResponse(HeroResponse heroResponse) {
        return new HeroDetail(
                String.valueOf(heroResponse.getId()),
                heroResponse.getImages().getMd(),
                heroResponse.getName(),
                false,
                getStatisticsFromPowerStatsResponse(heroResponse.getPowerstats()),
                getAppearanceFromAppearanceResponse(heroResponse.getAppearance()),
                getBiographyFromBiographyResponse(heroResponse.getBiography())
        );
    }

    public Statistics getStatisticsFromPowerStatsResponse(PowerstatsResponse powerstatsResponse) {

        return new Statistics(
                String.valueOf(powerstatsResponse.getIntelligence()),
                String.valueOf(powerstatsResponse.getStrength()),
                String.valueOf(powerstatsResponse.getSpeed()),
                String.valueOf(powerstatsResponse.getDurability()),
                String.valueOf(powerstatsResponse.getPower()),
                String.valueOf(powerstatsResponse.getCombat()));
    }

    public Appearance getAppearanceFromAppearanceResponse(AppearanceResponse appearanceResponse) {

        return new Appearance(
            appearanceResponse.getGender(),
            appearanceResponse.getRace(),
            appearanceResponse.getHeight(),
            appearanceResponse.getWeight(),
            appearanceResponse.getEyeColor(),
            appearanceResponse.getHairColor());
    }

    public Biography getBiographyFromBiographyResponse(BiographyResponse biographyResponse) {

        return new Biography(
                biographyResponse.getFullName(),
                biographyResponse.getAlterEgos(),
                biographyResponse.getAliases(),
                biographyResponse.getPlaceOfBirth(),
                biographyResponse.getFirstAppearance(),
                biographyResponse.getPublisher(),
                biographyResponse.getAlignment());
    }
}
