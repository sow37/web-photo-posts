package sn.wpp.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sn.wpp.helpers.AlbumValidator;
import sn.wpp.helpers.ImageUploader;

import sn.wpp.beans.Album;
import sn.wpp.beans.Image;
import sn.wpp.beans.User;
import sn.wpp.common.enumeration.Acces;

import sn.wpp.dao.impl.AlbumImp;
import sn.wpp.dao.impl.UserImp;




@SuppressWarnings("serial")
@WebServlet(
{ "/user/albums", "/user/album/add", "/user/album/update", "/user/album/delete", "/user/gallery", "/user/album/view" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 50, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 500, location = "/uploads")
public class AlbumsController extends HttpServlet
{
	
	private static final String LIST_ALBUM_PAGE = "/WEB-INF/Gallery.jsp";
	private static final String ADD_ALBUM_PAGE = "/WEB-INF/addAlbum.jsp";
	private static final String EDIT_ALBUM_PAGE = "/WEB-INF/addAlbum.jsp";
	private static final String GALLERY_PAGE = "/WEB-INF/Gallery.jsp";
	private static final String USER_ALBUM_URL = "/user/albums";
	private static final String VIEW_ALBUM_URL = "/WEB-INF/albumView.jsp";
	
	UserImp userImp = new UserImp();
	AlbumImp albumImp = new AlbumImp();
	String albumId;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getServletPath();
		request.setAttribute("path", path);
		
		List<User> users = null;
		List<Album> albums = null;
		
		User user = null;
		switch (path)
		{
			case "/user/albums":
				//request.setAttribute("albums", albumImp.findUserAlbum(user));
				albums = albumImp.findUserAlbum((User) request.getSession().getAttribute("utilisateur"));
				request.setAttribute("albums", albums);
				request.getServletContext().getRequestDispatcher(LIST_ALBUM_PAGE).forward(request, response);
				break;
			case "/user/gallery":
				// recuperer la liste des albums publics (et privees dont il a accés) et la
				// transmettre à la vue !
				 albums = albumImp.findUserAlbum((User) request.getSession().getAttribute("utilisateur"));
				// System.out
				// .println("SiZE albumAccessible ======== " +
				// this.albumManager.getAccessibleAlbums(user).size());
				//albums.addAll(albumImp.getAccessibleAlbums(user));
				//System.out.println("mes algume"+albums);
				request.setAttribute("albums", albums);
				request.getServletContext().getRequestDispatcher(GALLERY_PAGE).forward(request, response);
				break;
			case "/user/album/add":
				request.setAttribute("update", "add");
				users = userImp.getAll();
				request.setAttribute("users", users);
				request.getServletContext().getRequestDispatcher(ADD_ALBUM_PAGE).forward(request, response);
				break;
			case "/user/album/view":
				albumId = request.getParameter("album");
				if (albumId == null || albumId.isEmpty())
				{
					response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				}else {
					Album album = albumImp.getAlbumById(Long.parseLong(albumId));
					request.setAttribute("album", album);
					request.getServletContext().getRequestDispatcher(VIEW_ALBUM_URL).forward(request, response);
				}
				
				break;
			case "/user/album/update":
				request.setAttribute("update", "update");
				albumId = request.getParameter("album");
				if (albumId == null || albumId.isEmpty())
				{
					response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				}
				else
				{
					HashMap<String, String> form = new HashMap<String, String>();
					Album album = albumImp.getAlbumById(Long.parseLong(albumId));
					form.put("titre", album.getTitre());
					form.put("description", album.getDescription());
					form.put("statut", album.getStatut().toString() == "publique" ? "public" : "privee");
					//users = userImp.findUsersWithout(user.getEmail());
					System.out.println(album);
					if (album.getSharedWith().size() != 0)
					{
						request.setAttribute("usersAuth", album.getSharedWith());
						List<User> otherUser = new ArrayList<User>();
						for (User u : users)
						{
							if (!album.getSharedWith().contains(u))
							{
								otherUser.add(u);
							}
						}
						request.setAttribute("otherUsers", otherUser);
					}
					else
					{
						request.setAttribute("users", users);
					}
					request.setAttribute("album", album);
					request.setAttribute("form", form);
					request.getServletContext().getRequestDispatcher(EDIT_ALBUM_PAGE).forward(request, response);
				}
				break;
			case "/user/album/delete":
				albumId = request.getParameter("album");
				if (albumId == null || albumId.isEmpty())
				{
					response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				}
				else
				{
					//Album toDelete = albumImp.getAlbumById(Long.parseLong(albumId));
					//System.out.println(toDelete);
					albumImp.removeById(Long.parseLong(albumId), request);
					
					response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				}
				break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getServletPath();
		request.setAttribute("path", path);
		String titre;
		String statut;
		String usersSharedWith;
		String description;
		HashMap<String, String> form = new HashMap<String, String>();
		
		AlbumValidator albumValidator = new AlbumValidator(request);
		ImageUploader uploader = new ImageUploader(request);
		
		switch (path)
		{
			case "/user/album/add":
				description = uploader.getValeur(request.getPart("description"));
				titre = uploader.getValeur(request.getPart("titre"));
				statut = uploader.getValeur(request.getPart("statut"));
				//String files = request.getParameter	("files");
				//System.out.println(files);
				//System.out.println(statut);
				//System.out.println(titre);
				usersSharedWith = request.getPart("utilisateur") == null ? null
						: uploader.getValeur(request.getPart("utilisateur"));
				//System.out.println(usersSharedWith);
				System.out.println(albumValidator.validate());
				if (albumValidator.validate().isEmpty())
				{
					// rediriger vers la gallerie (mes albums)
					List<Image> images = uploader.saveImages();
					//System.out.println(images);
					List<User> usersAuthorize = new ArrayList<User>();
					if (usersSharedWith != null && !usersSharedWith.isEmpty())
					{
						String[] usersId = usersSharedWith.split(",");
						for (String userId : usersId)
						{
							usersAuthorize.add(userImp.getUser(Long.parseLong(userId)));
						}
					}
					System.out.println(images);
					if (!images.isEmpty())
					{
						Acces albumStatus = "public".equals(statut) ? Acces.publique
								: Acces.privee;
						Album album = new Album(titre, description, albumStatus);
						ArrayList<Image> pics = new ArrayList<Image>();
						for (Image img : images)
						{
							img.setAlbum(album);
							pics.add(img);
						}
						album.setImages(pics);
						if (album.getStatut().equals(Acces.privee))
						{
							usersAuthorize
									.add(((User) request.getSession().getAttribute("utilisateur")).getCompte().getUser());
							album.setSharedWith(usersAuthorize);
						}
						User owner = (User) request.getSession().getAttribute("utilisateur");
						album.setProprio(owner);
						List<Album> maListe = owner.getAlbums();
						//System.out.println(album);
						maListe.add(album);
						owner.setAlbums(maListe);
						userImp.update(owner);
						System.out.println("ajoute");
						response.sendRedirect(request.getContextPath() + "/user/albums");
						
					}
					else
					{
						System.out.print("Une erreur est survenue lors du chargement des images!");
					}
				}
				else
				{
					form.put("titre", titre);
					form.put("description", description);
					form.put("statut", statut);
				
					System.out.print("Une erreur est survenue");
					request.setAttribute("form", form);
					request.getServletContext().getRequestDispatcher(ADD_ALBUM_PAGE).forward(request, response);
					
				}
				break;
			case "/user/album/update":
				request.setAttribute("update", "update");
				albumId = request.getParameter("album");
				System.out.println(albumId);
				Album album = albumImp.getAlbumById(Long.parseLong(albumId));
				titre = request.getParameter("titre");
				description = request.getParameter("description");
				statut = request.getParameter("statut");
				usersSharedWith = request.getParameter("users");
				albumValidator = new AlbumValidator(request);
				
				if (albumValidator.validate().isEmpty())
				{
					album.setTitre(titre);
					album.setDescription(description);
					Acces albumStatus = "public".equals(statut) ? Acces.publique
							: Acces.privee;
					album.setStatut(albumStatus);
					if (statut == "privee")
					{
						List<User> newUsersShared = new ArrayList<User>();
						String[] usersId = usersSharedWith.split(",");
						for (String userId : usersId)
						{
							newUsersShared.add(userImp.getUser(Long.parseLong(userId)));
						}
						album.setSharedWith(newUsersShared);
					}
					albumImp.update(album);
					response.sendRedirect(request.getContextPath() + USER_ALBUM_URL);
				}
				else
				{
					form.put("titre", titre);
					form.put("description", description);
					form.put("statut", album.getStatut().toString() == "publique" ? "public" : "privee");
					request.setAttribute("form", form);
					request.setAttribute("album", album);
					//request.setAttribute("errors", result);
					request.setAttribute("usersAuth", album.getSharedWith());
					request.getServletContext().getRequestDispatcher(EDIT_ALBUM_PAGE).forward(request, response);
				}
				break;
		}
	}
	
}

