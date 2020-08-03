package com.example.mongo.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.mongo.api.dto.HotelDto;
import com.example.mongo.api.model.Hotel;
import com.example.mongo.api.repository.HotelRepository;

@Component
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> getHotels() {
		return hotelRepository.findAll();
	}
	
	public List<HotelDto> getHotelsByCategory(@PathVariable String category) {
		List<Hotel> list = hotelRepository.findByCategory(category);
		List<HotelDto> dtoList = new ArrayList<HotelDto>();
		for(Hotel hotel:list) {
			dtoList.add(mapResponse(hotel));
		}
		return dtoList;
	}
	
	public List<HotelDto> getHotelsByFacilities(@PathVariable List<String> facilities) {
		List<Hotel> allHotels = hotelRepository.findAll();
		List<HotelDto> dtoList = new ArrayList<HotelDto>();
		for(Hotel hotel: allHotels) {
			if(hotel.getFacilities().containsAll(facilities)) {
				dtoList.add(mapResponse(hotel));
			}
		}
		return dtoList;
	}
	
	private HotelDto mapResponse(Hotel hotel){
		HotelDto dto = new HotelDto();
		dto.setCategory(hotel.getCategory());
		dto.setDetails(hotel.getDetails());
		dto.setFacilities(hotel.getFacilities());
		dto.setLocality(hotel.getLocality()); 
		dto.setLocation(hotel.getLocation());
		dto.setName(hotel.getName());
		return dto;
	}

}
