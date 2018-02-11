package org.dapnet.core.data;

import javax.persistence.EntityManager;

public final class UserManager extends ObjectManager {

	UserManager(PersistenceService service) {
		super(service);
	}

	public void save(User user) {
		EntityManager manager = service.getEntityManagerFactory().createEntityManager();
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();
	}

}
