package com.project;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	//Before running this project you need to launch mongodb and use the DB OpenFoodLLR on application.properties
	//	spring.data.mongodb.uri=mongodb://localhost:27017
	//	spring.data.mongodb.database=OpenFoodLLR
	public static void main(String[] args) {
		try {
			JSonReader reader = new JSonReader();
			System.out.println("Filling the data into OpenFoodLLR");
			
			DataSender dataSender = new DataSender(reader.getFoods());
			dataSender.sendData();
		} catch (JSONException e) {
			System.out.println("Unable to fill the database !");
		}
		
		
		SpringApplication.run(ProjectApplication.class, args);
		System.out.println("System up and running !");
	}
}
