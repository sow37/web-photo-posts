package sn.wpp.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sn.wpp.common.CommonAttributs;

@SuppressWarnings("serial")
@Entity
public class Tag extends CommonAttributs implements Serializable {
	private String nom;
	@ManyToOne(cascade = { CascadeType.MERGE })
	private Image image;

	public Tag() {
	}

	public Tag(String nom) {
		this.nom = nom;
	}

	public Tag(Long id, String nom) {
		super(id);
		this.nom = nom;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
