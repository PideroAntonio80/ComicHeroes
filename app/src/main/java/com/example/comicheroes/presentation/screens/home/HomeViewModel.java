package com.example.comicheroes.presentation.screens.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicheroes.data.repository.HeroesRepository;
import com.example.comicheroes.domain.model.HeroDetail;
import com.example.comicheroes.domain.usecase.GetHeroesListUseCase;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private GetHeroesListUseCase getHeroesListUseCase;
    private HeroesRepository heroesRepository;
    private LiveData<List<HeroDetail>> heroesListLiveData;

    public HomeViewModel(@NonNull Application application) {

        super(application);

        heroesRepository = new HeroesRepository();
        getHeroesListUseCase = new GetHeroesListUseCase(heroesRepository);
        this.heroesListLiveData = getHeroesListUseCase.runUseCase();
    }

    public LiveData<List<HeroDetail>> getHeroesListResponseLiveData() {
        return heroesListLiveData;
    }
}

