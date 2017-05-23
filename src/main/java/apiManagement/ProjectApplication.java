package apiManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	//Before running this project you need to launch mongodb and use the DB OpenFoodLLR on application.properties
	//	spring.data.mongodb.uri=mongodb://localhost:27017
	//	spring.data.mongodb.database=OpenFoodLLR
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}
