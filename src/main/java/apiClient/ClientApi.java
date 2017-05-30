package apiClient;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class ClientApi {
	
	public String getAll(){
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = (client).target(getBaseURI());

		//We build the query and then send it
		String response = target
				.request()
				.header("Accept", "application/json")
				.accept(MediaType.TEXT_PLAIN).get(String.class);
				
		return response;
		
//		JSonReaderAPI jSonReader = new JSonReaderAPI();
//		try {
//			jSonReader.read(response);
//		} catch (JSONException e) {
//			System.out.println("Unable to read data");
//		}
//		return jSonReader.getFoods();
	}	
	
	public String getSortedByQuantity(){
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = (client).target(getBaseURI());

		//We build the query and then send it
		String response = target.path("quantity")
				.request()
				.header("Accept", "application/json")
				.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		return response;
	}
	
	public String getByName(String name){
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = (client).target(getBaseURI());

		//We build the query and then send it
		String response = target
				.queryParam("name", name)
				.request()
				.header("Accept", "application/json")
				.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		return response;
	}
	
	public String getByNameAndQuantity(String name, double quantity){
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = (client).target(getBaseURI());

		//We build the query and then send it
		String response = target
				.queryParam("name", name).queryParam("quantity", quantity)
				.request()
				.header("Accept", "application/json")
				.accept(MediaType.TEXT_PLAIN).get(String.class);
//		System.out.println(response);
		
		return response;
	}
	
	public int create(String food){
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);
		WebTarget target = (client).target(getBaseURI());

		//We build the query and then send it
		Response response = target
				.request()
				.header("Accept", "application/json")
				.accept(MediaType.TEXT_PLAIN).post(Entity.json(food));
		
		return response.getStatus();
	}
	
	public int update(String food, String id){
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = (client).target(getBaseURI());

		//We build the query and then send it
		Response response = target
				.path("/"+ id)
				.request()
				.header("Accept", "application/json")
				.accept(MediaType.TEXT_PLAIN).put(Entity.json(food));
		
//		System.out.println(response);
		
		return response.getStatus();
	}
	public int delete(String id){
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = (client).target(getBaseURI());

		//We build the query and then send it
		Response response = target.
				path("/"+id)
				.request()
				.header("Accept", "application/json")
				.accept(MediaType.TEXT_PLAIN).delete();
		
//		System.out.println(response);
		
		return response.getStatus();
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/food").build();
	}
}
