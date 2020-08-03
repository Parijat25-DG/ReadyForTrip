package com.example.mongo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.api.dto.ActivityDto;
import com.example.mongo.api.service.ActivityService;

@RestController
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/findAllActivities")
	public List<ActivityDto> getAllActivities() {
		return activityService.getAllActivities();
	}
	
	@GetMapping("/findActivityByCategory/{category}")
	public List<ActivityDto> getByContinent(@PathVariable String category) {
		return activityService.getActivityByCategory(category);
	}

}
