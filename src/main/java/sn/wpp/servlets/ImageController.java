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
				imageImp.deleteById(Long.parseLong(imageId), request);
				
				response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				break;
			case "/user/album/images":
				albumId = request.getParameter("album");
				if (albumId == null || albumId.isEmpty())
				{
					response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				}else {
					album = albumImp.getAlbumById(Long.parseLong(albumId));
					System.out.println("Images size "+album.getImages().size());
					request.setAttribute("album", album);
					request.getServletContext().getRequestDispatcher(LIST_IMAGE_PAGE).forward(request, response);
				}
				
				
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
		String description;
		String titre;
		switch (path)
		{
			case "/user/album/image/add":
				request.setAttribute("update", "add");
				String alb = request.getParameter("album");
				System.out.println("Albummmmmmmm Id "+alb);
				String SalbumId =uploader.getValeur(request.getPart("album"));
				Long albumId = Long.parseLong(SalbumId);
				
				Album album = albumImp.getAlbumById(albumId);
				System.out.println(album);
				description = uploader.getValeur(request.getPart("description"));
				titre = uploader.getValeur(request.getPart("titre"));
				
				if (imageValidator.validate().isEmpty())
				{
					List<Image> images = uploader.saveImages();
					System.out.println(uploader.saveImages());
					if (!images.isEmpty())
					{
						Image img = images.get(0);
						System.out.println("Mon image "+img);
						img.setTitre(titre);
						img.setDescription(description);
						img.setAlbum(album);
						imageImp.add(img);
						request.setAttribute("success", "Image ajoutee avec success");
						String redir = request.getContextPath() + "/user/album/images?album="+SalbumId;
						response.sendRedirect(redir);
					}
					else
					{
						System.out.println("Erruer");
					}
				}
				else
				{
					System.out.println("Errueurrrrr");
					request.setAttribute("form", imageValidator.validate());
					System.out.println(imageValidator.result);
					request.getServletContext().getRequestDispatcher(ADD_IMAGE_PAGE).forward(request, response);
				}
				break;
			case "/user/album/image/update":
				request.setAttribute("update", "update");
				break;
		}
		
	}
	
}
