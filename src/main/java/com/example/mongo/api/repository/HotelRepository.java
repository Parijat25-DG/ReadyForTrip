package com.example.mongo.api.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mongo.api.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, ObjectId>{
	
	@Query
	List<Hotel> findByCategory(String category);
	
}
