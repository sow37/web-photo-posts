package sn.wpp.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import sn.wpp.common.CommonAttributs;
import sn.wpp.common.enumeration.Profil;

@SuppressWarnings("serial")
@NamedQueries({@NamedQuery(name = "getUserByEmail", query = "SELECT u FROM User u WHERE u.email = :userEmail"),
@NamedQuery(name = "getUsersWithStatus", query = "SELECT u FROM User u WHERE u.profil = :userStatus"),
@NamedQuery(name = "getAll", query = "SELECT u FROM User u"),
@NamedQuery(name = "getUserByLogin", query = "SELECT u FROM User u WHERE u.compte.id = (select c.id from Compte c where c.login LIKE :userLogin )")})

@Entity
// @Stateful(passivationCapable = false)
public class User extends CommonAttributs implements Serializable {
	private String nom;
	private String prenom;
	private String email;
	private Profil profil;
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	private Compte compte;
	@OneToMany(mappedBy = "owner", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private List<Album> albums;
	/*
	 * @ManyToOne(cascade = { CascadeType.MERGE }) private Album albumShared; //
	 * Album dont le user à accès => Navigabilité ne marche pas
	 */

	public User() {
	}

	public User(String nom, String prenom, String email, Profil profil, Compte compte) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.profil = profil;
		this.compte = compte;
	}

	public User(Long id, String nom, String prenom, String email, Profil profil, Compte compte) {
		super(id);
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.profil = profil;
		this.compte = compte;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Profil getProfil() {
		return this.profil;
	}

	public void setStatut(Profil profil) {
		this.profil = profil;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	/*
	 * public Album getAlbumShared() { return albumShared; }
	 * 
	 * public void setAlbumShared(Album albumShared) { this.albumShared =
	 * albumShared; }
	 */

	@Override
	public String toString() {
		return String.format("User [nom=%s, prenom=%s, email=%s, profil=%s, compte=%s, albums=%s]", nom, prenom, email,
				profil, compte.toString(), albums);
	}
	
	
}
