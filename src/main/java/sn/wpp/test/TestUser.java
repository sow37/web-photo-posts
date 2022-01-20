package sn.wpp.test;


import sn.wpp.beans.Compte;
import sn.wpp.beans.User;
import sn.wpp.common.enumeration.Profil;
import sn.wpp.dao.impl.UserImp;
import sn.wpp.dao.interf.UserInt;


public class TestUser {

	public static void main(String[] args) {
		UserInt userdao = new UserImp();
		//User user = new User("admin","admin","admin", Profil.admin, new Compte("admin", "admin"));
		//System.out.println(userdao.add(user));
		User user = userdao.getUserByEmail("admin");
//		user.setEmail("ousow37@gmail.com");
//		Compte compte = user.getCompte();
//		compte.setLogin("ousow");
//		compte.setPassword("ousow");
//		user.setCompte(compte);
//		System.out.println(userdao.update(user));
		System.out.println(userdao.getAll().get(0));
		
	}
}
