package org.dapnet.core.rest;

import javax.ws.rs.ApplicationPath;

import org.dapnet.core.rest.resources.CoreResource;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * This class manages the REST API resource configuration.
 * 
 * @author Philipp Thiel
 */
@ApplicationPath("api")
public class RestResourceConfig extends ResourceConfig {

	public RestResourceConfig() {
		register(CoreResource.class);
	}

}
