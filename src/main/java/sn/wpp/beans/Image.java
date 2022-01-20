package sn.wpp.beans;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import sn.wpp.common.CommonAttributs;

@SuppressWarnings("serial")
@Entity
public class Image extends CommonAttributs implements Serializable {
	@ManyToOne(cascade = { CascadeType.MERGE })
	private Album album;
	private String titre;
	private String description;
	private String hauteur;
	private String largeur;
	@OneToMany(mappedBy = "image", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private Set<Tag> tags;
	private String fichierImage;

	public Image() {
	}

	public Image(String description, String titre, String hauteur, String largeur, Album album, String fichier) {
		this.description = description;
		this.titre = titre;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.album = album;
		this.fichierImage = fichier;
	}

	public Image(Long id, String description, String titre, String hauteur, String largeur, Album album,
			String fichier) {
		super(id);
		this.description = description;
		this.titre = titre;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.album = album;
		this.fichierImage = fichier;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHauteur() {
		return hauteur;
	}

	public void setHauteur(String hauteur) {
		this.hauteur = hauteur;
	}

	public String getLargeur() {
		return largeur;
	}

	public void setLargeur(String largeur) {
		this.largeur = largeur;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public String getFichierImage() {
		return fichierImage;
	}

	public void setFichierImage(String fichierImage) {
		this.fichierImage = fichierImage;
	}

	

	
}