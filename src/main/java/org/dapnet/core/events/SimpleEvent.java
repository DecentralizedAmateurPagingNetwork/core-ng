package org.dapnet.core.events;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A simple event implementation. It is based on a thread-safe set and uses the
 * same thread as the calling thread to notify the registered event listeners.
 * The order of invocation is arbitrary.
 * 
 * @author Philipp Thiel
 *
 * @param <T>
 *            Type of the event argument.
 */
public final class SimpleEvent<T extends EventArgs> implements Event<T> {
	private final Set<EventListener<T>> listeners = new HashSet<>();

	@Override
	public boolean addListener(EventListener<T> listener) {
		Objects.requireNonNull(listener);

		synchronized (listeners) {
			return listeners.add(listener);
		}
	}

	@Override
	public boolean removeListener(EventListener<T> listener) {
		Objects.requireNonNull(listener);

		synchronized (listeners) {
			return listeners.remove(listener);
		}
	}

	@Override
	public void raiseEvent(Object sender, T eventArgs) {
		Objects.requireNonNull(sender);

		synchronized (listeners) {
			listeners.forEach(l -> l.onEvent(sender, eventArgs));
		}
	}
}
