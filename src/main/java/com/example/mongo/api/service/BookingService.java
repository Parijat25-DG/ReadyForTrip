package com.example.mongo.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mongo.api.dto.BookingDto;
import com.example.mongo.api.dto.DestinationDto;
import com.example.mongo.api.dto.SavedBookingDto;
import com.example.mongo.api.model.Activity;
import com.example.mongo.api.model.Booking;
import com.example.mongo.api.model.Hotel;
import com.example.mongo.api.model.Restaurant;
import com.example.mongo.api.model.Specialities;
import com.example.mongo.api.repository.ActivityRepository;
import com.example.mongo.api.repository.BookingRepository;
import com.example.mongo.api.repository.HotelRepository;
import com.example.mongo.api.repository.RestaurantRepository;
import com.example.mongo.api.repository.SpecialitiesRepository;

@Component
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private SpecialitiesRepository specialitiesRepository;
	
	public SavedBookingDto saveBooking(BookingDto bookingDto) {
		if(bookingDto.getDestinationList() != null && !bookingDto.getDestinationList().isEmpty()) {
			Double destinationCost = 0.0;
			for(DestinationDto destination : bookingDto.getDestinationList()) {
				Hotel hotel = hotelRepository.findById(destination.getHotelId()).get();
				String[] hotelPrices = hotel.getPrice().split(" ");
				Double hotelPrice = Double.valueOf(hotelPrices[0]);
				Double hotelPricePerHead = hotelPrice/2;
				Double hotelCost = hotelPricePerHead*destination.getDays()*bookingDto.getTravellers();
				
				Double restroCost = 0.0;
				for(int i=0; i<destination.getRestaurantIds().length; i++) {
					Restaurant restaurant = restaurantRepository.findById(destination.getRestaurantIds()[i]).get();
					String[] restroPrices = restaurant.getPrice().split(" ");
					Double restroPrice = Double.valueOf(restroPrices[0]);
					Double restroPricePerHead = restroPrice/2;
					restroCost = restroCost + restroPricePerHead*bookingDto.getTravellers();
				}
				
				Double activityCost = 0.0;
				for(int j=0; j<destination.getActivityIds().length; j++) {
					Activity activity = activityRepository.findById(destination.getActivityIds()[j]).get();
					String[] activityPrices = activity.getPrice().split(" ");
					Double activityPricePerHead = Double.valueOf(activityPrices[0]);
					activityCost = activityCost + activityPricePerHead*bookingDto.getTravellers();
				}
				
				Specialities speciality = specialitiesRepository.findById(destination.getSpecialityId()).get();
				String[] specialityPrice = speciality.getPrice().split(" ");
				Double specialityPricePerHead = Double.valueOf(specialityPrice[0]);
				Double specialityCost = specialityPricePerHead*bookingDto.getTravellers();
				
				destinationCost = destinationCost + hotelCost + restroCost + activityCost + specialityCost;
			}
			
			Booking booking = new Booking();
			booking.setTravellerId(String.valueOf(bookingDto.getTravellerId()));
			booking.setEstimatedCost(destinationCost);
			List<Object> destinations = new ArrayList<>();
			for(DestinationDto destination : bookingDto.getDestinationList()) {
				destinations.add(destination);
			}
			booking.setDestinationList(destinations );
			Booking savedBooking = bookingRepository.save(booking);
			
			SavedBookingDto savedBookingDto = new SavedBookingDto();
			savedBookingDto.setBookingId(savedBooking.get_id());
			savedBookingDto.setEstimatedCost(destinationCost);
			
			return savedBookingDto;
		}
		return null;
	}

}
