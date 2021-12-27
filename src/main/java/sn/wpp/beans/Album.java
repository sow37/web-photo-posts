package sn.wpp.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sn.wpp.common.CommonAttributs;
import sn.wpp.common.enumeration.Acces;

@Entity
@NamedQueries({
@NamedQuery(name = "getUserAlbums", query = "SELECT a FROM Album a WHERE a.owner = :proprio"),
@NamedQuery(name = "getAlbumByStatus", query = "SELECT a FROM Album a WHERE a.acces = :statut")})
public class Album extends CommonAttributs implements Serializable {

	private String titre;
	private String description;
	private Acces acces;
	@OneToMany(mappedBy = "album", cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	private List<Image> images;
	@ManyToOne
	private User owner;
	@ManyToMany(cascade = { CascadeType.MERGE })
	private List<User> sharedWith;

	public Album() {
	}

	public Album(String titre, String description, Acces acces) {
		this.titre = titre;
		this.description = description;
		this.acces = acces;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Acces getStatut() {
		return acces;
	}

	public void setStatut(Acces acces) {
		this.acces = acces;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public User getProprio() {
		return owner;
	}

	public void setProprio(User owner) {
		this.owner = owner;
	}

	public List<User> getSharedWith() {
		return sharedWith;
	}

	public void setSharedWith(List<User> sharedWith) {
		this.sharedWith = sharedWith;
	}

	@Override
	public String toString() {
		return String.format("Album [titre=%s, description=%s, acces=%s, images=%s, owner=%s, sharedWith=%s]", titre,
				description, acces, images, owner, sharedWith);
	}
	
	

}
