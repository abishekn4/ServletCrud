package com.xworkz.servletcrud;

import com.xworkz.servletcrud.dto.SportsDto;
import com.xworkz.servletcrud.service.OlympicsService;
import com.xworkz.servletcrud.service.OlympicsServiceImpl;

public class OlympicsTester {

	public static void main(String[] args) {
		
		
		
		
		OlympicsService service =	new OlympicsServiceImpl();
		
	//SportsDto dto = new SportsDto(1, "Badminton", 2, "Indoor", "Racquet");
		
	  // boolean result = service.validateAndAdd(dto);
		
		//System.out.println(result);
		
		
		//SportsDto dto = service.findByName("Chess");
		
		//System.out.println(dto);
		
	boolean result=service.updateTypeByName("Badminton","Outdoor");
	System.out.println(result);
	}

}
