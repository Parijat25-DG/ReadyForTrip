package com.example.mongo.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.mongo.api.dto.RestaurantDto;
import com.example.mongo.api.model.Restaurant;
import com.example.mongo.api.repository.RestaurantRepository;

@Component
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public List<RestaurantDto> getAllRestaurants() {
		List<Restaurant> list = restaurantRepository.findAll();
		List<RestaurantDto> dtoList = new ArrayList<RestaurantDto>();
		for(Restaurant restaurant:list) {
			dtoList.add(mapResponse(restaurant));
		}
		return dtoList;
	}
	
	public List<RestaurantDto> getRestaurantByCategory(@PathVariable String category) {
		List<Restaurant> list = restaurantRepository.findByCategory(category);
		List<RestaurantDto> dtoList = new ArrayList<RestaurantDto>();
		for(Restaurant restaurant:list) {
			dtoList.add(mapResponse(restaurant));
		}
		return dtoList;
	}
	
	public List<RestaurantDto> getRestaurantByCuisine(@PathVariable String cuisine) {
		List<Restaurant> list = restaurantRepository.findByCuisine(cuisine);
		List<RestaurantDto> dtoList = new ArrayList<RestaurantDto>();
		for(Restaurant restaurant:list) {
			dtoList.add(mapResponse(restaurant));
		}
		return dtoList;
	}
	
	private RestaurantDto mapResponse(Restaurant restaurant){
		RestaurantDto dto = new RestaurantDto();
		dto.setCategory(restaurant.getCategory());
		dto.setCuisine(restaurant.getCuisine());
		dto.setLocations(restaurant.getLocations());
		dto.setName(restaurant.getName());
		dto.setPrice(restaurant.getPrice());
		dto.setReview(restaurant.getReview());
		return dto;
	}

}
