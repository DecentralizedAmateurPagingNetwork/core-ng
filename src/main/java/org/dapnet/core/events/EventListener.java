package org.dapnet.core.events;

/**
 * Event listener interface. Event listeners can be registered within an
 * {@link EventManager} to receive events.
 * 
 * @author Philipp Thiel
 *
 * @param <T> Event type
 */
@FunctionalInterface
public interface EventListener<T extends Event> {

	/**
	 * This method is called whenever an event is received. This method must not
	 * throw exceptions. Doing so may break the event manager depending on its
	 * implementation. Also avoid performing long running tasks which may block the
	 * worker thread.
	 * 
	 * @param sender Object that caused the event
	 * @param event  Event data
	 */
	void onEvent(Object sender, T event);

}
