package dataBaseFilling;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dto.Food;
import dto.Nutrients;

public class JSonReader {
	private static ArrayList<Food> foods;
	
	public static final String DATA = "data", ID="id", NAME_TRANSLATIONS="name_translations", 
			INGREDIENT_TRANSLATION = "ingredients_translations", DE="de", FR="fr", IT="it", 
			EN = "en", UNIT = "unit", QUANTITY = "quantity", PORTION_QUANTITY = "portion_quantity", 
			PORTION_UNIT = "portion_unit", NUTRIENTS = "nutrients", PROTEIN = "protein", 
			PER_HUNDRED = "per_hundred", SUGAR = "sugar", SALT = "salt", FIBER = "fiber",
			SATUREDFAT = "saturedFat", PER_PORTION = "per_portion", PER_DAY = "per_day", CARBOHYDRATES = "carbohydrates", 
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
			
			//we get back the id of the object
			food.setId(foodObject.getInt(ID)+"");
			
			//Shortcut to the name translation object
			JSONObject nameTranslationObject = foodObject.getJSONObject(NAME_TRANSLATIONS);
			JSONObject ingredientTranslationObject = foodObject.getJSONObject(INGREDIENT_TRANSLATION);

			try {
				food.setName(nameTranslationObject.getString(FR));
				food.setIngredient(ingredientTranslationObject.getString(FR));
			} catch (JSONException e) {
				try{
					food.setName(nameTranslationObject.getString(EN));
					food.setIngredient(ingredientTranslationObject.getString(EN));
				} catch (JSONException e2){
					try{
						food.setName(nameTranslationObject.getString(DE));
						food.setIngredient(ingredientTranslationObject.getString(DE));
					} catch (JSONException e3){
						try{
							food.setName(nameTranslationObject.getString(IT));
							food.setIngredient(nameTranslationObject.getString(IT));

						} catch (JSONException e4){
							food.setName("NONAME");
							food.setIngredient("NONAME");
							System.out.println("The food you entered has no ingredient in it");
						}
					}
				}
			}
			
			//We set up the different values of the food (unit, quanity and by portion)
			food.setUnit(foodObject.getString(UNIT));
			food.setQuantity(foodObject.getDouble(QUANTITY));
			food.setPortionQuantity(foodObject.getDouble(PORTION_QUANTITY));
			food.setPortionUnit(foodObject.getString(PORTION_UNIT));
			
			JSONObject nutrients = foodObject.getJSONObject(NUTRIENTS);
			
			food.setSalt(addIngredient(food, nutrients, SALT));
			food.setProtein(addIngredient(food, nutrients, PROTEIN));
			food.setFiber(addIngredient(food, nutrients, FIBER));
			food.setSugars(addIngredient(food, nutrients, SUGAR));
			food.setCarbohydrates(addIngredient(food, nutrients, CARBOHYDRATES));
			food.setSaturedFat(addIngredient(food, nutrients, SATUREDFAT));
			food.setEnergyKcal(addIngredient(food, nutrients, ENERGY_KCAL));
			food.setEnergy(addIngredient(food, nutrients, ENERGY));
			
			foods.add(food);
		}
	}
		
	//this method add a given nutrients to a given food
	private static Nutrients addIngredient(Food food, JSONObject nutrients, String ingredientName) {
		JSONObject ingredientObject = null;

		try {
			ingredientObject = nutrients.getJSONObject(ingredientName);
		} catch (JSONException e1) {
		// TODO Auto-generated catch block
			System.out.println("NO "+ingredientName+" ADDED !");
			return null;
		}
		
		Nutrients ingredient = new Nutrients();
		JSONObject nameTranslationObject = null;
		try {
			nameTranslationObject = ingredientObject.getJSONObject(NAME_TRANSLATIONS);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//			We set up the fat translations and their values and handle where there is none
		try {
			ingredient.setName(nameTranslationObject.getString(FR));
		} catch (JSONException e) {
			try{
				ingredient.setName(nameTranslationObject.getString(EN));
			} catch (JSONException e2){
				try{
					ingredient.setName(nameTranslationObject.getString(DE));
				} catch (JSONException e3){
					try{
						ingredient.setName(nameTranslationObject.getString(IT));
					} catch (JSONException e4){
						ingredient.setName("NONAME");
						System.out.println("The "+ingredientName+" you entered has no ingredient in it");
					}
				}
			}
		}
		try {
			ingredient.setUnit(ingredientObject.getString(UNIT));
		} catch (Exception e) {
			ingredient.setUnit("");
		}	
		try {
			ingredient.setPerHundred(ingredientObject.getDouble(PER_HUNDRED));
		} catch (JSONException e) {
			ingredient.setPerHundred(0.0);
		}
		try {
			ingredient.setPerPortion(ingredientObject.getDouble(PER_PORTION));
		} catch (JSONException e) {
			ingredient.setPerPortion(0.0);
		}
		try {
			ingredient.setPerDay(ingredientObject.getDouble(PER_DAY));
		} catch (JSONException e) {
			ingredient.setPerDay(0.0);
		}
		return ingredient;
	}
	
	public ArrayList<Food> getFoods() {
		return foods;
	}
}
