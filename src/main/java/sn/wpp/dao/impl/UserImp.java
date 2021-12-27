package sn.wpp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.wpp.beans.Compte;
import sn.wpp.beans.User;
import sn.wpp.dao.interf.UserInt;


public class UserImp implements UserInt{
	private EntityManager em;
	public UserImp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wpp_pu");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		List<User> users = null;
		try {
			em.getTransaction().begin();
			users = em.createNamedQuery("getAll").getResultList();
			em.getTransaction().commit();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User getUserByEmail(String email) {
		try {
			em.getTransaction().begin();
			User user = (User) em.createNamedQuery("getUserByEmail").setParameter("userEmail", email).getSingleResult();
			em.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int update(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int delete(User user) {
		try {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
