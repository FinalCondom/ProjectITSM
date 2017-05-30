package dataBaseFilling;

import org.json.JSONException;

import apiClient.ClientApi;
import dto.Food;
import jsonConverter.*;

public class FillData {

	public static void main(String[] args) {
		Connection connection = new Connection();
		JSonReaderOpenFood reader = new JSonReaderOpenFood();
		try {
			reader.read(connection.initiateConnection());
			System.out.println("Filling the data into OpenFoodLLR");
		} catch (JSONException e) {
			System.out.println("Unable to fill the database !");
		}
		ClientApi client = new ClientApi();


		for (Food food : reader.getFoods()) {
			String request = null; 

			try {
				JSONSerializer serializer = new JSONSerializer();
				request = serializer.SerializeJSON(food);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			client.create(request);		
			};
	}

}
