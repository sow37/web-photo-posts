package sn.wpp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.wpp.beans.User;
import sn.wpp.common.enumeration.Profil;
import sn.wpp.dao.interf.UserInt;



public class UserImp implements UserInt{
	private EntityManager em;
	public UserImp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wpp_pu");
		em = emf.createEntityManager();
	}
	
	@Override
	public boolean add(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<User> findUsersWithout(String email)
	{
		List<User> users = this.getAll();
		
		for (User user : users)
		{
			if (user.getEmail().equals(email))
			{
				users.remove(user);
				break;
			}
		}
		
		return users;
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
	public User getUser(long id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}
	
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
	public boolean update(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(User user) {
		try {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public User getUserByLogin(String login) {
		try {
			em.getTransaction().begin();
			User user = (User) em.createNamedQuery("getUserByLogin").setParameter("userLogin", login).getSingleResult();
			em.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public List<User> findUsersWithStatus(Profil profil)
	{
		List<User> users = null;
		users = (List<User>) this.em.createNamedQuery("getUsersWithStatus").setParameter("userStatus", profil)
				.getResultList();
		
		return users;
	}

}
