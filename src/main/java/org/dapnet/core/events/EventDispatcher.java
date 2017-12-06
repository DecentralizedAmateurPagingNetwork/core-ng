package org.dapnet.core.events;

/**
 * A synchronous event dispatcher that simply forwards incoming events to the
 * event listeners. Events are dispatched from within the calling thread.
 * 
 * @author Philipp Thiel
 */
class EventDispatcher {

	/**
	 * Dispatches an event.
	 * 
	 * @param listeners
	 *            Event listeners to dispatch to.
	 * @param sender
	 *            Object that caused the event.
	 * @param event
	 *            Event data
	 */
	public <T extends Event> void dispatchEvent(EventListenerSet<T> listeners, Object sender, T event) {
		listeners.dispatchEvent(sender, event);
	}

}
