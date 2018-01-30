package org.dapnet.core.stats;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class StatisticsManager {

	private final ConcurrentMap<String, Counter> counters = new ConcurrentHashMap<>();

	public Counter create(String name) {
		Objects.requireNonNull(name);
		Counter counter = new Counter(name);
		return counters.putIfAbsent(name, counter);
	}

	public Counter get(String name) {
		Objects.requireNonNull(name);
		return counters.get(name);
	}

}
