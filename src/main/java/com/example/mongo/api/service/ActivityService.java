package com.example.mongo.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.mongo.api.dto.ActivityDto;
import com.example.mongo.api.model.Activity;
import com.example.mongo.api.repository.ActivityRepository;

@Component
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	public List<ActivityDto> getAllActivities() {
		List<Activity> list = activityRepository.findAll();
		List<ActivityDto> dtoList = new ArrayList<ActivityDto>();
		for(Activity activity:list) {
			dtoList.add(mapResponse(activity));
		}
		return dtoList;
	}
	
	public List<ActivityDto> getActivityByCategory(@PathVariable String category) {
		List<Activity> list = activityRepository.findByCategory(category);
		List<ActivityDto> dtoList = new ArrayList<ActivityDto>();
		for(Activity activity:list) {
			dtoList.add(mapResponse(activity));
		}
		return dtoList;
	}
	
	private ActivityDto mapResponse(Activity activity){
		ActivityDto dto = new ActivityDto();
		dto.setCategory(activity.getCategory());
		dto.setDesc(activity.getDesc());
		dto.setLocation(activity.getLocation());
		dto.setName(activity.getName());
		dto.setPrice(activity.getPrice());
		return dto;
	}

}
