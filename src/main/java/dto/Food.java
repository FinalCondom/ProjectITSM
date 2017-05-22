package com.project;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Food {
	private Translation nameTranslations, ingredientTranslations;
	private Nutrients protein, carbohydrates, fat, energy_kcal, energy;
	private String unit, portionUnit;
	private double quantity, portionQuantity;
	
	public Translation getNameTranslations() {
		return nameTranslations;
	}
	public void setNameTranslations(Translation nameTranslations) {
		this.nameTranslations = nameTranslations;
	}
	public Nutrients getProtein() {
		return protein;
	}
	public void setProtein(Nutrients protein) {
		this.protein = protein;
	}
	public Nutrients getCarbohydrates() {
		return carbohydrates;
	}
	public void setCarbohydrates(Nutrients carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	public Nutrients getFat() {
		return fat;
	}
	public void setFat(Nutrients fat) {
		this.fat = fat;
	}
	public Nutrients getEnergy_kcal() {
		return energy_kcal;
	}
	public void setEnergy_kcal(Nutrients energy_kcal) {
		this.energy_kcal = energy_kcal;
	}
	public Nutrients getEnergy() {
		return energy;
	}
	public void setEnergy(Nutrients energy) {
		this.energy = energy;
	}
	public Translation getIngredientTranslations() {
		return ingredientTranslations;
	}
	public void setIngredientTranslations(Translation ingredientTranslations) {
		this.ingredientTranslations = ingredientTranslations;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPortionUnit() {
		return portionUnit;
	}
	public void setPortionUnit(String portionUnit) {
		this.portionUnit = portionUnit;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getPortionQuantity() {
		return portionQuantity;
	}
	@Override
	public String toString() {
		return "Food [nameTranslations=" + nameTranslations + ", ingredientTranslations=" + ingredientTranslations
				+ ", protein=" + protein + ", carbohydrates=" + carbohydrates + ", fat=" + fat + ", energy_kcal="
				+ energy_kcal + ", energy=" + energy + ", unit=" + unit + ", portionUnit=" + portionUnit + ", quantity="
				+ quantity + ", portionQuantity=" + portionQuantity + "]";
	}
	public void setPortionQuantity(double portionQuantity) {
		this.portionQuantity = portionQuantity;
	}	
}

class Nutrients{
	private Translation translation;
	private String unit;
	private double perHundred, perPortion, perDay;
	
	@Override
	public String toString() {
		return "Nutrients [translation=" + translation + ", unit=" + unit + ", perHundred=" + perHundred
				+ ", perPortion=" + perPortion + ", perDay=" + perDay + "]";
	}
	public Translation getTranslation() {
		return translation;
	}
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPerHundred() {
		return perHundred;
	}
	public void setPerHundred(double perHundred) {
		this.perHundred = perHundred;
	}
	public double getPerPortion() {
		return perPortion;
	}
	public void setPerPortion(double perPortion) {
		this.perPortion = perPortion;
	}
	public double getPerDay() {
		return perDay;
	}
	public void setPerDay(double perDay) {
		this.perDay = perDay;
	}
}

class Translation{
	private String francais, deutsch, english, italiano;

	public String getFrancais() {
		return francais;
	}

	public void setFrancais(String francais) {
		this.francais = francais;
	}

	public String getDeutsch() {
		return deutsch;
	}

	public void setDeutsch(String deutsch) {
		this.deutsch = deutsch;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getItaliano() {
		return italiano;
	}

	public void setItaliano(String italiano) {
		this.italiano = italiano;
	}

	@Override
	public String toString() {
		return "Translation [francais=" + francais + ", deutsch=" + deutsch + ", english=" + english + ", italiano="
				+ italiano + "]";
	}
	
}