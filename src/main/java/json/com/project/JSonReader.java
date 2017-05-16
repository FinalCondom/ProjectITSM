package json.com.project;

import org.json.JSONException;
import org.json.JSONObject;

import dbObject.com.project.Food;

public class JSonReader {
	private static Food food;
	private static Connection connection;
	public static void main (String[] args) throws JSONException{
		connection = new Connection();
		
		String request = (connection.initiateConnection());
		read(request);
		System.out.println(request);
	}

	public static void read(String dataFromAPIParam) throws JSONException{
		String dataFromAPI = dataFromAPIParam;
		
		
		JSONObject mainObject = null;

		mainObject = new JSONObject(dataFromAPI);
		System.out.println(mainObject.getJSONArray("data").getClass().toString());
		System.out.println("Connection to the db successful !");


		System.out.println("HELLO");
	}
}
