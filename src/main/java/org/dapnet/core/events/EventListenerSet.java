package org.dapnet.core.events;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A simple event listener list implementation based on a synchronized set.
 * 
 * @author Philipp Thiel
 *
 * @param <T>
 *            Event type
 */
final class EventListenerSet<T extends Event> {

	private final Set<EventListener<T>> listeners = new HashSet<>();

	/**
	 * Adds an event listener.
	 * 
	 * @param listener
	 *            Event listener to add.
	 * @return {@code true} if the event listener has been added to the set.
	 */
	public boolean add(EventListener<T> listener) {
		synchronized (listeners) {
			return listeners.add(Objects.requireNonNull(listener));
		}
	}

	/**
	 * Removes an event listener.
	 * 
	 * @param listener
	 *            Event listener to remove.
	 * @return {@code true} if the event listener has been removed from the set.
	 */
	public boolean remove(EventListener<T> listener) {
		synchronized (listeners) {
			return listeners.remove(Objects.requireNonNull(listener));
		}
	}

	/**
	 * Dispatches an event to all registered event listeners.
	 * 
	 * @param sender
	 *            Object that caused the event.
	 * @param event
	 *            Actual event data.
	 */
	public void dispatchEvent(Object sender, T event) {
		synchronized (listeners) {
			listeners.forEach(l -> l.onEvent(sender, event));
		}
	}

}
