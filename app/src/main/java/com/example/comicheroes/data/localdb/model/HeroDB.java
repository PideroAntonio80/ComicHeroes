package com.example.comicheroes.data.localdb.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

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

//    @ColumnInfo(name = "gender")
//    String gender;
//
//    @ColumnInfo(name = "race")
//    String race;
//
//    @ColumnInfo(name = "heightInFeet")
//    String heightInFeet;
//
//    @ColumnInfo(name = "heightInMetres")
//    String heightInMetres;
//
//    @ColumnInfo(name = "weightInPounds")
//    String weightInPounds;
//
//    @ColumnInfo(name = "weightInKilos")
//    String weightInKilos;
//
//    @ColumnInfo(name = "eyeColor")
//    String eyeColor;
//
//    @ColumnInfo(name = "hairColor")
//    String hairColor;
//
//    @ColumnInfo(name = "fullName")
//    String fullName;
//
//    @ColumnInfo(name = "alterEgos")
//    String alterEgos;
//
//    @ColumnInfo(name = "alias")
//    String alias;
//
//    @ColumnInfo(name = "placeOfBirth")
//    String placeOfBirth;
//
//    @ColumnInfo(name = "firstAppearance")
//    String firstAppearance;
//
//    @ColumnInfo(name = "publisher")
//    String publisher;
//
//    @ColumnInfo(name = "alignment")
//    String alignment;

    /** CONSTRUCTORS */

    public HeroDB(@NonNull String id, String image, String name, String intelligence, String strength, String speed, String durability, String power, String combat, boolean isFavourite) {
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

//    public HeroDB(@NonNull String id, String image, String name, String intelligence, String strength, String speed, String durability, String power, String combat, boolean isFavourite,
//                  String gender, String race, String heightInFeet, String heightInMetres, String weightInPounds, String weightInKilos, String eyeColor, String hairColor,
//                  String fullName, String alterEgos, String alias, String placeOfBirth, String firstAppearance, String publisher, String alignment) {
//        this.id = id;
//        this.image = image;
//        this.name = name;
//        this.intelligence = intelligence;
//        this.strength = strength;
//        this.speed = speed;
//        this.durability = durability;
//        this.power = power;
//        this.combat = combat;
//        this.isFavourite = isFavourite;
//        this.gender = gender;
//        this.race = race;
//        this.heightInFeet = heightInFeet;
//        this.heightInMetres = heightInMetres;
//        this.weightInPounds = weightInPounds;
//        this.weightInKilos = weightInKilos;
//        this.eyeColor = eyeColor;
//        this.hairColor = hairColor;
//        this.fullName = fullName;
//        this.alterEgos = alterEgos;
//        this.alias = alias;
//        this.placeOfBirth = placeOfBirth;
//        this.firstAppearance = firstAppearance;
//        this.publisher = publisher;
//        this.alignment = alignment;
//    }

    /** GETTERS & SETTERS */

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
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

//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getRace() {
//        return race;
//    }
//
//    public void setRace(String race) {
//        this.race = race;
//    }
//
//    public String getHeightInFeet() {
//        return heightInFeet;
//    }
//
//    public void setHeightInFeet(String heightInFeet) {
//        this.heightInFeet = heightInFeet;
//    }
//
//    public String getHeightInMetres() {
//        return heightInMetres;
//    }
//
//    public void setHeightInMetres(String heightInMetres) {
//        this.heightInMetres = heightInMetres;
//    }
//
//    public String getWeightInPounds() {
//        return weightInPounds;
//    }
//
//    public void setWeightInPounds(String weightInPounds) {
//        this.weightInPounds = weightInPounds;
//    }
//
//    public String getWeightInKilos() {
//        return weightInKilos;
//    }
//
//    public void setWeightInKilos(String weightInKilos) {
//        this.weightInKilos = weightInKilos;
//    }
//
//    public String getEyeColor() {
//        return eyeColor;
//    }
//
//    public void setEyeColor(String eyeColor) {
//        this.eyeColor = eyeColor;
//    }
//
//    public String getHairColor() {
//        return hairColor;
//    }
//
//    public void setHairColor(String hairColor) {
//        this.hairColor = hairColor;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getAlterEgos() {
//        return alterEgos;
//    }
//
//    public void setAlterEgos(String alterEgos) {
//        this.alterEgos = alterEgos;
//    }
//
//    public String getAlias() {
//        return alias;
//    }
//
//    public void setAlias(String alias) {
//        this.alias = alias;
//    }
//
//    public String getPlaceOfBirth() {
//        return placeOfBirth;
//    }
//
//    public void setPlaceOfBirth(String placeOfBirth) {
//        this.placeOfBirth = placeOfBirth;
//    }
//
//    public String getFirstAppearance() {
//        return firstAppearance;
//    }
//
//    public void setFirstAppearance(String firstAppearance) {
//        this.firstAppearance = firstAppearance;
//    }
//
//    public String getPublisher() {
//        return publisher;
//    }
//
//    public void setPublisher(String publisher) {
//        this.publisher = publisher;
//    }
//
//    public String getAlignment() {
//        return alignment;
//    }
//
//    public void setAlignment(String alignment) {
//        this.alignment = alignment;
//    }
}
