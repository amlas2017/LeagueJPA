package com.philippe.league.jpa.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GeneralDAO<T> {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("league");
	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	protected GeneralDAO() {

	}

	private static GeneralDAO instance;

	public static GeneralDAO getInstance() {
		if (instance != null)
			return instance;

		synchronized (GeneralDAO.class) {
			instance = new GeneralDAO<>();
		}
		return instance;

	}

	public void create(T toBeCreated) {
		transaction.begin();
		em.persist(toBeCreated);
		transaction.commit();

	}

	public Object find(Class clazz, Long primaryKey) {
		return em.find(clazz, primaryKey);
	}

	public void update(T toBeUpdated) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Method getId;

		getId = toBeUpdated.getClass().getMethod("getId");
		Long toBeUpdatedId = (Long) getId.invoke(toBeUpdated);
		toBeUpdated = (T) find(toBeUpdated.getClass(), toBeUpdatedId);
		create(toBeUpdated);

	}

}











