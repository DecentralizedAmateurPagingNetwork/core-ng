package org.dapnet.core.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dapnet.core.rest.model.CoreStatusResponse;

/**
 * This class implements the core resource endpoint.
 * 
 * @author Philipp Thiel
 */
@Singleton
@Path("core")
public class CoreResource extends AbstractResource {

	@GET
	@Path("status")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStatus() throws Exception {
		return objectMapper.writeValueAsString(new CoreStatusResponse());
	}

}
