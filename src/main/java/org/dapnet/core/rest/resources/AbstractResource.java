package org.dapnet.core.rest.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

public abstract class AbstractResource {

	@Context
	protected UriInfo uriInfo;
	@Context
	protected HttpHeaders httpHeaders;

}
