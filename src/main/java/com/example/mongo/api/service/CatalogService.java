package com.example.mongo.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.mongo.api.dto.CatalogDto;
import com.example.mongo.api.model.Catalog;
import com.example.mongo.api.repository.CatalogRepository;

@Component
public class CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	
	public List<CatalogDto> getLocationCatalog() {
		List<Catalog> list = catalogRepository.findAll();
		List<CatalogDto> dtoList = new ArrayList<CatalogDto>();
		for(Catalog catalog:list) {
			dtoList.add(mapResponse(catalog));
		}
		return dtoList;
	}
	
	public List<CatalogDto> getCatalogByContinet(@PathVariable String continent) {
		List<Catalog> list = catalogRepository.findByContinent(continent);
		List<CatalogDto> dtoList = new ArrayList<CatalogDto>();
		for(Catalog catalog:list) {
			dtoList.add(mapResponse(catalog));
		}
		return dtoList;
	}
	
	public List<CatalogDto> getCatalogByCountry(@PathVariable String country) {
		List<Catalog> list = catalogRepository.findByCountry(country);
		List<CatalogDto> dtoList = new ArrayList<CatalogDto>();
		for(Catalog catalog:list) {
			dtoList.add(mapResponse(catalog));
		}
		return dtoList;
	}
	
	private CatalogDto mapResponse(Catalog catalog){
		CatalogDto dto = new CatalogDto();
		dto.setContinent(catalog.getContinent());
		dto.setCountry(catalog.getCountry());
		return dto;
	}

}
