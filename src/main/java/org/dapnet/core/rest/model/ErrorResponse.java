package org.dapnet.core.rest.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for putting out error messages.
 * 
 * @author Philipp Thiel
 */
public final class ErrorResponse {

	@JsonProperty("error")
	private final String message;

	/**
	 * Constructs an object with the given message.
	 * 
	 * @param message
	 */
	public ErrorResponse(String message) {
		this.message = Objects.requireNonNull(message);
	}

	public String getMessage() {
		return message;
	}

}
