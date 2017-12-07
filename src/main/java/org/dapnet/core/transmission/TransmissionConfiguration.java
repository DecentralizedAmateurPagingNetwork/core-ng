package org.dapnet.core.transmission;

import org.dapnet.core.util.AbstractConfiguration;
import org.dapnet.core.util.PropertyReader;
import org.dapnet.core.util.PropertyWriter;

/**
 * This class contains the settings related to connected transmitters and the
 * transmitter server.
 * 
 * @author Philipp Thiel
 */
public final class TransmissionConfiguration extends AbstractConfiguration {

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

	@Override
	public void saveConfiguration(PropertyWriter writer) {
		writer.setProperty("transmission.num_sync_loops", numSyncLoops);
		writer.setProperty("transmission.server_port", serverPort);
	}

}
