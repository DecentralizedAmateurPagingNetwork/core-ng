package org.dapnet.core;

/**
 * This exception is thrown when the startup of DAPNET core failed.
 * 
 * @author Philipp Thiel
 */
public class CoreStartupException extends Exception {

	private static final long serialVersionUID = 4305316356193281119L;

	public CoreStartupException() {
	}

	public CoreStartupException(String message) {
		super(message);
	}

	public CoreStartupException(Throwable cause) {
		super(cause);
	}

	public CoreStartupException(String message, Throwable cause) {
		super(message, cause);
	}

	public CoreStartupException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
