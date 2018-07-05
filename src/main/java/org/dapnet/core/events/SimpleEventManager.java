package org.dapnet.core.events;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * A simple event manager implementation. Events are dispatched directly from
 * the calling thread.
 * 
 * @author Philipp Thiel
 */
public class SimpleEventManager extends EventManager {

	private final ConcurrentMap<Class<?>, EventListenerSet<?>> listeners = new ConcurrentHashMap<>();
	private boolean running = false;

	/**
	 * Constructs a new event manager instance with the given name.
	 * 
	 * @param name Event manager name
	 */
	public SimpleEventManager(String name) {
		super(name);
	}

	@Override
	public <T extends Event> boolean addListener(Class<T> event, EventListener<T> listener) {
		@SuppressWarnings("unchecked")
		EventListenerSet<T> ell = (EventListenerSet<T>) listeners.get(event);
		if (ell == null) {
			ell = new EventListenerSet<>();
			listeners.put(event, ell);
		}

		return ell.add(listener);
	}

	@Override
	public <T extends Event> boolean removeListener(Class<T> event, EventListener<T> listener) {
		@SuppressWarnings("unchecked")
		EventListenerSet<T> ell = (EventListenerSet<T>) listeners.get(event);
		if (ell != null) {
			return ell.remove(listener);
		} else {
			return false;
		}
	}

	@Override
	public <T extends Event> void fireEvent(Object sender, T event) {
		@SuppressWarnings("unchecked")
		EventListenerSet<T> ell = (EventListenerSet<T>) listeners.get(event.getClass());
		if (ell != null) {
			ell.fireEvent(sender, event);
		} else {
			forwardUnhandledEvent(sender, event);
		}
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public void start() throws Exception {
		running = true;
	}

	@Override
	public void shutdown() throws Exception {
		running = false;
	}

}
