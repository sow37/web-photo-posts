package sn.wpp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.wpp.beans.Album;
import sn.wpp.beans.User;
import sn.wpp.dao.interf.AlbumInt;

public class AlbumImp implements AlbumInt {
	private EntityManager em;
	public AlbumImp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wpp_pu");
		em = emf.createEntityManager();
	}
	@Override
	public void add(Album album) {
		em.getTransaction().begin();
		em.persist(album);
		em.getTransaction().commit();
	}
	@Override
	public List<Album> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Album getAlbumById(int id) {
		// TODO Auto-generated method stub
		return em.find(Album.class, id);
	}
	@Override
	public void update(Album album) {
		// TODO Auto-generated method stub
		em.merge(album);
	}
	@Override
	public void delete(Album album) {
		em.remove(album);
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> findUserAlbum(User user)
	{
		List<Album> albums = null;
		
		albums = em.createNamedQuery("getUserAlbums").setParameter("proprio", user).getResultList();
		
		return albums;
	}
	
	

}
