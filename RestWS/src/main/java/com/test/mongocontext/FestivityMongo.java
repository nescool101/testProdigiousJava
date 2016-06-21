package com.test.mongocontext;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.test.model.Festivities;

public interface FestivityMongo extends CrudRepository<Festivities, Long> {
	@Query("{'name' : ?0}")
	public Iterable<Festivities> searchByName(String name);

}
