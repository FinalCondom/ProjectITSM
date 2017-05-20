package com.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodRestController {
	@Autowired
	FoodRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Food>getAll(){
		System.out.println("Test");
		return repo.findAll();
	}

}
