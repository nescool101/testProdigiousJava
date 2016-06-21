package com.test.model;

import java.util.List;

/**
 * Class that implements a POJO with the data of the service of Car's Sale
 * 
 * @author NESTOR version 1.0 20/06/2016
 */
public class Festivities {

	private Long id;

	private String iniDate;

	private String finDate;

	private String location;

	private String desc;

	private List<Festivities> festivities;
	
	public Festivities(){
		
	}


	/**
	 * Constructor of class Initialized all the parameters of the Object
	 * Festivities
	 * 
	 * @param id
	 * @param iniDate
	 * @param finDate
	 * @param location
	 * @param desc
	 */
	public Festivities(Long id, String iniDate, String finDate, String location, String desc) {
		this.id = id;
		this.iniDate = iniDate;
		this.finDate = finDate;
		this.location = location;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getiniDate() {
		return iniDate;
	}

	public void setiniDate(String iniDate) {
		this.iniDate = iniDate;
	}

	public String getfinDate() {
		return finDate;
	}

	public void setfinDate(String finDate) {
		this.finDate = finDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getdesc() {
		return desc;
	}

	public void setdesc(String desc) {
		this.desc = desc;
	}

	public List<Festivities> getFestivities() {
		return festivities;
	}

	public void setFestivities(List<Festivities> festivities) {
		this.festivities = festivities;
	}	

}
