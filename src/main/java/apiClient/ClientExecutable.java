package apiClient;

import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONException;

import dto.Food;
import dto.Nutrients;
import jsonConverter.JSONSerializer;

public class ClientExecutable {

	public static void main(String[] args) {
		ClientApi client = new ClientApi();
		Food food = null;
		int request = 6;
		switch (request) {
		case 1:
			getAllFoods(client);
			break;
		case 2:		
			getAllFoodsSortedByQuantity(client);
			break;
		case 3:
			getFoodsByName(client, "Spaghetti Bio");
			break;
		case 4:
			getFoodsByNameAndQuantity(client, "Spaghetti Bio", 500);
			break;
		case 5:
			food = CreateFoodObject();
			CreateFood(client, food);			
			break;
		case 6:
			food = CreateFoodObject();
			UpdateFood(client, food);			
			break;
		case 7:
			DeleteFood(client, "34");
			break;
		}
	}
	
	private static void getAllFoods(ClientApi client){
		System.out.println("Getting all the foods !");
		System.out.println(client.getAll());
	}
	
	private static void getAllFoodsSortedByQuantity(ClientApi client){
		System.out.println("Getting all the foods sorted by quantity !");
		System.out.println(client.getSortedByQuantity());
	}
	
	private static void getFoodsByName(ClientApi client, String name){
		System.out.println("Getting foods with the name "+name+" !");
		System.out.println(client.getByName(name));
	}
	
	private static void getFoodsByNameAndQuantity(ClientApi client, String name, double quantity){
		System.out.println("Getting foods with the name "+name+" and the quantity "+quantity+" !");
		System.out.println(client.getByNameAndQuantity(name, quantity));	
	}
	
	private static void CreateFood(ClientApi client, Food food){
		String request = null; 
		try {
			JSONSerializer serializer = new JSONSerializer();
			request = serializer.SerializeJSON(food);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int response = client.create(request);
		if(response==200){
			System.out.println("Insertion done");
		}
		else{
			System.out.println("Error in the transaction, code "+response);
		}
	}
		
	private static Food CreateFoodObject(){
		Food food = UpdateFoodObject();;
		Scanner scan = new Scanner (System.in);
		food.setId("34");
		scan.close();
		return food;
	}
	
	private static void UpdateFood(ClientApi client, Food food){
		String request = null; 
		try {
			JSONSerializer serializer = new JSONSerializer();
			request = serializer.SerializeJSON(food);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int response = client.update(request, food.getId());
		if(response==200){
			System.out.println("update done");
		}
		else{
			System.out.println("Error in the transaction, code "+response);
		}
	}
	
	private static Food UpdateFoodObject(){
		Scanner scan = new Scanner (System.in);
		Food food = new Food();
		food.setName("MyTest");
		food.setIngredients("MyTest");
		food.setQuantity(50);
		food.setUnit("g");
		food.setportion_quantity(21);
		food.setportion_unit("g");
		HashMap<String, Nutrients> nutrients = new HashMap<>();
		Nutrients nutrient = new Nutrients();
		nutrient.setName("protein");
		nutrient.setPer_Day(10);
		nutrient.setPer_Hundred(15);
		nutrient.setPer_Portion(20);
		nutrient.setUnit("g");
		nutrients.put(nutrient.getName(), nutrient);
		nutrients.put(nutrient.getName(), nutrient);
		nutrient.setName("Fiber");
		nutrients.put(nutrient.getName(), nutrient);
		nutrient.setName("Sugars");
		nutrients.put(nutrient.getName(), nutrient);
		nutrient.setName("Salt");
		nutrients.put(nutrient.getName(), nutrient);
		nutrient.setName("Satured Fat");
		nutrients.put(nutrient.getName(), nutrient);
		nutrient.setName("Carbohydrates");
		nutrients.put(nutrient.getName(), nutrient);
		nutrient.setName("Fat");
		nutrients.put(nutrient.getName(), nutrient);
		nutrient.setName("EnergyKcal");
		nutrients.put(nutrient.getName(), nutrient);
		nutrient.setName("Energy");
		nutrients.put(nutrient.getName(), nutrient);
		food.setNutrients(nutrients);
		scan.close();
		return food;		
	}

	private static void DeleteFood(ClientApi client, String id){
		int response = client.delete(id);
		if(response==200){
			System.out.println("Suppresion done");
		}
		else{
			System.out.println("Error in the transaction, code "+response);
		}	}
}
