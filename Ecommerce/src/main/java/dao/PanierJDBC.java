package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Metier.Produit;
   
public class PanierJDBC {
	public static int qte=0;
	public static void savePanier(Produit produit) throws InstantiationException, IllegalAccessException {		
       
	
	Connection cnx=JDBC.connect();	
	
	try {
		PreparedStatement ps= cnx.prepareStatement("INSERT INTO procde(numpro,numcde,qte) VALUES(?,?,?)");
	//	ps.setInt(1, produit.getPuProduit());
	//	ps.setInt(2, produit.getNomProduit());
	//	ps.setInt(3, produit.getFamProduit());
		
	
		System.out.println(ps);
		ps.executeUpdate();
		ps.close();
		System.out.println("valide");
	}
	catch (SQLException e) {
		 e.printStackTrace();
	}
	}
}
