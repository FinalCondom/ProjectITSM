package dataBaseFilling;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dto.Food;
import dto.Nutrients;

//This class send the data collected to the MongoDB database
public class DataSender {
	public static final String ID="_id", NAME="name", 
			INGREDIENT = "ingredients", UNIT = "unit", QUANTITY = "quantity", 
			PORTION_QUANTITY = "portion_quantity", PORTION_UNIT = "portion_unit", 
			NUTRIENTS = "nutrients", PROTEIN = "protein", SUGAR = "sugar", SALT = "salt", 
			FIBER = "fiber", SATUREDFAT = "saturedFat", PER_HUNDRED = "per_hundred", 
			PER_PORTION = "per_portion", PER_DAY = "per_day", CARBOHYDRATES = "carbohydrates", 
			FAT = "fat", ENERGY_KCAL = "energy_kcal", ENERGY = "energy";
	
	ArrayList<Food> foods = new ArrayList<Food>();
	
	public DataSender(ArrayList<Food> foods) {
		for (int i = 0; i < foods.size(); i++) {
			this.foods = foods;
		}
	}
	
	public void sendData(){
		@SuppressWarnings("resource")
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase db = mongo.getDatabase("OpenFoodLLR");
		MongoCollection<Document> coll = db.getCollection("food");
		if(db.getCollection("food")==null){
			db.createCollection("food");
		}
		for(int i=0; i<foods.size(); i++){
			Food foodFrench = foods.get(i);
			Document food = new Document();
			food.put(ID, foodFrench.getId());
			food.put(NAME, foodFrench.getName());
			food.put(INGREDIENT, foodFrench.getIngredient());
			food.put(UNIT, foodFrench.getUnit());
			food.put(QUANTITY, foodFrench.getQuantity());
			food.put(PORTION_UNIT, foodFrench.getPortionUnit());
			food.put(PORTION_QUANTITY, foodFrench.getPortionQuantity());
						
			try {
				food.put(SALT, getNutrientsInfo(foodFrench.getSalt()));
			} catch (NullPointerException e) {
				System.out.println("NO SALT ADDED");
			}
			try {
				food.put(PROTEIN, getNutrientsInfo(foodFrench.getProtein()));
			} catch (NullPointerException e) {
				System.out.println("NO PROTEIN ADDED");
			}
			try {
				food.put(FIBER, getNutrientsInfo(foodFrench.getFiber()));			
			} catch (NullPointerException e) {
				System.out.println("NO FIBER ADDED");
			}
			try {
				food.put(SUGAR, getNutrientsInfo(foodFrench.getSugars()));
			} catch (NullPointerException e) {
				System.out.println("NO SUGAR ADDED");
			}
			try {
				food.put(CARBOHYDRATES, getNutrientsInfo(foodFrench.getCarbohydrates()));
			} catch (NullPointerException e) {
				System.out.println("NO CARBOHYDRATES ADDED");
			}
			try {
				food.put(SATUREDFAT, getNutrientsInfo(foodFrench.getSaturedFat()));
			} catch (NullPointerException e) {
				System.out.println("NO SATUREDFAT ADDED");
			}
			try {
				food.put(FAT, getNutrientsInfo(foodFrench.getFat()));
			} catch (NullPointerException e) {
				System.out.println("NO FAT ADDED");
			}
			try {
				food.put(ENERGY_KCAL, getNutrientsInfo(foodFrench.getEnergyKcal()));
			} catch (NullPointerException e) {
				System.out.println("NO ENERGY_KCAL ADDED");
			}
			try {
				food.put(ENERGY, getNutrientsInfo(foodFrench.getEnergy()));
			} catch (NullPointerException e) {
				System.out.println("NO ENERGY ADDED");
			}
		
			coll.insertOne(food);
		}
	}

	private Document getNutrientsInfo(Nutrients nutrient) {
		Document document = new Document();
		document.put(NAME, nutrient.getName());
		document.put(UNIT, nutrient.getUnit());
		document.put(PER_DAY, nutrient.getPerDay());
		document.put(PER_HUNDRED, nutrient.getPerHundred());
		document.put(PER_PORTION, nutrient.getPerPortion());
		
		return document;
	}
	
}
