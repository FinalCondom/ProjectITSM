package com.project;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonReader {
	private static ArrayList<Food> foods;
	
	public static final String DATA = "data", NAME_TRANSLATIONS="name_translations", 
			INGREDIENT_TRANSLATION = "ingredients_translations", DE="de", FR="fr", IT="it", 
			EN = "en", UNIT = "unit", QUANTITY = "quantity", PORTION_QUANTITY = "portion_quantity", 
			PORTION_UNIT = "portion_unit", 
			NUTRIENTS = "nutrients", PROTEIN = "protein", PER_HUNDRED = "per_hundred", 
			PER_PORTION = "per_portion", PER_DAY = "per_day", CARBOHYDRATES = "carbohydrates", 
			FAT = "fat", ENERGY_KCAL = "energy_kcal", ENERGY = "energy";
	
	private static Connection connection;
	public JSonReader() throws JSONException{
		connection = new Connection();
		String request = (connection.initiateConnection());
		read(request);
	}

	public static void read(String dataFromAPIParam) throws JSONException{
		String dataFromAPI = dataFromAPIParam;
		foods = new ArrayList<Food>();
		
		JSONObject mainObject = null;
		
		mainObject = new JSONObject(dataFromAPI);
		//The data array symbolize all object into the JSON file
		JSONArray dataArray = mainObject.getJSONArray(DATA);
		//We take all objects separately
		for(int i=0; i < dataArray.length(); i++){
			//Each object is a new food
			Food food = new Food();
			
			//Shortcut to the food object
			JSONObject foodObject = dataArray.getJSONObject(i);
			//Shortcut to the name translation object
			JSONObject nameTranslationObject = foodObject.getJSONObject(NAME_TRANSLATIONS);
			
			//We set up a translation for the name of the object, we handle the case when there is no translations
			Translation nameTranslation = new Translation();
			try {
				nameTranslation.setDeutsch(nameTranslationObject.getString(DE));
			} catch (JSONException e) {
				nameTranslation.setDeutsch("");
			}
			try {
				nameTranslation.setFrancais(nameTranslationObject.getString(FR));
			} catch (JSONException e) {
				nameTranslation.setFrancais("");
			}
			try {
				nameTranslation.setItaliano(nameTranslationObject.getString(IT));
			} catch (JSONException e) {
				nameTranslation.setItaliano("");
			}
			try {
				nameTranslation.setEnglish(nameTranslationObject.getString(EN));
			} catch (JSONException e) {
				nameTranslation.setEnglish("");
			}

			food.setNameTranslations(nameTranslation);
			
			JSONObject ingredientTranslationObject = foodObject.getJSONObject(INGREDIENT_TRANSLATION);
			
			Translation ingredientTranslation = new Translation();
			//We set up a translation for the name of the object with his ingredient, we handle the case when there is no translations
			try {
				ingredientTranslation.setDeutsch(ingredientTranslationObject.getString(DE));
			} catch (JSONException e) {
				ingredientTranslation.setDeutsch("");
			}
			try {
				ingredientTranslation.setFrancais(ingredientTranslationObject.getString(FR));
			} catch (JSONException e) {
				ingredientTranslation.setFrancais("");
			}
			try {
				ingredientTranslation.setItaliano(ingredientTranslationObject.getString(IT));
			} catch (JSONException e) {
				ingredientTranslation.setItaliano("");
			}
			try {
				ingredientTranslation.setEnglish(ingredientTranslationObject.getString(EN));
			} catch (JSONException e) {
				ingredientTranslation.setEnglish("");
			}
			
			//We set up the different values of the food (unit, quanity and by portion)
			food.setUnit(foodObject.getString(UNIT));
			food.setQuantity(foodObject.getDouble(QUANTITY));
			food.setPortionQuantity(foodObject.getDouble(PORTION_QUANTITY));
			food.setPortionUnit(foodObject.getString(PORTION_UNIT));
			
			
			
			JSONObject nutrients = foodObject.getJSONObject(NUTRIENTS);
			
			JSONObject proteinObject = nutrients.getJSONObject(PROTEIN);
			//We set up the protein
			Nutrients protein = new Nutrients();
			
			JSONObject proteinTranslationObject = proteinObject.getJSONObject(NAME_TRANSLATIONS);
			
			Translation proteinTranslation = new Translation();
//			We set up the protein translations and handle where there is none
			try {
				proteinTranslation.setDeutsch(proteinTranslationObject.getString(DE));
			} catch (JSONException e) {
				proteinTranslation.setDeutsch("");
			}
			try {
				proteinTranslation.setFrancais(proteinTranslationObject.getString(FR));
			} catch (JSONException e) {
				proteinTranslation.setFrancais("");
			}
			try {
				proteinTranslation.setItaliano(proteinTranslationObject.getString(IT));
			} catch (JSONException e) {
				proteinTranslation.setItaliano("");
			}
			try {
				proteinTranslation.setEnglish(proteinTranslationObject.getString(EN));
			} catch (JSONException e) {
				proteinTranslation.setEnglish("");
			}
			
			//We set up the protein values and handle when there is no way
			protein.setTranslation(proteinTranslation);
			protein.setUnit(proteinObject.getString(UNIT));
			try {
				protein.setPerHundred(proteinObject.getDouble(PER_HUNDRED));
			} catch (JSONException e) {
				protein.setPerHundred(0.0);
			}
			try {
				protein.setPerPortion(proteinObject.getDouble(PER_PORTION));
			} catch (JSONException e) {
				protein.setPerPortion(0.0);
			}
			try {
				protein.setPerDay(proteinObject.getDouble(PER_DAY));
			} catch (JSONException e) {
				protein.setPerDay(0.0);
			}
			
			food.setProtein(protein);
			
			JSONObject carbohydratesObject = nutrients.getJSONObject(CARBOHYDRATES);
			
			Nutrients carbohydrates = new Nutrients();
			
			JSONObject carbohydratesTranslationObject = carbohydratesObject.getJSONObject(NAME_TRANSLATIONS);
			
			Translation carbohydratesTranslation = new Translation();
//			We set up the carbohydrates translations and their values and handle where there is none
			try {
				carbohydratesTranslation.setDeutsch(carbohydratesTranslationObject.getString(DE));
			} catch (JSONException e) {
				carbohydratesTranslation.setDeutsch("");
			}
			try {
				carbohydratesTranslation.setFrancais(carbohydratesTranslationObject.getString(FR));
			} catch (JSONException e) {
				carbohydratesTranslation.setFrancais("");
			}
			try {
				carbohydratesTranslation.setItaliano(carbohydratesTranslationObject.getString(IT));
			} catch (JSONException e) {
				carbohydratesTranslation.setItaliano("");
			}
			try {
				carbohydratesTranslation.setEnglish(carbohydratesTranslationObject.getString(EN));
			} catch (JSONException e) {
				carbohydratesTranslation.setEnglish("");
			}
			
			carbohydrates.setTranslation(carbohydratesTranslation);
			carbohydrates.setUnit(carbohydratesObject.getString(UNIT));
			try {
				carbohydrates.setPerHundred(carbohydratesObject.getDouble(PER_HUNDRED));
			} catch (JSONException e) {
				carbohydrates.setPerHundred(0.0);
			}
			try {
				carbohydrates.setPerPortion(carbohydratesObject.getDouble(PER_PORTION));
			} catch (JSONException e) {
				carbohydrates.setPerPortion(0.0);
			}
			try {
				carbohydrates.setPerDay(carbohydratesObject.getDouble(PER_DAY));
			} catch (JSONException e) {
				carbohydrates.setPerDay(0.0);
			}
			
			food.setCarbohydrates(carbohydrates);
			
			JSONObject fatObject = nutrients.getJSONObject(PROTEIN);
			
			Nutrients fat = new Nutrients();
			
			JSONObject fatTranslationObject = fatObject.getJSONObject(NAME_TRANSLATIONS);
			
			Translation fatTranslation = new Translation();
//			We set up the fat translations and their values and handle where there is none

			try {
				fatTranslation.setDeutsch(fatTranslationObject.getString(DE));
			} catch (JSONException e) {
				fatTranslation.setDeutsch("");
			}
			try {
				fatTranslation.setFrancais(fatTranslationObject.getString(FR));
			} catch (JSONException e) {
				fatTranslation.setFrancais("");
			}
			try {
				fatTranslation.setItaliano(fatTranslationObject.getString(IT));
			} catch (JSONException e) {
				fatTranslation.setItaliano("");
			}
			try {
				fatTranslation.setEnglish(fatTranslationObject.getString(EN));
			} catch (JSONException e) {
				fatTranslation.setEnglish("");
			}
			
			fat.setTranslation(fatTranslation);
			fat.setUnit(fatObject.getString(UNIT));
			
			try {
				fat.setPerHundred(fatObject.getDouble(PER_HUNDRED));
			} catch (JSONException e) {
				fat.setPerHundred(0.0);
			}
			try {
				fat.setPerPortion(fatObject.getDouble(PER_PORTION));
			} catch (JSONException e) {
				fat.setPerPortion(0.0);
			}
			try {
				fat.setPerDay(fatObject.getDouble(PER_DAY));
			} catch (JSONException e) {
				fat.setPerDay(0.0);
			}
						
			food.setFat(fat);
			
			JSONObject energyKCalObject = nutrients.getJSONObject(PROTEIN);
			
			Nutrients energyKCal = new Nutrients();
			
			JSONObject energyKCalTranslationObject = energyKCalObject.getJSONObject(NAME_TRANSLATIONS);
			
			Translation energyKCalTranslation = new Translation();
//			We set up the energyKCal translations and their values and handle where there is none

			try {
				energyKCalTranslation.setDeutsch(energyKCalTranslationObject.getString(DE));
			} catch (JSONException e) {
				energyKCalTranslation.setDeutsch("");
			}
			try {
				energyKCalTranslation.setFrancais(energyKCalTranslationObject.getString(FR));
			} catch (JSONException e) {
				energyKCalTranslation.setFrancais("");
			}
			try {
				energyKCalTranslation.setItaliano(energyKCalTranslationObject.getString(IT));
			} catch (JSONException e) {
				energyKCalTranslation.setItaliano("");
			}
			try {
				energyKCalTranslation.setEnglish(energyKCalTranslationObject.getString(EN));
			} catch (Exception e) {
				energyKCalTranslation.setEnglish("");
			}
			
			energyKCal.setTranslation(energyKCalTranslation);
			energyKCal.setUnit(energyKCalObject.getString(UNIT));
			
			try {
				energyKCal.setPerHundred(energyKCalObject.getDouble(PER_HUNDRED));
			} catch (JSONException e) {
				energyKCal.setPerHundred(0.0);
			}
			try {
				energyKCal.setPerPortion(energyKCalObject.getDouble(PER_PORTION));
			} catch (JSONException e) {
				energyKCal.setPerPortion(0.0);
			}
			try {
				energyKCal.setPerDay(energyKCalObject.getDouble(PER_DAY));
			} catch (JSONException e) {
				energyKCal.setPerDay(0.0);
			}
					
			
			food.setEnergy_kcal(energyKCal);
			
			JSONObject energyObject = nutrients.getJSONObject(PROTEIN);
			
			Nutrients energy = new Nutrients();
			
			JSONObject energyTranslationObject = energyObject.getJSONObject(NAME_TRANSLATIONS);
			
			Translation energyTranslation = new Translation();
//			We set up the energy translations and their values and handle where there is none

			try {
				energyTranslation.setDeutsch(energyTranslationObject.getString(DE));
			} catch (JSONException e) {
				energyTranslation.setDeutsch("");
			}
			try {
				energyTranslation.setFrancais(energyTranslationObject.getString(FR));
			} catch (JSONException e) {
				energyTranslation.setFrancais("");
			}
			try {
				energyTranslation.setItaliano(energyTranslationObject.getString(IT));
			} catch (JSONException e) {
				energyTranslation.setItaliano("");
			}
			try {
				energyTranslation.setEnglish(energyTranslationObject.getString(EN));
			} catch (Exception e) {
				energyTranslation.setEnglish("");
			}
			
			energy.setTranslation(energyTranslation);
			energy.setUnit(energyObject.getString(UNIT));
			
			try {
				energy.setPerHundred(energyObject.getDouble(PER_HUNDRED));
			} catch (JSONException e) {
				energy.setPerHundred(0.0);
			}
			try {
				energy.setPerPortion(energyObject.getDouble(PER_PORTION));
			} catch (JSONException e) {
				energy.setPerPortion(0.0);
			}
			try {
				energy.setPerDay(energyObject.getDouble(PER_DAY));
			} catch (JSONException e) {
				energy.setPerDay(0.0);
			}
			
			food.setEnergy(energy);
			
			foods.add(food);
		}
//		for(int i=0; i<foods.size(); i++){
//			System.out.println(foods.get(i).toString());
//		}
		
	}
	public ArrayList<Food> getFoods() {
		return foods;
	}
}
