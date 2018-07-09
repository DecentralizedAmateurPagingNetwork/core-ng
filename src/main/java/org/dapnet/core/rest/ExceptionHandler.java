package org.dapnet.core.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {

	private static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Response toResponse(Throwable exception) {
		// TODO Implementation
		LOGGER.error("Request failed.", exception);
		return Response.serverError().type(MediaType.TEXT_PLAIN).build();
	}

}
