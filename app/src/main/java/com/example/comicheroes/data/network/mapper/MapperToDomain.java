package com.example.comicheroes.data.network.mapper;

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

    private HeroResponse heroResponse;
    private HeroHome heroHome;
    private PowerstatsResponse powerstatsResponse;
    private Statistics statistics;
    private HeroDetail heroDetail;
    private Appearance appearance;
    private Biography biography;

    /** EMPTY CONSTRUCTOR */

    public MapperToDomain() {
    }

    /** GETTERS & SETTERS */

    public HeroResponse getHeroResponse() {
        return heroResponse;
    }

    public void setHeroResponse(HeroResponse heroResponse) {
        this.heroResponse = heroResponse;
    }

    public HeroHome getHeroHome() {
        return heroHome;
    }

    public void setHeroHome(HeroHome heroHome) {
        this.heroHome = heroHome;
    }

    public PowerstatsResponse getPowerstatsResponse() {
        return powerstatsResponse;
    }

    public void setPowerstatsResponse(PowerstatsResponse powerstatsResponse) {
        this.powerstatsResponse = powerstatsResponse;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public HeroDetail getHeroDetail() {
        return heroDetail;
    }

    public void setHeroDetail(HeroDetail heroDetail) {
        this.heroDetail = heroDetail;
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

    public List<HeroHome> getHeroHomeListFromHeroResponseList(List<HeroResponse> responseList) {
        List<HeroHome> heroHomeList = new ArrayList<>();

        for (int i = 0; i < responseList.size(); i++) {
            HeroHome heroHome = new HeroHome(
                    responseList.get(i).getImages().getMd(),
                    responseList.get(i).getName(),
                    getStatisticsFromPowerStatsResponse(responseList.get(i).getPowerstats()),
                    false);

            heroHomeList.add(heroHome);
        }

        return heroHomeList;
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
}
