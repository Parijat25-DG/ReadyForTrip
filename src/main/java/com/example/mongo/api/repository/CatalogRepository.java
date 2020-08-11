package com.example.mongo.api.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mongo.api.model.Catalog;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, ObjectId>{
	
	@Query
	List<Catalog> findByContinent(String continent);
	
	@Query
	List<Catalog> findByCountry(String country);

}
