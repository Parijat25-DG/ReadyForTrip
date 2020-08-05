package com.example.mongo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.api.model.Traveller;
import com.example.mongo.api.util.ApiUtil;

@RestController
public class TravellerController {
	
	@Autowired
	private ApiUtil apiUtil;
	
	@PostMapping("/register/traveller")
	public Long registerTraveller(@RequestBody Traveller traveller) {
		return apiUtil.registerTraveller(traveller);
	}
	
	@GetMapping("/retrieve/{email}")
	public Traveller retriveTraveller(@PathVariable String email) {
		return apiUtil.retrieveByEmail(email);
	}

}
