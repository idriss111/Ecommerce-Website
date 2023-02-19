package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Metier.Client;

public class LoginJDBC {
	public static Client getClient(String name,String password) throws InstantiationException, IllegalAccessException {
		Connection cnx=JDBC.connect();
		String requete = "Select numCli,nomCli,prenomCli,adrCli,pass from client where nomCli='"+name+"' And pass='"+password+"'";
		Client client=new Client();
		try {
			cnx = JDBC.connect();
		Statement stm = cnx.createStatement();
		ResultSet rs=stm.executeQuery(requete);
		System.out.print(" query :"+requete);
		while(rs.next()) {
			client.setNumClient(rs.getInt(1));
			client.setNomClient(rs.getString(2));
			client.setPrenomClient(rs.getString(3));
			client.setAdresse(rs.getString(4));
			client.setPassword(rs.getString(5));
			System.out.print(" clientname  :"+rs.getString(2));
			System.out.print(" prenom  :"+rs.getString(3));
			System.out.print("adresse  :"+rs.getString(4));
			System.out.print(" password:"+rs.getString(5));
		}
		System.out.print(" ---------- :"+client.getPassword());
		
		return client;
		}
		catch(Exception e) {
			e.printStackTrace(); 
			return null;
		}
		
		
	}
}
