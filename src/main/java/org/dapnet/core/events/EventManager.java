package org.dapnet.core.events;

import java.util.Objects;
import java.util.function.BiConsumer;

import org.dapnet.core.Service;

/**
 * Abstract base class used for implementing event managers.
 * 
 * @author Philipp Thiel
 */
public abstract class EventManager implements Service {

	private final String name;
	private BiConsumer<Object, Event> unhandledEventHandler;

	/**
	 * Constructs a new event manager with the given name.
	 * 
	 * @param name
	 *            Name of the new event manager instance.
	 */
	protected EventManager(String name) {
		this.name = Objects.requireNonNull(name);
	}

	/**
	 * Gets the handler to which unhandled events will be forwarded to.
	 * 
	 * @return Unhandled event handler or {@code null} if none is set.
	 */
	public BiConsumer<Object, Event> getUnhandledEventHandler() {
		return unhandledEventHandler;
	}

	/**
	 * Sets the handler to which unhandled events will be forwarded to. Set to
	 * {@code null} to discard such events.
	 * 
	 * @param handler
	 *            Unhandled event handler to use.
	 */
	public void setUnhandledEventHandler(BiConsumer<Object, Event> handler) {
		this.unhandledEventHandler = handler;
	}

	/**
	 * This method forwards an unhandled event to the handler if a handler has been
	 * registered.
	 * 
	 * @param sender
	 *            Event sender
	 * @param event
	 *            Event arguments
	 */
	protected void forwardUnhandledEvent(Object sender, Event event) {
		BiConsumer<Object, Event> handler = unhandledEventHandler;
		if (handler != null) {
			handler.accept(sender, event);
		}
	}

	/**
	 * Returns the name of this event manager instance.
	 * 
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds an event listener.
	 * 
	 * @param event
	 *            Event type
	 * @param listener
	 *            Event listener to add.
	 * @return {@code true} if the event listener has been added.
	 */
	public abstract <T extends Event> boolean addListener(Class<T> event, EventListener<T> listener);

	/**
	 * Removes an event listener.
	 * 
	 * @param event
	 *            Event type
	 * @param listener
	 *            Event listener to remove.
	 * @return {@code true} if the event listener has been removed.
	 */
	public abstract <T extends Event> boolean removeListener(Class<T> event, EventListener<T> listener);

	/**
	 * Fires an event by notifying all affected event listeners. If no listener is
	 * registered, the event will be forwarded to the unhandled event handler.
	 * 
	 * @param sender
	 *            Sender of the event
	 * @param event
	 *            Event data
	 */
	public abstract <T extends Event> void fireEvent(Object sender, T event);

}
