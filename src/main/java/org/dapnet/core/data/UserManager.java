package org.dapnet.core.data;

import javax.persistence.EntityManager;

public final class UserManager extends ObjectManager {

	UserManager(PersistenceService service) {
		super(service);
	}

	public User getUser(int uid) {
		EntityManager manager = null;
		try {
			manager = service.getEntityManagerFactory().createEntityManager();
			return manager.find(User.class, uid);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}

	public User getUser(String username) {
		return null;
	}

	public void save(User user) {
		EntityManager manager = null;
		try {
			manager = service.getEntityManagerFactory().createEntityManager();
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}

	public void deleteUser(int uid) {

	}

	public int getUserId(String username) {
		return 0;
	}

}
