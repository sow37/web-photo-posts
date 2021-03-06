package sn.wpp.dao.impl;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import sn.wpp.beans.Image;
import sn.wpp.dao.interf.ImageInt;


public class ImageImp implements ImageInt {
	EntityManager em;
	
	public ImageImp() {
		// TODO Auto-generated constructor stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wpp_pu");
		em = emf.createEntityManager();
	}
	
	public Image findById(Long id)
	{
		return em.find(Image.class, id);
	}
	
	public void add(Image image)
	{
		try
		{
			em.getTransaction().begin();
			em.persist(image);
			em.getTransaction().commit();
			//System.out.println("Added");
		}catch(Exception e)
		{
			System.out.println("Error happened");
			e.printStackTrace();
		}
		
	}
	
	public void delete(Image image, String uplodaDirectory)
	{
		this.removeImageFile(uplodaDirectory, image);
		System.out.println("Image ---------------- " + image.getTitre());
		try {
			em.getTransaction().begin();
			em.remove(image);
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteById(Long id, HttpServletRequest request)
	{
		try
		{
			
			Image img = em.find(Image.class, id);
			//removeImageFile(request.getServletContext().getInitParameter("uploadDirectory"), img);
			delete(img,request.getServletContext().getInitParameter("uploadDirectory"));
			try {
				em.remove(img);
				System.out.println("deleted try");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("deleted");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Image image)
	{
		em.merge(image);
	}
	
	public void removeImageFile(String path, Image img)
	{
		File imgFile = new File(path + "/" + img.getFichierImage());
		if (imgFile.exists())
		{
			imgFile.delete();
		}
	}

}
