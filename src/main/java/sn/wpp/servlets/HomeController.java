package sn.wpp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.wpp.helpers.ConfirmUser;
import sn.wpp.beans.Album;
import sn.wpp.common.enumeration.Acces;
import sn.wpp.dao.impl.AlbumImp;
import sn.wpp.dao.impl.CompteImp;
import sn.wpp.dao.impl.UserImp;
import sn.wpp.helpers.AuthForm;
//import javax.persistence.Entity;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({ "", "/login", "/register", "/gallery", "/logout" })

public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_PAGE = "/WEB-INF/login.jsp";
	private static final String REGISTER_PAGE = "/WEB-INF/signup.jsp";
	
	private static final String GALLERY_PAGE = "/WEB-INF/Gallery.jsp";
	
	private static final String LIST_IMAGE_PAGE = null;
	private static final String HOME_PAGE = "/WEB-INF/Home.jsp";
	private static final String VUE_AJOUT = "/WEB-INF/UserList.jsp";
	
	private UserImp user;
	
	private CompteImp compte;
	
	//private CookieManager cookieManager;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.path = request.getServletPath();
		//request.setAttribute("path", path);
		//Long userId;
		//User user;
		HashMap<String, String> form = new HashMap<String, String>();
		//this.cookieManager = new CookieManager(request, response);
		AlbumImp albumImp = new AlbumImp();
		switch (request.getServletPath())
		{
			case "/login":
				getServletContext().getRequestDispatcher(LOGIN_PAGE).forward(request, response);
				break;
			case "/logout":
				request.getSession().invalidate();
				response.sendRedirect(request.getContextPath());
				break;
			case "/register":
				
				getServletContext().getRequestDispatcher(REGISTER_PAGE).forward(request, response);
				break;
			case "/gallery":
				//Ici on recupere les albums publics de facon generale
				//List<Album> albumss = null;
				//request.setAttribute("albums", albumss);
				List<Album> albums = albumImp.findAlbumByStatus(Acces.publique);
				request.setAttribute("albums", albums);
				request.getServletContext().getRequestDispatcher(GALLERY_PAGE).forward(request, response);
				break;
			case "/gallery/photos":
				String albumId = request.getParameter("album");
				if (albumId == null || albumId.isEmpty())
				{
					response.sendRedirect(request.getContextPath() + GALLERY_PAGE);
				}
				Album album = null; // chercher Album selon son id
				request.setAttribute("album", album);
				request.getServletContext().getRequestDispatcher(LIST_IMAGE_PAGE).forward(request, response);
				break;
			default:
				getServletContext().getRequestDispatcher(HOME_PAGE).forward(request, response);
		}
				
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getServletPath()) {
		case "/login": 
			
			AuthForm form = new AuthForm(request);
			if(form.authentifier()) {
				request.setAttribute("message", "Hello");
				 response.sendRedirect(request.getContextPath());
			}else {
				String path = request.getContextPath()+"/login?error=1&user=";
				String sentLogin = form.getLogin();
				System.out.println(sentLogin);
				path += sentLogin != null? sentLogin.trim() : "";
				response.sendRedirect(path);
			}
			break;
		case "/register": 
			
			ConfirmUser forms = new ConfirmUser(request);
			if(forms.ajouter()) {
				
				String ajouter = forms.getStatusMessage();
				request.setAttribute("ajouter", ajouter);
				String redUrl = request.getContextPath()+"/login?ajout=" + ajouter;
				response.sendRedirect(redUrl);
			}else {
				request.setAttribute("form", forms);
				getServletContext().getRequestDispatcher(VUE_AJOUT).forward(request, response);
			}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + request.getServletPath());
		}
	}

}
