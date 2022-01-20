package sn.wpp.dao.interf;

import java.util.List;

import sn.wpp.beans.User;
import sn.wpp.common.enumeration.Profil;

public interface UserInt {

	public boolean add(User user);
	public List<User> getAll();
	public User getUser(long id);
	public List<User> findUsersWithStatus(Profil profil);
	public User getUserByEmail(String email);
	public boolean update(User user);
	public boolean delete(User user);
	
}
