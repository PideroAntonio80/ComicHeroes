package com.example.comicheroes.data.network.model;

import com.google.gson.annotations.SerializedName;

public class PowerstatsResponse {

	@SerializedName("intelligence")
	private int intelligence;

	@SerializedName("strength")
	private int strength;

	@SerializedName("speed")
	private int speed;

	@SerializedName("durability")
	private int durability;

	@SerializedName("power")
	private int power;

	@SerializedName("combat")
	private int combat;

	/** GETTERS & SETTERS */

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCombat() {
		return combat;
	}

	public void setCombat(int combat) {
		this.combat = combat;
	}
}