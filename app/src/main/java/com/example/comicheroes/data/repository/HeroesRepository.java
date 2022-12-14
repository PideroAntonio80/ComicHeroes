package com.example.comicheroes.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.comicheroes.data.network.mapper.MapperToDomain;
import com.example.comicheroes.data.network.model.HeroResponse;
import com.example.comicheroes.data.network.webService.ApiServices;
import com.example.comicheroes.data.network.webService.RetrofitApiClientGenerator;
import com.example.comicheroes.domain.model.HeroHome;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroesRepository {

    private static final String TAG = HeroesRepository.class.getSimpleName();
    private final ApiServices api;

    private final MapperToDomain mapperToDomain = new MapperToDomain();

    public HeroesRepository() {
        api = RetrofitApiClientGenerator.getRetrofitInstance().create(ApiServices.class);
    }

    public LiveData<List<HeroHome>> getHeroesList() {

        final MutableLiveData<List<HeroHome>> data = new MutableLiveData<>();
        api.getHeroList().enqueue(new Callback<List<HeroResponse>>() {

            @Override
            public void onResponse(Call<List<HeroResponse>> call, Response<List<HeroResponse>> response) {
                if (response.body() != null) {
                    data.setValue(mapperToDomain.getHeroHomeListFromHeroResponseList(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<HeroResponse>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}


