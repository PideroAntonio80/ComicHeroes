package com.example.comicheroes.data.network.webService;

import com.example.comicheroes.data.network.model.HeroResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    // Function wit the endpoint to call the API
    @GET("all.json")
    Call<List<HeroResponse>> getHeroList();
}
