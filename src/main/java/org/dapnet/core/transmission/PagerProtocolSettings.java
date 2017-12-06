package org.dapnet.core.transmission;

/**
 * This class contains the pager protocol settings.
 * 
 * @author Philipp Thiel
 */
public final class PagerProtocolSettings {

	private PagerBaudRate baudRate = PagerBaudRate.BAUD_1200;
	private String activationCode = "0 7 50,0 7 34,0 7 53,0 7 51,0 7 51,0 7 52,0 7 52,0 7 52";

	/**
	 * Gets the baud rate to use.
	 * 
	 * @return Baud rate
	 */
	public PagerBaudRate getBaudRate() {
		return baudRate;
	}

	/**
	 * Gets the activation code.
	 * 
	 * @return Activation code
	 */
	public String getActivationCode() {
		return activationCode;
	}

}
