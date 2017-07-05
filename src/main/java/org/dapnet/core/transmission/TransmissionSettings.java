package org.dapnet.core.transmission;

/**
 * This class contains the settings related to connected transmitters and the
 * transmitter server.
 * 
 * @author Philipp Thiel
 */
public final class TransmissionSettings {

	private int numSyncLoops = 5;
	private int serverPort = 43434;

	/**
	 * Gets the number of synchronization loops a transmitter must perform during
	 * connect.
	 * 
	 * @return Number of sync loops
	 */
	public int getNumSyncLoops() {
		return numSyncLoops;
	}

	/**
	 * Sets the number of synchronization loops a transmitter must perform during
	 * connect.
	 * 
	 * @param numSyncLoops
	 *            Number of sync loops
	 */
	public void setNumSyncLoops(int numSyncLoops) {
		this.numSyncLoops = numSyncLoops;
	}

	/**
	 * Gets the transmitter server port number.
	 * 
	 * @return Port number
	 */
	public int getServerPort() {
		return serverPort;
	}

	/**
	 * Sets the transmitter server port number.
	 * 
	 * @param serverPort
	 *            Port number
	 */
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

}
