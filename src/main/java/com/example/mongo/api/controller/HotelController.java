package com.example.mongo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.api.dto.HotelDto;
import com.example.mongo.api.model.Hotel;
import com.example.mongo.api.service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping("/findAllHotels")
	public List<Hotel> getHotels() {
		return hotelService.getHotels();
	}
	
	@GetMapping("/findHotelsByCategory/{category}")
	public List<HotelDto> getHotelsByCategory(@PathVariable String category) {
		return hotelService.getHotelsByCategory(category);
	}
	
	@PostMapping("/findHotelsByFacilties")
	public List<HotelDto> getHotelsByFacilities(@RequestBody List<String> facilities) {
		return hotelService.getHotelsByFacilities(facilities);
	}

}
