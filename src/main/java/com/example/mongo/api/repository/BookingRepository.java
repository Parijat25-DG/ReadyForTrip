package com.example.mongo.api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongo.api.model.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, ObjectId>{
	
}
