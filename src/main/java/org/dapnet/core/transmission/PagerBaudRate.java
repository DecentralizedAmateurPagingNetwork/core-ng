package org.dapnet.core.transmission;

/**
 * This enum defines the supported pager baud rates.
 * 
 * @author Philipp Thiel
 */
public enum PagerBaudRate {

	BAUD_512(0), BAUD_1200(1), BAUD_2400(2);

	private final int code;

	private PagerBaudRate(int code) {
		this.code = code;
	}

	/**
	 * Gets the internal code used to encode the pager baud rate.
	 * 
	 * @return Encoded pager baud rate
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Converts a pager baud rate code into a pger baud rate enum value.
	 * 
	 * @param code Baud rate code
	 * @return Pager baud rate enumeration if code is valid.
	 * @throws IllegalArgumentException if code is not a valid baud rate.
	 */
	public static PagerBaudRate fromCode(int code) {
		switch (code) {
		case 0:
			return BAUD_512;
		case 1:
			return BAUD_1200;
		case 2:
			return BAUD_2400;
		default:
			throw new IllegalArgumentException("Unsupported baud rate code.");
		}
	}

}
