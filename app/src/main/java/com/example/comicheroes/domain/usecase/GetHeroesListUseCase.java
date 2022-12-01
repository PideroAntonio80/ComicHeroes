package com.example.comicheroes.domain.usecase;

import androidx.lifecycle.LiveData;

import com.example.comicheroes.data.repository.HeroesRepository;
import com.example.comicheroes.domain.model.HeroHome;

import java.util.List;

public class GetHeroesListUseCase {

    private HeroesRepository repository;

    public GetHeroesListUseCase(HeroesRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<HeroHome>> runUseCase() {

        return repository.getHeroesList();
    }
}
