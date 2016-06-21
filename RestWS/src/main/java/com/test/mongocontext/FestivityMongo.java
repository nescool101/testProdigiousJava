package com.test.mongocontext;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.test.model.Festivities;

/**
 * interface that take the data incoming by the mongo database
 * 
 * @author NESTOR version 1.0 20/06/2016
 */


public interface FestivityMongo extends CrudRepository<Festivities, Long> {
	@Query("{'name' : ?0}")
	public Iterable<Festivities> searchByName(String name);

}
