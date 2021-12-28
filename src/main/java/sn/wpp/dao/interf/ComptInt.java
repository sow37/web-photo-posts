package sn.wpp.dao.interf;

import java.util.List;

import sn.wpp.beans.Compte;
//import sn.wpp.beans.User;

public interface ComptInt {

	public int add(Compte compte);
	public List<Compte> getAll();
	public Compte getCompteByLogin(String login);
	public int update(Compte compte);
	public int delete(int id);
}
