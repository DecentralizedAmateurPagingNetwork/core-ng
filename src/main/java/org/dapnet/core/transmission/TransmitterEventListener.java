package org.dapnet.core.transmission;

interface TransmitterEventListener {

	void onConnect(TransmitterClient client);

	void onDisconnect(TransmitterClient client);

	void onException(TransmitterClient client, Throwable cause);

}
