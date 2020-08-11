package com.example.mongo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.api.dto.SpecialitiesDto;
import com.example.mongo.api.service.SpecialitiesService;

@RestController
public class SpecialitiesController {
	
	@Autowired
	private SpecialitiesService specialitiesService;
	
	@GetMapping("/findAllSpecialities")
	public List<SpecialitiesDto> getAllSpecialities() {
		return specialitiesService.getAllSpecialities();
	}
	
	@GetMapping("/findSpecialityByType/{type}")
	public List<SpecialitiesDto> getByContinent(@PathVariable String type) {
		return specialitiesService.getSpecialityByType(type);
	}

}
