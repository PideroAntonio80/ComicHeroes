package com.example.comicheroes.data.repository;

import com.example.comicheroes.data.localdb.database.dao.HeroDAO;
import com.example.comicheroes.data.localdb.model.HeroDB;

import java.util.List;

public class HeroDbRepositoryImp implements HeroDbRepository {

    HeroDAO dao;

    public HeroDbRepositoryImp(HeroDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<HeroDB> getAllHeroes() {
        return dao.getAll();
    }

    @Override
    public HeroDB findHeroById(String idHero) {
        return dao.findById(idHero);
    }

    @Override
    public void insertHero(HeroDB heroDB) {
        dao.insert(heroDB);
    }

    @Override
    public void updateHero(HeroDB heroDB) {
        dao.update(heroDB);
    }

    @Override
    public void deleteHero(HeroDB heroDB) {
        dao.delete(heroDB);
    }
}
