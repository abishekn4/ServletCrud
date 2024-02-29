package com.xworkz.servletcrud.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "sports")
@NamedQuery(name = "findByName" , query = "Select dto from SportsDto dto where dto.sportName =:nm")
public class SportsDto {
	
	@Id
	private int id;
	private String sportName;
	private int noOfPlayers;
	private String sportType;
	private String equipment;
	
	
	
	public SportsDto(int id, String sportName, int noOfPlayers, String sportType, String equipment) {
		super();
		this.id = id;
		this.sportName = sportName;
		this.noOfPlayers = noOfPlayers;
		this.sportType = sportType;
		this.equipment = equipment;
	}
	
	
	public SportsDto() {
		System.out.println("Default Constructor of Sports Dto ");
	}
	
	
	
	
	


}
