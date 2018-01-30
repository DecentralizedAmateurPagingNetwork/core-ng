package org.dapnet.core.stats;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * An integer-based statistics counter. This class is thread-safe.
 * 
 * @author Philipp Thiel
 */
public class Counter implements Serializable {

	private static final long serialVersionUID = -8134588560542140535L;
	private final AtomicInteger value = new AtomicInteger();
	private final String name;

	/**
	 * Creates a new counter object with the given name.
	 * 
	 * @param name
	 *            Name of the counter
	 * @throws NullPointerException
	 *             if {@code name} is null
	 */
	Counter(String name) {
		this.name = Objects.requireNonNull(name);
	}

	/**
	 * Returns the name.
	 * 
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the current value.
	 * 
	 * @return Current value
	 */
	public int getValue() {
		return value.get();
	}

	/**
	 * Sets the current value.
	 * 
	 * @param value
	 *            Value to set
	 */
	protected void setValue(int value) {
		this.value.set(value);
	}

	/**
	 * Increments the counter and returns the new value.
	 * 
	 * @return Updated value
	 */
	protected int increment() {
		return value.incrementAndGet();
	}

	/**
	 * Resets the counter to zero.
	 */
	public void reset() {
		value.set(0);
	}

	@Override
	public String toString() {
		return String.format("%s: %d", name, value.get());
	}

}
