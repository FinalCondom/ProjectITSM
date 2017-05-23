package apiManagement;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import dto.Food;

public interface FoodRepository extends MongoRepository<Food, String> {
	
//	List<Food> findAllOrderByQuantityAsc();
	
	List<Food> findByNameIgnoreCase(String name);

	List<Food> findByQuantity(double quantity);
	
	List<Food> findByNameAndQuantity(String name, double quantity);
	
}	