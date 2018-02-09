package org.dapnet.core.transmission;

import org.dapnet.core.config.Configuration;
import org.dapnet.core.config.PropertyReader;

/**
 * This class contains the settings related to connected transmitters and the
 * transmitter server.
 * 
 * @author Philipp Thiel
 */
public final class TransmissionConfiguration extends Configuration {

	private int numSyncLoops;
	private int serverPort;

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
	 * Gets the transmitter server port number.
	 * 
	 * @return Port number
	 */
	public int getServerPort() {
		return serverPort;
	}

	@Override
	public void loadConfiguration(PropertyReader reader) {
		numSyncLoops = reader.getInteger("transmission.num_sync_loops", 5);
		serverPort = reader.getInteger("transmission.server_port", 43434);
	}

}
