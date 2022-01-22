package sn.wpp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sn.wpp.beans.Album;
import sn.wpp.beans.User;
import sn.wpp.common.enumeration.Profil;
import sn.wpp.dao.impl.UserImp;
import sn.wpp.helpers.ConfirmUser;


/**
 * Servlet implementation class UsersController
 */
@WebServlet({"/user/profile","/user/upgrade","/user/delete", "/user/add", "/user/settings", "/user/list", "/user/list-admin", "/user/edit"})

public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String GALLERY_PAGE = "/WEB-INF/Gallery.jsp";
	private static final String USER_LIST_PAGE = "/WEB-INF/UserList.jsp";
	private static final String USER_ADD_PAGE = "/WEB-INF/signup.jsp";
	private static final String USER_PROFILE_PAGE = "/WEB-INF/editAccount.jsp";
	private static final String USER_PARAMETER_PAGE = "/WEB-INF/profile.jsp";
	private static String USER_LIST_URL = "/user/list";
	
	UserImp userlist = new UserImp();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, String> form = new HashMap<String, String>();
		Long userId;
		User user;
		switch (request.getServletPath())
		{
			case "/user/add":
				getServletContext().getRequestDispatcher(USER_ADD_PAGE).forward(request, response);
				break;
			case "/user/upgrade":
				userId = Long.parseLong(request.getParameter("user"));
				user = userlist.getUser(userId);
				if(user.getProfil().equals("simpleUser"))
				{
					user.setStatut(Profil.admin);
					userlist.update(user);
				}else {
					user.setStatut(Profil.simpleUser);
					userlist.update(user);
				}
				getServletContext().getRequestDispatcher(USER_LIST_PAGE).forward(request, response);
				break;
			
			case "/user/edit":
				
				userId = Long.parseLong(request.getParameter("user"));
				user = userlist.getUser(userId);
				request.setAttribute("role", user);
				if (user == null)
				{
					response.sendRedirect(request.getContextPath() + USER_LIST_PAGE);
				}
				else
				{
					form.put("userId", user.getId().toString());
					form.put("nom", user.getNom());
					form.put("prenom", user.getPrenom());
					form.put("email", user.getEmail());
					form.put("statut", user.getProfil().toString());
					form.put("login", user.getCompte().getLogin());
					form.put("mdp", user.getCompte().getPassword());
					form.put("cmdp", user.getCompte().getPassword());
					request.setAttribute("form", form);
				}
				request.getServletContext().getRequestDispatcher(USER_ADD_PAGE).forward(request, response);
				break;
			case "/user/delete":
				if (request.getParameter("user") == null || request.getParameter("user").isEmpty())
				{
					response.sendRedirect(request.getContextPath() + USER_LIST_URL);
				}
				else
				{
					userId = Long.parseLong(request.getParameter("user"));
					User deleteUser;
					deleteUser = userlist.getUser(userId);
					if(deleteUser != null) {
						userlist.delete(deleteUser);
						getServletContext().getRequestDispatcher(USER_LIST_URL).forward(request, response);
					}
					
				}
				break;
			case "/user/list":
				request.setAttribute("users", userlist.findUsersWithStatus(Profil.simpleUser));
				getServletContext().getRequestDispatcher(USER_LIST_PAGE).forward(request, response);
				break;
			case "/user/list-admin":
				request.setAttribute("users", userlist.findUsersWithStatus(Profil.admin));
				getServletContext().getRequestDispatcher(USER_LIST_PAGE).forward(request, response);
				break;
			case "/user/settings":
				getServletContext().getRequestDispatcher(USER_PROFILE_PAGE).forward(request, response);
				break;
			case "/user/profile":
				request.setAttribute("form", form);
				getServletContext().getRequestDispatcher(USER_PARAMETER_PAGE).forward(request, response);
				break;
			case "/user/gallery":
				List<Album> albums = null;
				request.setAttribute("albums", albums);
				request.getServletContext().getRequestDispatcher(GALLERY_PAGE).forward(request, response);
				break;
			
			default:
				getServletContext().getRequestDispatcher("/").forward(request, response);
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		String nom;
		String prenom;
		String email;
		String login;
		String password;
		//Long userId;
		String passwordbis;
		HashMap<String, String> form = new HashMap<String, String>();
		switch (request.getServletPath()) {
		case "/user/edit": 
			request.setAttribute("update", "update");
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			email = request.getParameter("email");
			login = request.getParameter("login");
			password = request.getParameter("password");
			passwordbis = request.getParameter("passwordbis");
			Long userId = Long.parseLong(request.getParameter("userId"));
			user = userlist.getUser(userId);
			if(user != null) {
				user.setNom(nom);
				user.setPrenom(prenom);
				user.setEmail(email);
				user.getCompte().setLogin(login);
				user.getCompte().setPassword(password);
				ConfirmUser confirm = new ConfirmUser(request);
				
				if (confirm.update())
				{
					userlist.update(user);
					USER_LIST_URL = "Administrateur".equals(user.getProfil()) ? "/user/list-admin" : "/user/list";
					response.sendRedirect(request.getContextPath() + USER_LIST_URL);
				}
			}
			
			else
			{
				form.put("userId", user.getId().toString());
				form.put("nom", nom);
				form.put("prenom", prenom);
				form.put("email", email);
				form.put("login", login);
				form.put("statut", user.getProfil().toString());
				form.put("password", password);
				form.put("passwordbis", passwordbis);
				request.setAttribute("form", form);
				request.getServletContext().getRequestDispatcher(USER_ADD_PAGE).forward(request, response);
			}
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + request.getServletPath());
		}
	}

}
