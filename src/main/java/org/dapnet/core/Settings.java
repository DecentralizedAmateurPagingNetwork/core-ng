package org.dapnet.core;

public final class Settings {

	private ServerSettings serverSettings;
	private TransmissionSettings transmissionSettings;

	public Settings(String filename) {
		// TODO Impl
		this.serverSettings = new ServerSettings();
		this.transmissionSettings = new TransmissionSettings();
	}

	public ServerSettings getServerSettings() {
		return serverSettings;
	}

	public TransmissionSettings getTransmissionSettings() {
		return transmissionSettings;
	}

	public final class ServerSettings {

		private ServerSettings() {
		}

		public int getPort() {
			return 43434;
		}

	}

	public final class TransmissionSettings {

		private TransmissionSettings() {
		}

	}

}
