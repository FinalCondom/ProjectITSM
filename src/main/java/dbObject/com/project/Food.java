package dbObject.com.project;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Food {
	Translation withoutNutrientsTranslation, withNutrientsTranslation;
	ArrayList<Nutrients>nutrients;
	String unit, portionUnit;
	double quantity, portionQuantity;
	
	public ArrayList<Nutrients> getNutrients() {
		return nutrients;
	}
	public void setNutrients(ArrayList<Nutrients> nutrients) {
		this.nutrients = nutrients;
	}
	public Translation getWithoutNutrientsTranslation() {
		return withoutNutrientsTranslation;
	}
	public void setWithoutNutrientsTranslation(Translation withoutNutrientsTranslation) {
		this.withoutNutrientsTranslation = withoutNutrientsTranslation;
	}
	public Translation getWithNutrientsTranslation() {
		return withNutrientsTranslation;
	}
	public void setWithNutrientsTranslation(Translation withNutrientsTranslation) {
		this.withNutrientsTranslation = withNutrientsTranslation;
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
	public void setPortionQuantity(double portionQuantity) {
		this.portionQuantity = portionQuantity;
	}	
}

class Nutrients{
	Translation translation;
	String unit;
	double perHundred, perPortion, perDay;
	
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
	String francais, deutsch, english, italiano;

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

}