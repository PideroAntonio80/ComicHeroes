package com.example.comicheroes.data.network.mapper;

import com.example.comicheroes.data.network.model.AppearanceResponse;
import com.example.comicheroes.data.network.model.BiographyResponse;
import com.example.comicheroes.data.network.model.HeroResponse;
import com.example.comicheroes.data.network.model.PowerstatsResponse;
import com.example.comicheroes.domain.model.Appearance;
import com.example.comicheroes.domain.model.Biography;
import com.example.comicheroes.domain.model.HeroDetail;
import com.example.comicheroes.domain.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class MapperToDomain {

    // Function that maps from a HeroResponse object to a HeroDetail object
    public List<HeroDetail> getHeroDetailListFromHeroResponseList(List<HeroResponse> responseList) {
        List<HeroDetail> heroDetailList = new ArrayList<>();

        for (int i = 0; i < responseList.size(); i++) {
            HeroDetail heroDetail = new HeroDetail(
                    String.valueOf(responseList.get(i).getId()),
                    responseList.get(i).getImages().getMd(),
                    responseList.get(i).getName(),
                    false,
                    getStatisticsFromPowerStatsResponse(responseList.get(i).getPowerstats()),
                    getAppearanceFromAppearanceResponse(responseList.get(i).getAppearance()),
                    getBiographyFromBiographyResponse(responseList.get(i).getBiography())
                    );

            heroDetailList.add(heroDetail);
        }

        return heroDetailList;
    }

    public Statistics getStatisticsFromPowerStatsResponse(PowerstatsResponse powerstatsResponse) {

        return new Statistics(
                String.valueOf(powerstatsResponse.getIntelligence()),
                String.valueOf(powerstatsResponse.getStrength()),
                String.valueOf(powerstatsResponse.getSpeed()),
                String.valueOf(powerstatsResponse.getDurability()),
                String.valueOf(powerstatsResponse.getPower()),
                String.valueOf(powerstatsResponse.getCombat())
        );
    }

    public Appearance getAppearanceFromAppearanceResponse(AppearanceResponse appearanceResponse) {

        return new Appearance(
            appearanceResponse.getGender(),
            appearanceResponse.getRace(),
            appearanceResponse.getHeight(),
            appearanceResponse.getWeight(),
            appearanceResponse.getEyeColor(),
            appearanceResponse.getHairColor()
        );
    }

    public Biography getBiographyFromBiographyResponse(BiographyResponse biographyResponse) {

        return new Biography(
                biographyResponse.getFullName(),
                biographyResponse.getAlterEgos(),
                biographyResponse.getAliases(),
                biographyResponse.getPlaceOfBirth(),
                biographyResponse.getFirstAppearance(),
                biographyResponse.getPublisher(),
                biographyResponse.getAlignment()
        );
    }
}
