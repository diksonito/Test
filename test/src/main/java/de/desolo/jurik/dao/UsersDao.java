package de.desolo.jurik.dao;

import de.desolo.jurik.resources.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsersDao {
	static EntityManagerFactory factory;
	static EntityManager entityManager;
	
	public UsersDao() {
	}

	private void emStart() {
		factory = Persistence.createEntityManagerFactory("simple");
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
	}

	private void emEnd() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

	// find user by login name
	public User findByLogin(String login) {
		emStart();
		User foundUser = entityManager.find(User.class, login);
		emEnd();
		return foundUser;
	}

	// Update user
	public void update(User user) {
		emStart();
		entityManager.merge(user);
		emEnd();
	}

	//New record
	public void createUser(User user) {
		emStart();
		entityManager.persist(user);
		emEnd();
	}


	// Delete DB record
	public <T> void delete(T record) {
		emStart();
		Object reference = entityManager.getReference(record.getClass(), factory.getPersistenceUnitUtil().getIdentifier(record));
		entityManager.remove(reference);
		emEnd();
	}



	// Select all query from dbTable table
	public <T> List<T> selectAll(Class<T> type) {
		emStart();
		String selAll="From " + type.getName();
		Query query = entityManager.createQuery(selAll);
		@SuppressWarnings("unchecked")
		List<T> tList = query.getResultList();
		emEnd();
		return  tList;
	}
}