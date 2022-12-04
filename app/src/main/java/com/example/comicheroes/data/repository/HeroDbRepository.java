package com.example.comicheroes.data.repository;

import com.example.comicheroes.data.localdb.model.HeroDB;

import java.util.List;

public interface HeroDbRepository {

    List<HeroDB> getAllHeroes();
    HeroDB findHeroById(String idHero);
    void insertHero(HeroDB heroDB);
    void updateHero(HeroDB heroDB);
    void deleteHero(HeroDB heroDB);
}
