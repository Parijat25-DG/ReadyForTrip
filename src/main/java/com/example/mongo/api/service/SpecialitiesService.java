package com.example.mongo.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.mongo.api.dto.SpecialitiesDto;
import com.example.mongo.api.model.Specialities;
import com.example.mongo.api.repository.SpecialitiesRepository;

@Component
public class SpecialitiesService {
	
	@Autowired
	private SpecialitiesRepository specialitiesRepository;
	
	public List<SpecialitiesDto> getAllSpecialities() {
		List<Specialities> list = specialitiesRepository.findAll();
		List<SpecialitiesDto> dtoList = new ArrayList<SpecialitiesDto>();
		for(Specialities speciality:list) {
			dtoList.add(mapResponse(speciality));
		}
		return dtoList;
	}
	
	public List<SpecialitiesDto> getSpecialityByType(@PathVariable String type) {
		List<Specialities> list = specialitiesRepository.findByType(type);
		List<SpecialitiesDto> dtoList = new ArrayList<SpecialitiesDto>();
		for(Specialities speciality:list) {
			dtoList.add(mapResponse(speciality));
		}
		return dtoList;
	}
	
	private SpecialitiesDto mapResponse(Specialities speciality){
		SpecialitiesDto dto = new SpecialitiesDto();
		dto.setName(speciality.getName());
		dto.setPrice(speciality.getPrice());
		dto.setDetails(speciality.getDetails());
		dto.setLocations(speciality.getLocations());
		dto.setType(speciality.getType());
		return dto;
	}

}
