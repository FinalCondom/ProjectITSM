package dataBaseFilling;

import org.json.JSONException;

public class FillData {

	public static void main(String[] args) {
		JSonReader reader = null;
		try {
			reader = new JSonReader();
			System.out.println("Filling the data into OpenFoodLLR");
		} catch (JSONException e) {
			System.out.println("Unable to fill the database !");
		}
		DataSender dataSender = new DataSender(reader.getFoods());
		dataSender.sendData();

	}

}
