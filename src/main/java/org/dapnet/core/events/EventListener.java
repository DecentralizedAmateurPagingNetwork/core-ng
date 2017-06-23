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
public interface EventListener<T extends Event> {

	/**
	 * Callback for handling the event.
	 * 
	 * @param sender
	 *            Object that caused the event.
	 * @param event
	 *            The event object.
	 */
	void onEvent(Object sender, T event);

}
