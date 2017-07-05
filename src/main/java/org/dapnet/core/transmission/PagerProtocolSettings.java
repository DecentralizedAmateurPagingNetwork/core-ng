package org.dapnet.core.transmission;

/**
 * This class contains the pager protocol settings.
 * 
 * @author Philipp Thiel
 */
public final class PagerProtocolSettings {

	public static final int BAUD_512 = 0;
	public static final int BAUD_1200 = 1;
	public static final int BAUD_2400 = 2;

	private int baudRate = BAUD_1200;
	private String activationCode = "0 7 50,0 7 34,0 7 53,0 7 51,0 7 51,0 7 52,0 7 52,0 7 52";

	/**
	 * Gets the baud rate to use.
	 * 
	 * @return Baud rate
	 */
	public int getBaudRate() {
		return baudRate;
	}

	/**
	 * Sets the baud rate to use.
	 * 
	 * @param baudRate
	 *            Baud rate
	 */
	public void setBaudRate(int baudRate) {
		this.baudRate = baudRate;
	}

	/**
	 * Gets the activation code.
	 * @return Activation code
	 */
	public String getActivationCode() {
		return activationCode;
	}

	/**
	 * Sets the activation code.
	 * @param activationCode Activation code
	 */
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}


}
