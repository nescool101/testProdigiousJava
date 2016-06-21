package com.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;
import org.json.XML;

import com.test.model.Festivities;

@Path("/festivitie")
@Consumes({ "appplication/xml", "application/json" })
/**
 * Class with Service and methods to consume restful
 * 
 * @author NESTOR version 1.0 20/06/2016
 */
public class ServiceFestivity {

	@GET
	@Produces("application/json")
	public Response getFestivities() {
		JSONObject jsonObject = new JSONObject();
		Festivities fest = new Festivities();
		List<Festivities> festivity = new ArrayList<Festivities>();
		festivity.clear();
		festivity.add(new Festivities(new Long(1), "11-08-21", "11-08-22", "Bogota", "Cumpleaños Nestor"));
		fest.setFestivities(festivity);

		List<Festivities> festivity2 = fest.getFestivities();

		if (!festivity2.isEmpty()) {
			for (int i = 0; i < festivity2.size(); i++) {
				jsonObject.put("name", festivity2.get(i).getdesc());
				jsonObject.put("place", festivity2.get(i).getLocation());
				jsonObject.put("start", festivity2.get(i).getiniDate());
				jsonObject.put("end", festivity2.get(i).getfinDate());
			}
		}
		return Response.ok(jsonObject.toString(), MediaType.APPLICATION_JSON).build();

	}

	@Path("/id/{id}")
	@GET
	@Produces("application/json")
	public Response getUserById(@PathParam("id") int id, @Context UriInfo info) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", id);
		String format = info.getQueryParameters().getFirst("format");
		if (format.equalsIgnoreCase("json")) {
			return Response.ok(jsonObject.toString(), MediaType.APPLICATION_JSON).build();
		} else {
			String xml = "<festivity>" + XML.toString(jsonObject) + "</festivity>";
			return Response.ok(xml, MediaType.APPLICATION_XML).build();
		}

		// return Response.status(200).entity(jsonObject.toString()).build();
	}

	@Path("/create/")
	@POST
	@Produces("application/json")
	@Consumes({ "application/json", "application/xml" })
	public Response createUser(String name, @Context HttpHeaders headers) {

		if (headers.getMediaType().toString().equalsIgnoreCase("application/xml")) {
			String xml = "<festivity>" + XML.toString(name) + "</festivity>";
			return Response.ok(xml, MediaType.APPLICATION_XML).build();
		}

		JSONObject jsonObject = new JSONObject(name);
		return Response.status(200).entity(jsonObject.toString()).build();
	}

}
