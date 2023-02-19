package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Metier.Client;

public class RegisteerJDBC {
	public static void saveRegistration(Client client) throws InstantiationException, IllegalAccessException {		
		Connection cnx=JDBC.connect();	
		
		try {
			PreparedStatement ps= cnx.prepareStatement("INSERT INTO client(nomCli,prenomCli,adrCli,pass) VALUES(?,?,?,?)");
			ps.setString(1, client.getNomClient());
			ps.setString(2, client.getPrenomClient());
			ps.setString(3, client.getAdresse());
			ps.setString(4,client.getPassword());
			
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
}
