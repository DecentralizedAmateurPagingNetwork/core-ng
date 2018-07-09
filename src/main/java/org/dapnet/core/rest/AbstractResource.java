package org.dapnet.core.rest;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Base class for REST service resources.
 * 
 * @author Philipp Thiel
 */
public abstract class AbstractResource {

	@Inject
	protected ObjectMapper objectMapper;
	@Context
	protected UriInfo uriInfo;
	@Context
	protected HttpHeaders httpHeaders;

}
