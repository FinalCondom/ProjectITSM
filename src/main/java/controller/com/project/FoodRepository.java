package controller.com.project;

import org.springframework.data.mongodb.repository.MongoRepository;

import dbObject.com.project.Food;

public interface FoodRepository extends MongoRepository<Food, String> {

}
