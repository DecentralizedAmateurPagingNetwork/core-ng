package org.dapnet.core.events;

/**
 * Event listener interface.
 * 
 * @author Philipp Thiel
 *
 * @param <T>
 *            Event arguments.
 */
@FunctionalInterface
public interface EventListener<T extends EventArgs> {

	/**
	 * Callback for handling the event.
	 * 
	 * @param sender
	 *            Object which raised the event.
	 * @param eventArgs
	 *            Event arguments.
	 */
	void onEvent(Object sender, T eventArgs);

}
