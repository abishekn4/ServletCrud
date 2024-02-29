package com.xworkz.servletcrud.service;

import com.xworkz.servletcrud.dto.SportsDto;
import com.xworkz.servletcrud.repo.OlympicRepo;
import com.xworkz.servletcrud.repo.OlympicRepoImpl;

public class OlympicsServiceImpl implements OlympicsService{
	
	private OlympicRepo repo = new OlympicRepoImpl();

	@Override
	public boolean validateAndAdd(SportsDto dto) {
		if(dto!=null) {
			if(dto.getSportName()!=null && !dto.getSportName().isEmpty()) {
				if(dto.getId()>0) {
					if(dto.getNoOfPlayers()> 0) {
						System.out.println("Sport is Valid");
						return repo.addSport(dto);	
					}
				}
			}
		}
		System.out.println("Sport Not valid");
		return false;
	}

	@Override
	public SportsDto findById(int id) {
		if(id>0) {
			return repo.findById(id);
		}
		return null;
	}

	@Override
	public SportsDto findByName(String name) {
		if(name!=null) {
			return repo.findByName(name);
		}
		return null;
	}

	
}
