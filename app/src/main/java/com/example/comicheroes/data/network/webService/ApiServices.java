package com.example.comicheroes.data.network.webService;

import com.example.comicheroes.data.network.model.HeroResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {

    @GET("all.json")
    Call<List<HeroResponse>> getHeroList();

//    @GET("id/{idHero}.json")  // todo; borrar esta función
//    Call<HeroResponse> getHeroById(@Path("idHero") String id);
}
