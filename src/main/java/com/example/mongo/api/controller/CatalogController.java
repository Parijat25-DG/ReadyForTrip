package com.example.mongo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.api.dto.CatalogDto;
import com.example.mongo.api.service.CatalogService;

@RestController
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	@GetMapping("/findAllLocationCatalog")
	public List<CatalogDto> getHotels() {
		return catalogService.getLocationCatalog();
	}
	
	@GetMapping("/findByContinent/{continent}")
	public List<CatalogDto> getByContinent(@PathVariable String continent) {
		return catalogService.getCatalogByContinet(continent);
	}
	
	@GetMapping("/findByContinent/{country}")
	public List<CatalogDto> getByCountry(@PathVariable String country) {
		return catalogService.getCatalogByCountry(country);
	}

}
