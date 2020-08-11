package com.example.mongo.api.dto;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class DestinationDto {
	
	private ObjectId locationId;
	private int days;
	private ObjectId hotelId;
	private ObjectId[] restaurantIds;
	private ObjectId[] activityIds;
	private ObjectId specialityId;
	
	public ObjectId getLocationId() {
		return locationId;
	}
	public void setLocationId(ObjectId locationId) {
		this.locationId = locationId;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public ObjectId getHotelId() {
		return hotelId;
	}
	public void setHotelId(ObjectId hotelId) {
		this.hotelId = hotelId;
	}
	public ObjectId[] getRestaurantIds() {
		return restaurantIds;
	}
	public void setRestaurantIds(ObjectId[] restaurantIds) {
		this.restaurantIds = restaurantIds;
	}
	public ObjectId[] getActivityIds() {
		return activityIds;
	}
	public void setActivityIds(ObjectId[] activityIds) {
		this.activityIds = activityIds;
	}
	public ObjectId getSpecialityId() {
		return specialityId;
	}
	public void setSpecialityId(ObjectId specialityId) {
		this.specialityId = specialityId;
	}
	
	
}
