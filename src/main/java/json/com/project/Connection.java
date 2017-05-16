package json.com.project;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class Connection {

	public String initiateConnection(){
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = (client).target(getBaseURI());

		//We build the query and then send it
		String response = target.path("api").path("v3").path("products")
				.queryParam("excludes", "images%2Cnutrients")
				.queryParam("barcodes", "7610848337010%2C7610849657797")
				.request()
				.header("Accept", "application/json")
				.header("Authorization", "Token token=fc9317c0f89a70797b43bb303d614af5")
				.accept(MediaType.TEXT_PLAIN).get(String.class);
//		System.out.println(response);
		
		return response;
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("https://www.openfood.ch").build();
	}
}
