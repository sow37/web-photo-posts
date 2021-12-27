package sn.wpp.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import sn.wpp.common.CommonAttributs;

@SuppressWarnings("serial")
@NamedQuery(name = "getCompteByLogin", query = "SELECT c FROM Compte c WHERE c.login LIKE :compteLogin")
@Entity
// @Stateful(passivationCapable = false)
public class Compte extends CommonAttributs implements Serializable {
	private String login;
	private String password;
	@OneToOne(mappedBy = "compte", cascade = { CascadeType.REMOVE, CascadeType.MERGE })
	private User user;

	public Compte() {
	}

	@PrePersist
	public void encodePassword() {

	}

	public Compte(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public Compte(String login, String password, User user) {
		this.login = login;
		this.password = password;
		this.user = user;
	}

	public Compte(Long id, String login, String password, User user) {
		super(id);
		this.login = login;
		this.password = password;
		this.user = user;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return String.format(
				"Compte [login=%s, password=%s, CreatedAt=%s, UpdatedAt=%s]",
				login, password, getCreatedAt(), getUpdatedAt());
	}

	
	
	

}
