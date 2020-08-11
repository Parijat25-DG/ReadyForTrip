package com.example.mongo.api.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mongo.api.model.Specialities;

@Repository
public interface SpecialitiesRepository extends MongoRepository<Specialities, ObjectId>{
	
	@Query
	List<Specialities> findByType(String type);
	
}
