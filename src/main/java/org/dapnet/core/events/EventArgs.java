package org.dapnet.core.events;

/**
 * Base class for event arguments.
 * 
 * @author Philipp Thiel
 */
public class EventArgs {

	/**
	 * An empty event argument object without data. Use this instead of passing
	 * {@code null} to the handler to avoid {@link NullPointerException}s if the
	 * handler does not check for {@code nulls}.
	 */
	public static final EventArgs EMPTY = new EventArgs();

}
