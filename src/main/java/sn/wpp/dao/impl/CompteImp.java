package sn.wpp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.wpp.beans.Compte;

import sn.wpp.dao.interf.ComptInt;



public class CompteImp implements ComptInt {

	private EntityManager em;
	public CompteImp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wpp_pu");
		em = emf.createEntityManager();
	}
	@Override
	public int add(Compte compte) {
		try {
			em.getTransaction().begin();
			em.persist(compte);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public List<Compte> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int update(Compte compte) {
		try {
			em.getTransaction().begin();
			em.merge(compte);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int delete(int id) {
		return id;
	}
	@Override
	public Compte getCompteByLogin(String login) {
		try {
			em.getTransaction().begin();
			Compte compte = (Compte) em.createNamedQuery("getCompteByLogin").setParameter("compteLogin", login).getSingleResult();
			em.getTransaction().commit();
			return compte;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
