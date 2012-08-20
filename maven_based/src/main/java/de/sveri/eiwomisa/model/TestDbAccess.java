package de.sveri.eiwomisa.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TestDbAccess {

	@PersistenceContext
	protected static EntityManager em;

	public static void doIt() {
		Task t = new Task();
		t.setName("test");
		em.merge(t);
	}

}
