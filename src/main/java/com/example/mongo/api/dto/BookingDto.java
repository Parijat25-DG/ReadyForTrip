package com.example.mongo.api.dto;

import java.util.List;

public class BookingDto {
	
	private Long travellerId;
	private List<DestinationDto> destinationList;
	private int travellers;
	
	public Long getTravellerId() {
		return travellerId;
	}
	public void setTravellerId(Long travellerId) {
		this.travellerId = travellerId;
	}
	public List<DestinationDto> getDestinationList() {
		return destinationList;
	}
	public void setDestinationList(List<DestinationDto> destinationList) {
		this.destinationList = destinationList;
	}
	public int getTravellers() {
		return travellers;
	}
	public void setTravellers(int travellers) {
		this.travellers = travellers;
	}
	
	

}
