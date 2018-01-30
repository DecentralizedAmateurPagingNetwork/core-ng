package org.dapnet.core.events;

import java.io.Serializable;

/**
 * Base class for events.
 * 
 * @author Philipp Thiel
 */
public class Event implements Serializable, Comparable<Event> {

	private static final long serialVersionUID = 3171011180914813478L;
	private final int priority;

	/**
	 * Creates a new event instance with a default priority of 0.
	 */
	protected Event() {
		this(0);
	}

	/**
	 * Creates a new event instance with the given priority.
	 * 
	 * @param priority
	 *            Event priority
	 */
	protected Event(int priority) {
		this.priority = priority;
	}

	/**
	 * Gets the event priority.
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
