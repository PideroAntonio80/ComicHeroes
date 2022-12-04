package com.example.comicheroes.data.localdb.database;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.comicheroes.data.localdb.database.dao.HeroDAO;
import com.example.comicheroes.data.localdb.model.HeroDB;

@Database(
        entities = {HeroDB.class},
        version = 3,
        autoMigrations = {@AutoMigration(from = 2, to = 3)},
        exportSchema = true
)
public abstract class HeroDatabase extends RoomDatabase {

    private static volatile HeroDatabase INSTANCE;

    public abstract HeroDAO heroDAO();

    public static HeroDatabase getInstance(Context context) {

        if(INSTANCE == null){

            INSTANCE = Room.databaseBuilder(context, HeroDatabase.class,"checklist.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return INSTANCE;
    }
}
