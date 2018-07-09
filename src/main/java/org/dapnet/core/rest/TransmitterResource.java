package org.dapnet.core.rest;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.JsonNode;

@Singleton
@Path("transmitter")
public class TransmitterResource extends AbstractResource {

	@POST
	@Path("bootstrap")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String bootstrap(String request) throws Exception {
		JsonNode json = objectMapper.readTree(request);
		return null;
	}

	public static class TransmitterBootstrapRequest {
		private String callsign;
		private String authKey;

	}

}
