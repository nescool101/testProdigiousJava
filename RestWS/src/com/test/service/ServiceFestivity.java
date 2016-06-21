package com.test.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/festivitie")
// @Consumes({ "appplication/xml", "application/json" })
public class ServiceFestivity {

	@GET
	@Produces("application/json")
	public Response getFestivities() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("test", "todos");
		return Response.ok(jsonObject.toString(), MediaType.APPLICATION_JSON).build();
		// return Response.status(200).entity(jsonObject.toString()).build();
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Response getUser(@PathParam("id") int id) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("test", id);
		return Response.ok(jsonObject.toString(), MediaType.APPLICATION_JSON).build();
		// return Response.status(200).entity(jsonObject.toString()).build();
	}

}
