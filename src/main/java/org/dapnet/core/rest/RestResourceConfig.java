package org.dapnet.core.rest;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * This class manages the REST API resource configuration.
 * 
 * @author Philipp Thiel
 */
//@ApplicationPath("rest")
public class RestResourceConfig extends ResourceConfig {

	public RestResourceConfig(RestApiConfiguration config) {
		super(CoreResource.class, TransmitterResource.class, ExceptionHandler.class);

		register(new ObjectMapperBinder(config));
	}

}
