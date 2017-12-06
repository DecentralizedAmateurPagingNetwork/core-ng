package org.dapnet.core.stats;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * An integer-based statistic counter.
 * 
 * @author Philipp Thiel
 */
public class Counter extends AtomicInteger {

	private static final long serialVersionUID = -8134588560542140535L;
	private final String name;

	/**
	 * Creates a new counter bject with the given name.
	 * 
	 * @param name
	 *            Name of the counter
	 * @throws NullPointerException
	 *             if {@code name} is null
	 */
	public Counter(String name) {
		this.name = Objects.requireNonNull(name);
	}

	/**
	 * Returns the name
	 * 
	 * @return Name
	 */
	public String getName() {
		return name;
	}

}
