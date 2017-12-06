package org.dapnet.core.transmission;

import org.dapnet.core.AbstractSettings;
import org.dapnet.core.SettingsManager;

/**
 * This class contains the settings related to connected transmitters and the
 * transmitter server.
 * 
 * @author Philipp Thiel
 */
public final class TransmissionSettings extends AbstractSettings {

	public TransmissionSettings(SettingsManager file) {
		super(file);
	}

	/**
	 * Gets the number of synchronization loops a transmitter must perform during
	 * connect.
	 * 
	 * @return Number of sync loops
	 */
	public int getNumSyncLoops() {
		return getInteger("transmission.num_sync_loops", 5);
	}

	/**
	 * Gets the transmitter server port number.
	 * 
	 * @return Port number
	 */
	public int getServerPort() {
		return getInteger("transmission.server_port", 43434);
	}

}
