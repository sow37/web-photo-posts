package sn.wpp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.wpp.beans.Album;
import sn.wpp.beans.Image;
import sn.wpp.dao.impl.AlbumImp;
import sn.wpp.dao.impl.ImageImp;
import sn.wpp.helpers.AlbumValidator;
import sn.wpp.helpers.ImageUploader;


@WebServlet(
{ "/user/album/images", "/user/album/image/add", "/user/album/image/update", "/user/album/image/delete" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 50, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 500, location = "/uploads")
public class ImageController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String ADD_IMAGE_PAGE = "/WEB-INF/addImg.jsp";
	private static final String LIST_IMAGE_PAGE = "/WEB-INF/albumView.jsp";
	private static final String USER_ALBUM_URL = "/user/albums";
	
	ImageImp imageImp = new ImageImp();
	AlbumImp albumImp = new AlbumImp();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getServletPath();
		request.setAttribute("path", path);
		HashMap<String, String> form = new HashMap<String, String>();
		Album album = null;
		String albumId;
		String imageId;
		Image img;
		switch (path)
		{
			case "/user/album/image/add":
				request.setAttribute("update", "add");
				albumId = request.getParameter("album");
				if (albumId == null || albumId.isEmpty())
				{
					response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				}
				album = albumImp.getAlbumById(Long.parseLong(albumId));
				request.setAttribute("albumTitle", album.getTitre());
				request.setAttribute("albumId", albumId);
				request.getServletContext().getRequestDispatcher(ADD_IMAGE_PAGE).forward(request, response);
				break;
			case "/user/album/image/update":
				request.setAttribute("update", "update");
				imageId = request.getParameter("image");
				if (imageId == null || imageId.isEmpty())
				{
					response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				}
				img = imageImp.findById(Long.parseLong(imageId));
				form.put("hauteur", img.getLargeur());
				form.put("largeur", img.getLargeur());
				form.put("titre", img.getTitre());
				form.put("description", img.getDescription());
				request.setAttribute("form", form);
				request.getServletContext().getRequestDispatcher(ADD_IMAGE_PAGE).forward(request, response);
				break;
			case "/user/album/image/delete":
				imageId = request.getParameter("image");
				if (imageId == null || imageId.isEmpty())
				{
					response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				}
				/*
				 * img = this.imageManager.findById(Long.parseLong(imageId));
				 * System.out.println( "UPLOAD DIRECTORY ----- " +
				 * request.getServletContext().getInitParameter("uploadDirectory"));
				 * this.imageManager.delete(img,
				 * request.getServletContext().getInitParameter("uploadDirectory"));
				 */
				System.out.println( "UPLOAD DIRECTORY ----- " +
						 request.getServletContext().getInitParameter("uploadDirectory"));
				imageImp.deleteById(Long.parseLong(imageId), request);
				
				response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				break;
			case "/user/album/images":
				albumId = request.getParameter("album");
				//System.out.println(albumId);
				if (albumId == null || albumId.isEmpty())
				{
					response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				}
				//System.out.println("bf");
				album = albumImp.getAlbumById(Long.parseLong(albumId));
				//System.out.println(album);
				request.setAttribute("album", album);
				request.getServletContext().getRequestDispatcher(LIST_IMAGE_PAGE).forward(request, response);
				break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getServletPath();
		request.setAttribute("path", path);
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		AlbumValidator imageValidator = new AlbumValidator(request);
		ImageUploader uploader = new ImageUploader(request);
		
		HashMap<String, String> form = new HashMap<String, String>();
		
		String description;
		String titre;
		String hauteur;
		String largeur;
		switch (path)
		{
			case "/user/album/image/add":
				request.setAttribute("update", "add");
				Long albumId = Long.parseLong(uploader.getValeur(request.getPart("albumId")));
				Album album = albumImp.getAlbumById(albumId);
				description = uploader.getValeur(request.getPart("description"));
				titre = uploader.getValeur(request.getPart("titre"));
				hauteur = uploader.getValeur(request.getPart("hauteur"));
				largeur = uploader.getValeur(request.getPart("largeur"));
				
				if (imageValidator.validate().isEmpty())
				{
					List<Image> images = uploader.saveImages();
					if (!images.isEmpty())
					{
						Image img = images.get(0);
						System.out.println(img);
						img.setTitre(titre);
						img.setDescription(description);
						img.setHauteur(hauteur);
						img.setLargeur(largeur);
						img.setAlbum(album);
						imageImp.add(img);
						//Response here
						
						String parameter = "/user/album/images?album=" + albumId;
						response.sendRedirect(request.getContextPath() + parameter);
					}
					else
					{
						System.out.println("Erruer");
					}
				}
				else
				{
					form.put("titre", titre);
					form.put("description", description);
					form.put("hauteur", hauteur);
					form.put("largeur", largeur);
					System.out.println("Errueurrrrr");
				}
				break;
			case "/user/album/image/update":
				request.setAttribute("update", "update");
				break;
		}
		
	}
	
}
