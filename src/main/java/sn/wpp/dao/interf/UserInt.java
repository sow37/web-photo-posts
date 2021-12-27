package sn.wpp.dao.interf;

import java.util.List;

import sn.wpp.beans.User;

public interface UserInt {

	public int add(User user);
	public List<User> getAll();
	public User getUser(int id);
	public User getUserByEmail(String email);
	public int update(User user);
	public int delete(User user);
	
}
