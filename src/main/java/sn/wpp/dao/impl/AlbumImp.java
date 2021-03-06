package sn.wpp.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;


import sn.wpp.beans.Album;
import sn.wpp.beans.Image;
import sn.wpp.beans.User;
import sn.wpp.common.enumeration.Acces;
import sn.wpp.dao.interf.AlbumInt;
//import javax.persistence.Entity;

public class AlbumImp implements AlbumInt {
	private EntityManager em;
	public AlbumImp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wpp_pu");
		em = emf.createEntityManager();
	}
	@Override
	public void add(Album album) {
		try {
			em.getTransaction().begin();
			em.persist(album);
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Album> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Album getAlbumById(long l) {
		// TODO Auto-generated method stub
		return em.find(Album.class, l);
	}
	@Override
	public void update(Album album) {
		// TODO Auto-generated method stub
		try {
			
			em.getTransaction().begin();
			em.merge(album);
			em.getTransaction().commit();
			System.out.println("timmi");
			
		} catch (Exception e) {
			System.out.println("erreur");
			e.printStackTrace();
			
		}
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
	@SuppressWarnings("unchecked")
	public List<Album> findAlbumByStatus(Acces status)
	{
		List<Album> albums = null;
		System.out.println("from server "+ status);
		albums = em.createNamedQuery("getAlbumByStatus").setParameter("statut", status).getResultList();
		if(albums == null) {
			System.out.println("Aucun album null");
		}else {
			System.out.println("size:"+albums.size());
		}
		return albums;
	}
	
	public void removeById(Long id, HttpServletRequest request)
	{
		Album album = em.find(Album.class, id);
		System.out.println("Found : " + album.getTitre());
		String uploadDirectory = request.getServletContext().getInitParameter("uploadDirectory");
		System.out.println(uploadDirectory);
		removeImagesOnDeleteAlbum(album, uploadDirectory);
		System.out.println("PAssed");
		try {
			em.getTransaction().begin();
			em.remove(album);
			em.getTransaction().commit();
			//return true;
		} catch (Exception e) {
			e.printStackTrace();
			//return false;
		}
		//em.remove(album);
	}
	
	private void removeImagesOnDeleteAlbum(Album album, String path)
	{
		System.out.println("Remove method "+path);
		for (Image img : album.getImages())
		{
			File imgFile = new File(path + "/" + img.getFichierImage());
			if (imgFile.exists())
			{
				System.out.println("Image here : "+imgFile);
				imgFile.delete();
				System.out.println("Deleted ");
			}
		}
	}
	public List<Album> getAccessibleAlbums(User user)
	{
		if(user == null) {
			List<Album> albums = findAlbumByStatus(Acces.publique);
			return albums;
		}
		List<Album> albums = findAlbumByStatus(Acces.privee);
		System.out.println("Depuis Imp "+albums.size());
		List<Album> accessibleAlbums = new ArrayList<Album>();
		for (Album album : albums)
		{
			for (User u : album.getSharedWith())
			{
				System.out.println("Depuis Imp Shared " +album.getSharedWith());
				System.out.println("Le user qui a partager : "+u.getNom() +" ID: "+u.getId());
				System.out.println("Le users qui doit avoir access : "+user.getNom() +" ID : "+user.getId());
				if (u.getEmail().equals(user.getEmail()))
				{
					accessibleAlbums.add(album);
				}
			}
		}
		System.out.println("Depuis Imp access "+accessibleAlbums);
		return accessibleAlbums;
	}
	
	
}
