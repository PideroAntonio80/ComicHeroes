package com.example.comicheroes.presentation.screens.detail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicheroes.data.repository.HeroesRepository;
import com.example.comicheroes.domain.model.HeroDetail;
import com.example.comicheroes.domain.usecase.GetHeroDetailUseCase;

public class DetailViewModel extends AndroidViewModel {

//    private GetHeroDetailUseCase getHeroDetailUseCase;
//    private HeroesRepository heroesRepository;
//    private LiveData<HeroDetail> heroDetailLiveData;

    public DetailViewModel(@NonNull Application application) {
        super(application);

//        heroesRepository = new HeroesRepository();
//        getHeroDetailUseCase = new GetHeroDetailUseCase(heroesRepository);
    }

//    public LiveData<HeroDetail> getHeroDetailResponseLiveData(String idHero) {
//        this.heroDetailLiveData = getHeroDetailUseCase.runUseCase(idHero);
//        return heroDetailLiveData;
//    }
}
