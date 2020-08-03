package com.example.mongo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.api.dto.RestaurantDto;
import com.example.mongo.api.service.RestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/findAllRestaurant")
	public List<RestaurantDto> getRestaurants() {
		return restaurantService.getAllRestaurants();
	}
	
	@GetMapping("/findRestaurantByCategory/{category}")
	public List<RestaurantDto> getRestaurantsByCategory(@PathVariable String category) {
		return restaurantService.getRestaurantByCategory(category);
	}
	
	@GetMapping("/findRestaurantByCuisine/{cuisine}")
	public List<RestaurantDto> getRestaurantsByCuisine(@PathVariable String cuisine) {
		return restaurantService.getRestaurantByCuisine(cuisine);
	}

}
