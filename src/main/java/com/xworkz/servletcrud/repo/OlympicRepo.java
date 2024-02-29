package com.xworkz.servletcrud.repo;

import com.xworkz.servletcrud.dto.SportsDto;

public interface OlympicRepo {
	
	public boolean addSport(SportsDto dto);

	public SportsDto findById(int id);

	public SportsDto findByName(String name);

}
