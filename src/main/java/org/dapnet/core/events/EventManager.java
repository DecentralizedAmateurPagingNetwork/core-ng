package org.dapnet.core.events;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * A simple event manager implementation.
 * 
 * @author Philipp Thiel
 */
public class EventManager {

	private final ConcurrentMap<Class<?>, EventListenerSet<?>> listeners = new ConcurrentHashMap<>();
	private final String name;
	private final EventDispatcher dispatcher;

	/**
	 * Constructs a new event manager.
	 * 
	 * @param name
	 *            Event manager name.
	 * @param dispatcher
	 *            Dispatcher to use.
	 */
	protected EventManager(String name, EventDispatcher dispatcher) {
		this.name = Objects.requireNonNull(name);
		this.dispatcher = Objects.requireNonNull(dispatcher);
	}

	/**
	 * Constructs an event manager with the given name.
	 * 
	 * @param name
	 *            Name
	 */
	public EventManager(String name) {
		this(name, new EventDispatcher());
	}

	/**
	 * Constructs an event manager with a default name.
	 */
	public EventManager() {
		this("default");
	}

	/**
	 * Gets the name.
	 * 
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds an event listener for the given event type.
	 * 
	 * @param event
	 *            Event type
	 * @param listener
	 *            Event listener to add.
	 * @return {@code true} if the event listener has been added.
	 */
	public <T extends Event> boolean addListener(Class<T> event, EventListener<T> listener) {
		@SuppressWarnings("unchecked")
		EventListenerSet<T> ell = (EventListenerSet<T>) listeners.get(event);
		if (ell == null) {
			ell = new EventListenerSet<>();
			listeners.put(event, ell);
		}

		return ell.add(listener);
	}

	/**
	 * Removes an event listener for the given event type.
	 * 
	 * @param event
	 *            Event type
	 * @param listener
	 *            Event listener to remove.
	 * @return {@code true} if the event listener has been removed.
	 */
	public <T extends Event> boolean removeListener(Class<T> event, EventListener<T> listener) {
		@SuppressWarnings("unchecked")
		EventListenerSet<T> ell = (EventListenerSet<T>) listeners.get(event);
		if (ell != null) {
			return ell.remove(listener);
		} else {
			return false;
		}
	}

	/**
	 * Fires an event.
	 * 
	 * @param sender
	 *            Object that caused the event.
	 * @param event
	 *            Event object
	 */
	public <T extends Event> void fireEvent(Object sender, T event) {
		@SuppressWarnings("unchecked")
		EventListenerSet<T> ell = (EventListenerSet<T>) listeners.get(event.getClass());
		if (ell != null) {
			dispatcher.dispatchEvent(ell, sender, event);
		}
	}

}
