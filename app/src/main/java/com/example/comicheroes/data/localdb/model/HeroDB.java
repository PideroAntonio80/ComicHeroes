package com.example.comicheroes.data.localdb.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hero_db")
public class HeroDB {

    @PrimaryKey
    @NonNull
    String id;

    @ColumnInfo(name = "image")
    String image;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "intelligence")
    String intelligence;

    @ColumnInfo(name = "strength")
    String strength;

    @ColumnInfo(name = "speed")
    String speed;

    @ColumnInfo(name = "durability")
    String durability;

    @ColumnInfo(name = "power")
    String power;

    @ColumnInfo(name = "combat")
    String combat;

    @ColumnInfo(name = "isFavourite")
    boolean isFavourite;

    public HeroDB(String id, String image, String name, String intelligence, String strength, String speed, String durability, String power, String combat, boolean isFavourite) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
        this.isFavourite = isFavourite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCombat() {
        return combat;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
