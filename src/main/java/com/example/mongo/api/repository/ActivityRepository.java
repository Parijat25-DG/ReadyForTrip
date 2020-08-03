package com.example.mongo.api.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mongo.api.model.Activity;

public interface ActivityRepository extends MongoRepository<Activity, ObjectId>{
	
	@Query
	List<Activity> findByCategory(String category);
	
}
