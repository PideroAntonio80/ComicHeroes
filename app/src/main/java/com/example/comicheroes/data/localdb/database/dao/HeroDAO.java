package com.example.comicheroes.data.localdb.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.comicheroes.data.localdb.model.HeroDB;

import java.util.List;

@Dao
public interface HeroDAO {

    @Query("select * from hero_db")
    List<HeroDB> getAll();

    @Query("select * from hero_db where id = :idHero")
    HeroDB findById(String idHero);

    @Insert
    void insert(HeroDB heroDB);

    @Update
    void update(HeroDB heroDB);

    @Delete
    void delete(HeroDB heroDB);
}
