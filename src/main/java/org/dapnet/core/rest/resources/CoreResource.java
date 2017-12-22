package org.dapnet.core.rest.resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("core")
public class CoreResource {

	@GET
	@Path("version")
	@Produces(MediaType.TEXT_PLAIN)
	public String getVersion() {
		return "Version: 0.0.1";
	}

}
