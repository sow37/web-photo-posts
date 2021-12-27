package sn.wpp.test;

import sn.wpp.beans.Compte;
import sn.wpp.dao.impl.CompteImp;
import sn.wpp.dao.interf.ComptInt;

public class TestCompte {

	public static void main(String[] args) {
		ComptInt comptdao = new CompteImp();
		
		Compte ousmane = new Compte("ousow", "ousow");
		
		//System.out.println(comptdao.add(ousmane));
		System.out.println(comptdao.getCompteByLogin("ousow"));
		ousmane.setLogin("ousow37");
		ousmane.setPassword("passer");
		System.out.println(comptdao.update(ousmane));
		
	}

}
