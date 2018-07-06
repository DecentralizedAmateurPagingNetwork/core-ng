package org.dapnet.core.scheduler;

import org.dapnet.core.config.Configuration;
import org.dapnet.core.config.PropertyReader;

public final class SchedulerConfiguration extends Configuration {

	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void loadConfiguration(PropertyReader reader) {
		enabled = reader.getBoolean("scheduler.enabled", false);
	}

}
