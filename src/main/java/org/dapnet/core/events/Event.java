package org.dapnet.core.events;

/**
 * This interface describes an event listeners can subscribe to.
 * 
 * @author Philipp Thiel
 *
 * @param <T>
 *            Type of the event argument.
 */
public interface Event<T extends EventArgs> {

	/**
	 * Adds an event listener to this event.
	 * 
	 * @param listener
	 *            Listener to add.
	 * @return {@code true} if the listener has been added.
	 */
	boolean addListener(EventListener<T> listener);

	/**
	 * Removes an event listener from this event.
	 * 
	 * @param listener
	 *            Listener to remove.
	 * @return {@code true} if the listener has been removed.
	 */
	boolean removeListener(EventListener<T> listener);

	/**
	 * Raises an event and notifies all registered listeners. The order of
	 * invocation is implementation-specific.
	 * 
	 * @param sender
	 *            Object which caused the event. Must not be {@code null}.
	 * @param eventArgs
	 *            Event arguments.
	 */
	void raiseEvent(Object sender, T eventArgs);

}
