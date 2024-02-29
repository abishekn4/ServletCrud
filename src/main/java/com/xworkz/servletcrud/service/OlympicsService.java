package com.xworkz.servletcrud.service;

import com.xworkz.servletcrud.dto.SportsDto;

public interface OlympicsService {
	
	public boolean validateAndAdd(SportsDto dto);
	
	public SportsDto findById(int id);
	
	public SportsDto findByName(String name);
	

}
