package com.test.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.test.mongocontext.FestivityMongo;
import com.test.utilities.Utilities;

/**
 * Class that implements a POJO with the data of the festivities
 * 
 * @author NESTOR version 1.0 20/06/2016
 */
@Document(collection = "festivities")
public class Festivities {
	@Id
	private Long id;

	private String iniDate;

	private String finDate;

	private String location;

	private String desc;

	public static List<Festivities> festivities;


	static {
		FestivityMongo festivitieContext = Utilities.getBeanContext();
		festivities = (List<Festivities>) festivitieContext.findAll();
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
	@PersistenceConstructor
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
	
	@Override
	public String toString() {
		return "{id:" + id + ", name:" + desc + ", place:" + location + ", start:" + iniDate + ", end:" + finDate + "}";
	}
}
