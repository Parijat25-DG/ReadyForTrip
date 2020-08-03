package com.example.mongo.api.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mongo.api.model.Restaurant;

public interface RestaurantRepository extends MongoRepository<Restaurant, ObjectId>{
	
	@Query
	List<Restaurant> findByCategory(String category);
	
	@Query
	List<Restaurant> findByCuisine(String cuisine);

}
