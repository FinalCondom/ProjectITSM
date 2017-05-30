package apiManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.Food;

@RestController
@RequestMapping("/food")
public class FoodRestController {
	@Autowired
	FoodRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Food> getAll(){
		return repo.findAll();
	}
	@RequestMapping(method=RequestMethod.GET, value="quantity")
	public List<Food> getAllByQuantites(){
		return repo.findAll(new Sort(Sort.Direction.ASC, "quantity"));
	}
	
	@RequestMapping(method=RequestMethod.GET, params={"name"})
	public List<Food> getByNames(@RequestParam(value = "name") String name){
		return repo.findByNameIgnoreCase(name);	
	}

	@RequestMapping(method=RequestMethod.GET, params={"name", "quantity"})
	public List<Food> getByNamesAndQuantity(@RequestParam(value = "name") String name, 
			@RequestParam(value = "quantity") double quantity){
		return repo.findByNameAndQuantity(name, quantity);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Food create(@RequestBody Food food){
		return repo.save(food);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public void delete(@PathVariable String id){
		repo.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="{id}")
	public Food update(@RequestBody Food food, @PathVariable String id){
		Food update = repo.findOne(id);
		update.setName(food.getName());
		update.setIngredients(food.getIngredients());
		update.setQuantity(food.getQuantity());
		update.setUnit(food.getUnit());
		update.setportion_quantity(food.getportion_quantity());
		update.setportion_unit(food.getportion_unit());
		update.setNutrients(food.getNutrients());
		return repo.save(update);
	}
	
}
