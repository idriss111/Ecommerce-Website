package dao;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import com.itextpdf.io.source.ByteArrayOutputStream;

import Metier.Famille;

public class FamilleJDBC {
	
	public static void saveFamille(Famille famille) throws InstantiationException, IllegalAccessException {		
		Connection cnx=JDBC.connect();	
		
		try {
			PreparedStatement ps= cnx.prepareStatement("INSERT INTO famille(nomFam,photoFam) VALUES(?,?)");
			ps.setString(1, famille.getNomFamille());
			ps.setBlob(2, famille.getPhotoFamille());
		
			System.out.println(ps);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	public static ArrayList<Famille> getFamilles() throws InstantiationException, IllegalAccessException {		
		Connection cnx=JDBC.connect();	
	
		ArrayList<Famille> fam=new ArrayList<Famille>();
 		String query="Select * from Famille";
 		System.out.println(query);
	   int i=0;
	   Famille f;
	   try {
			Statement stm=JDBC.connect().createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				String nom=rs.getString(2);	
				int numfam=rs.getInt(1);
	  			f=new Famille(numfam,nom);
	  			 
				fam.add(f);
				System.out.println(fam.get(i).getNomFamille());
				i++;
			}
	}
	   catch (SQLException e) {
			
			e.printStackTrace();

}
	   return fam;
	}
	public static int getFamillesNumber(String nom) throws InstantiationException, IllegalAccessException {		
		Connection cnx=JDBC.connect();	
	
	
 		String query="Select numFam from Famille where nomFam='"+nom+"'";
 		System.out.println(query);
	   int i=0;
	   Famille f;
	   int numfam=0;
	   try {
			Statement stm=JDBC.connect().createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {	
				numfam=rs.getInt(1);
				System.out.println(numfam);
			}
	}
	   catch (SQLException e) {
			
			e.printStackTrace();

}
	   return numfam;
	}
	

	public static ArrayList<Famille> getFamillesWithPic() throws InstantiationException, IllegalAccessException {		
		Connection cnx=JDBC.connect();	
	
		ArrayList<Famille> fam=new ArrayList<Famille>();
 		String query="Select * from famille";
 		System.out.println(query);
	   int i=0;
	   Famille f;
	   try {
			Statement stm=JDBC.connect().createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				String nom=rs.getString(2);	
				int numfam=rs.getInt(1);
				Blob blob=rs.getBlob("photoFam");
				if(blob.length()==0) System.out.println("blob null");
		 		System.out.println(blob.length());

				 InputStream inputStream = blob.getBinaryStream();
				   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				   byte[] buffer = new byte[4096];
				   int bytesRead = -1;
				    
				   try {
					while ((bytesRead = inputStream.read(buffer)) != -1) {
					   outputStream.write(buffer, 0, bytesRead);
					   }
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				    
				   byte[] imageBytes = outputStream.toByteArray();
				   String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				    
				   try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  			f=new Famille(numfam,nom,base64Image);
	  			 
				fam.add(f);
				System.out.println(fam.get(i).getNomFamille());
				System.out.println(fam.get(i).getOutputstream().charAt(1));
				i++;
			}
	}
	   catch (SQLException e) {
			
			e.printStackTrace();

}
	   return fam;
	}
	
	//verifier fam
	
	  public static boolean verifierFamille(String nom) throws InstantiationException, IllegalAccessException {
			boolean existe=false;
			String nomexst="";
			String query ="select * from famille where nomFam='"+nom+"'";
	  		try {
	  			Statement stm=JDBC.connect().createStatement();
	  			ResultSet rs=stm.executeQuery(query);
	  			while(rs.next()) {
	  				nomexst=rs.getString(2);
	  				System.out.println("recup");
	  			}
	  			if (nom.equals(nomexst)) {
	  				existe=true;
	  				System.out.println("true");
	  			}
	  			
	  		} catch (SQLException e) {
	  			e.printStackTrace();
	  		}
			return existe;
		}
	  
	  public static void deleteFamille(String nom) throws InstantiationException, IllegalAccessException {
		  Connection cnx=JDBC.connect();	
			
			try {
				PreparedStatement ps= cnx.prepareStatement("delete from famille where nomFam='"+nom+"'");
				ps.executeUpdate();
				ps.close();
				System.out.println("famille supprimee!!");
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}
	  }
	
	  public static int getIdFamille(String nom) throws InstantiationException, IllegalAccessException {
	  Connection cnx=JDBC.connect();	
		
		ArrayList<Famille> fam=new ArrayList<Famille>();
		String query="Select numFam from Famille where nomFam='"+nom+"'";
		System.out.println(query);
		int id=0;
		try {
  			Statement stm=JDBC.connect().createStatement();
  			ResultSet rs=stm.executeQuery(query);
  			while(rs.next()) {
  				id=rs.getInt(1);
  				System.out.println("recup");
  			}
		
	  }catch (SQLException e) {
			 e.printStackTrace();
		}
		return id;
		}
	  public static void updateFamille(String nmF ) {
	    	 try {
	    		 PreparedStatement ps=JDBC.connect().prepareStatement("Update  famille Set nomFam='"+nmF+"'");
	    		 ps.executeUpdate();
	    		 
	    	 }catch(Exception e){
	    		 e.printStackTrace();
	
}}
	  
	  
	  
	  
	  
	  

}