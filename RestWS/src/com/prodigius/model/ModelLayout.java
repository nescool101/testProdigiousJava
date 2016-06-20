package com.prodigius.model;

/**
 * Class that implements POJO, with the data of festivities
 * 
 * @author NESTOR-PC version 1.0 20/06/2016
 */

public class ModelLayout {

	private Long id;
	private String iniDate;
	private String finDate;
	private String name;
	private String place;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIniDate() {
		return iniDate;
	}

	public void setIniDate(String iniDate) {
		this.iniDate = iniDate;
	}

	public String getFinDate() {
		return finDate;
	}

	public void setFinDate(String finDate) {
		this.finDate = finDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
