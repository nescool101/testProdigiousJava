package com.test.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
import org.w3c.dom.Document;

import com.test.model.Festivities;
import com.test.mongocontext.FestivityMongo;
import com.test.utilities.Utilities;

@Path("/festivitie")
@Consumes({ "appplication/xml", "application/json" })
/**
 * Class with Service and methods to consume restful
 * 
 * @author NESTOR version 1.0 20/06/2016
 */
public class ServiceFestivity {

	private static final AtomicLong counter = new AtomicLong();

	@GET
	@Produces("application/json")
	public Response getFestivities() {
		JSONObject jsonObject = new JSONObject();
		FestivityMongo festivitieContext = Utilities.getBeanContext();
		List<Festivities> festivity2 = (List<Festivities>) festivitieContext.findAll();
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
		FestivityMongo festivitieContext = Utilities.getBeanContext();
		String format = info.getQueryParameters().getFirst("format");
		Festivities festivity = festivitieContext.findOne(new Long(id));
		if (format.equalsIgnoreCase("json")) {
			return Response.ok(festivity.toString(), MediaType.APPLICATION_JSON).build();
		} else {
			String xml = "<festivity>" + XML.toString(festivity.toString()) + "</festivity>";
			return Response.ok(xml, MediaType.APPLICATION_XML).build();
		}
	}

	@SuppressWarnings("null")
	@Path("/create/")
	@POST
	@Produces("application/json")
	@Consumes({ "application/json", "application/xml" })
	public Response createUser(String festivitie, @Context HttpHeaders headers) {

		Festivities festivity = null;
		FestivityMongo festivitieContext = Utilities.getBeanContext();
		counter.set(Festivities.festivities.size());
		festivity.setId(counter.incrementAndGet());

		if (headers.getMediaType().toString().equalsIgnoreCase("application/xml")) {
			// String xml = "<festivity>" + XML.toString(festivitie) +
			// "</festivity>";
			try {
				Document doc = Utilities.convertStringToXml(festivitie);

				festivity.setdesc(doc.getElementsByTagName("name").item(0).getTextContent());
				festivity.setfinDate(doc.getElementsByTagName("end").item(0).getTextContent());
				festivity.setiniDate(doc.getElementsByTagName("start").item(0).getTextContent());
				festivity.setLocation(doc.getElementsByTagName("place").item(0).getTextContent());

			} catch (Exception e) {
				e.printStackTrace();
			}
			festivitieContext.save(festivity);
			return Response.ok(festivitie, MediaType.APPLICATION_XML).build();
		} else {
			JSONObject jsonObject = new JSONObject(festivitie);
			festivity.setdesc((String) jsonObject.get("name"));
			festivity.setfinDate((String) jsonObject.get("end"));
			festivity.setiniDate((String) jsonObject.get("start"));
			festivity.setLocation((String) jsonObject.get("place"));
			festivitieContext.save(festivity);
			return Response.status(200).entity(jsonObject.toString()).build();
		}

	}

}
