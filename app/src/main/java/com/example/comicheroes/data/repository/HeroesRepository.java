package com.example.comicheroes.data.repository;

import com.example.comicheroes.data.network.mapper.MapperToDomain;
import com.example.comicheroes.data.network.model.HeroResponse;
import com.example.comicheroes.data.network.webService.ApiServices;
import com.example.comicheroes.data.network.webService.RetrofitApiClientGenerator;
import com.example.comicheroes.domain.model.HeroHome;

import java.io.IOException;
import java.util.List;

public class HeroesRepository {

    private final RetrofitApiClientGenerator retrofitApiClientGenerator = new RetrofitApiClientGenerator();
    private final ApiServices api = retrofitApiClientGenerator.generateRetrofit().create(ApiServices.class);

    public List<HeroHome> getHeroesList() {

        MapperToDomain mapperToDomain = new MapperToDomain();

        try {
            List<HeroResponse> response = api.getHeroList().execute().body();

            if (response != null && !response.isEmpty()) {

                return mapperToDomain.getHeroHomeListFromHeroResponseList(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
