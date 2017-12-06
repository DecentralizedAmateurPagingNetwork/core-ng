package org.dapnet.core.events;

import java.io.Serializable;

/**
 * Base class for events.
 * 
 * @author Philipp Thiel
 */
public abstract class Event implements Serializable, Comparable<Event> {

	private static final long serialVersionUID = 5365623752785671067L;
	public static final int DEFAULT_PRIORITY = 0;
	private final int priority;

	/**
	 * Creates an event with default priority.
	 */
	protected Event() {
		this(DEFAULT_PRIORITY);
	}

	/**
	 * Creates an event with the given priority.
	 * 
	 * @param priority
	 *            Priority to use.
	 */
	protected Event(int priority) {
		this.priority = priority;
	}

	/**
	 * Returns the event priority. The higher the priority the sooner it will get
	 * processed.
	 * 
	 * @return Event priority
	 */
	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Event o) {
		if (priority < o.priority) {
			return -1;
		} else if (priority > o.priority) {
			return 1;
		} else {
			return 0;
		}
	}
}
