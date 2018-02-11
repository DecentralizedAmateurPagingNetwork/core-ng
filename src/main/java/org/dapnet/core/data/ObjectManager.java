package org.dapnet.core.data;

import java.util.Objects;

/**
 * Abstract base class for database object managers.
 * 
 * @author Philipp Thiel
 */
abstract class ObjectManager {

	protected final PersistenceService service;

	/**
	 * Constructs a new object manager instance.
	 * 
	 * @param service
	 *            {@link PersistenceService} instance to use.
	 */
	protected ObjectManager(PersistenceService service) {
		this.service = Objects.requireNonNull(service);
	}

}
