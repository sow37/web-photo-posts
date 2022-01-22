package sn.wpp.helpers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sn.wpp.beans.User;
import sn.wpp.dao.impl.UserImp;



public class AuthForm {
	
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private HttpServletRequest request;
	private User utilisateur;
	private String login;
	private String password;
	public AuthForm(HttpServletRequest request) {
		this.request = request;
	}
	
	public boolean authentifier() 
	{
		UserImp auth = new UserImp();
		login = getParameter(CHAMP_LOGIN);
		password = getParameter(CHAMP_PASSWORD);
		utilisateur = auth.getUserByLogin(login);
		if(utilisateur != null && !utilisateur.getCompte().getPassword().equals(password)) {
				utilisateur = null;
		}
		if(utilisateur != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			return true;
		}
		return false;
	}
	private String getParameter(String parameter) {
		String valeur = request.getParameter(parameter);
		if(valeur == null || valeur.trim().isEmpty()) {
			return null;
		}
		return valeur.trim();
	}

	public String getLogin() {
		return login;
	}
}
