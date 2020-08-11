package com.example.mongo.api.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

@Document(collection = "Booking")
public class Booking {
	
	@Id
	private ObjectId _id;
    private String travellerId;
    private List<Object> destinationList;
    private Double estimatedCost;
	
    public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getTravellerId() {
		return travellerId;
	}
	public void setTravellerId(String travellerId) {
		this.travellerId = travellerId;
	}
	public List<Object> getDestinationList() {
		return destinationList;
	}
	public void setDestinationList(List<Object> destinationList) {
		this.destinationList = destinationList;
	}
	public Double getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	
    
    
}
