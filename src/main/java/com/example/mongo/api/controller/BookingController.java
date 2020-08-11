package com.example.mongo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.api.dto.BookingDto;
import com.example.mongo.api.dto.SavedBookingDto;
import com.example.mongo.api.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/book/trip")
	public SavedBookingDto bookTrip(@RequestBody BookingDto booking) {
		return bookingService.saveBooking(booking);
	}
	
}
