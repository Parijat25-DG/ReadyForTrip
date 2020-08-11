package com.example.mongo.api.dto;

import org.bson.types.ObjectId;

public class SavedBookingDto {
	
	private ObjectId bookingId;
	private Double estimatedCost;
	
	public ObjectId getBookingId() {
		return bookingId;
	}
	public void setBookingId(ObjectId bookingId) {
		this.bookingId = bookingId;
	}
	public Double getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	
	

}
