package sn.wpp.helpers;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import sn.wpp.beans.Compte;
import sn.wpp.beans.User;
import sn.wpp.common.FormFields;
import sn.wpp.common.enumeration.Profil;
import sn.wpp.dao.impl.UserImp;

public class ConfirmUser {
	public User utilisateur;
	
	
	private Map<String, String> erreurs;
	private boolean status;
	private String statusMessage;
	private HttpServletRequest request;
	public ConfirmUser(HttpServletRequest request) {
		this.status = false;
		this.request = request;
		this.erreurs = new HashMap<String, String>();
		
	}
	public boolean ajouter() {
		
		String nom = getParameter(FormFields.CHAMP_NOM);
		String prenom = getParameter(FormFields.CHAMP_PRENOM);
		String login = getParameter(FormFields.CHAMP_LOGIN);
		String password = getParameter(FormFields.CHAMP_PASSWORD);
		String email = getParameter(FormFields.CHAMP_EMAIL);
		this.utilisateur = new User(nom, prenom, email, Profil.simpleUser, new Compte(login, password));
		statusMessage = "Echec d'ajout";
		
		validerChamps(FormFields.CHAMP_NOM, FormFields.CHAMP_PRENOM, FormFields.CHAMP_LOGIN, FormFields.CHAMP_PASSWORD, FormFields.CHAMP_PASSWORDBIS, FormFields.CHAMP_EMAIL);
		validerPassword();
		System.out.println(erreurs);
		if(erreurs.isEmpty()) {
			//System.out.println("dans");
			UserImp userImp = new UserImp();
			status = userImp.add(utilisateur);
			if(status) {
				utilisateur = null;
				statusMessage = "Compte cree avec succes";
			}
		}
		
		return status;
	}
	
	public boolean update() {
		    //boolean isUpdated = false;
			validerChamps(FormFields.CHAMP_NOM, FormFields.CHAMP_PRENOM, FormFields.CHAMP_LOGIN, FormFields.CHAMP_PASSWORD, FormFields.CHAMP_PASSWORDBIS, FormFields.CHAMP_EMAIL);
			validerPassword();
			
			if(erreurs.isEmpty()) {
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
	
	private void validerChamps(String ...champs) {
		
		for(String champ : champs) {
			if(getParameter(champ) == null) {
				erreurs.put(champ, "Vous devez remplir ce champs");
			}
		}
		
	}
	
	private void validerPassword() {
		String password = getParameter(FormFields.CHAMP_PASSWORD);
		String passwordbis = getParameter(FormFields.CHAMP_PASSWORDBIS);
		if(password != null && !password.equals(passwordbis)) {
			erreurs.put(FormFields.CHAMP_PASSWORD, "Les deux passwords doivent correspondre");
			erreurs.put(FormFields.CHAMP_PASSWORDBIS, "Les deux passwords doivent correspondre");
		}
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	public boolean getStatus() {
		return status;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}
	
	
	
	

}

