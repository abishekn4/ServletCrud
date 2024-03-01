package com.xworkz.servletcrud.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "sports")
@NamedQuery(name = "findByName" , query = "Select dto from SportsDto dto where dto.sportName =:nm")
@NamedQuery(name="updateTypeByName", query ="Update SportsDto dto set dto.sportType = :ty where dto.sportName = :nm")
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSportName() {
		return sportName;
	}


	public void setSportName(String sportName) {
		this.sportName = sportName;
	}


	public int getNoOfPlayers() {
		return noOfPlayers;
	}


	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}


	public String getSportType() {
		return sportType;
	}


	public void setSportType(String sportType) {
		this.sportType = sportType;
	}


	public String getEquipment() {
		return equipment;
	}


	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	
	
	
	
	


}
