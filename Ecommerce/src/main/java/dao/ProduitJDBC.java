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
import Metier.Produit;

public class ProduitJDBC {
	public static void saveProduit(Produit produit) throws InstantiationException, IllegalAccessException {		
		Connection cnx=JDBC.connect();	
		
		try {
			PreparedStatement ps= cnx.prepareStatement("INSERT INTO produit(puPro,nomPro,Fampro,photoPro) VALUES(?,?,?,?)");
			ps.setDouble(1, produit.getPuProduit());
			ps.setString(2, produit.getNomProduit());
			ps.setInt(3, produit.getFamProduit());
			ps.setBlob(4, produit.getPhotoProduit());
			
		
			System.out.println(ps);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
	public static ArrayList<Produit> getProduitsWithPic() throws InstantiationException, IllegalAccessException {		
		Connection cnx=JDBC.connect();	
	
		ArrayList<Produit> prod=new ArrayList<Produit>();
 		String query="Select * from produit";
 		System.out.println(query);
	   int i=0;
	   Produit pr;
	   try {
			Statement stm=JDBC.connect().createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				double prix=rs.getDouble(2);	
				int numprod=rs.getInt(1);
				String nom=rs.getString(3);
				Blob blob=rs.getBlob("photoPro");
				int famPro=rs.getInt(4);

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
	  			
	  		pr=new Produit(numprod,prix,base64Image,nom,famPro) ;
			prod.add(pr);
				System.out.println(prod.get(i).getNomProduit());
				System.out.println(prod.get(i).getPuProduit());
				i++;
			}
	}
	   catch (SQLException e) {
			
			e.printStackTrace();

}
	   return prod;
	}
	
	
	
	 public static boolean verifierProduit(String nom) throws InstantiationException, IllegalAccessException {
			boolean existe=false;
			String nomexst="";
			String query ="select * from produit where nomPro='"+nom+"'";
	  		try {
	  			Statement stm=JDBC.connect().createStatement();
	  			ResultSet rs=stm.executeQuery(query);
	  			while(rs.next()) {
	  				nomexst=rs.getString(3);
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
	  
	  public static void deleteProduit(String nom) throws InstantiationException, IllegalAccessException {
		  Connection cnx=JDBC.connect();	
			
			try {
				PreparedStatement ps= cnx.prepareStatement("delete from produit where nomPro='"+nom+"'");
				ps.executeUpdate();
				ps.close();
				System.out.println("produit supprimee!!");
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}
	  }
	  
	  //get produits from family
	  
		public static ArrayList<Produit> getProduitsFromFam(int id) throws InstantiationException, IllegalAccessException {		
			Connection cnx=JDBC.connect();	
		    
			ArrayList<Produit> prod=new ArrayList<Produit>();
	 		String query="Select * from produit where famPro='"+id+"'";
	 		System.out.println(query);
		   int i=0;
		   Produit pr;
		   try {
				Statement stm=JDBC.connect().createStatement();
				ResultSet rs=stm.executeQuery(query);
				while(rs.next()) {
					double prix=rs.getDouble(2);	
					int numprod=rs.getInt(1);
					String nom=rs.getString(3);
					Blob blob=rs.getBlob("photoPro");
					int famPro=rs.getInt(4);

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
		  			
		  		pr=new Produit(numprod,prix,base64Image,nom,famPro) ;
				prod.add(pr);
					System.out.println(prod.get(i).getNomProduit());
					System.out.println(prod.get(i).getPuProduit());
					i++;
				}
		}
		   catch (SQLException e) {
				
				e.printStackTrace();

	}
		   return prod;
		}
	  
		
		  public static int getIdProduit(String nom) throws InstantiationException, IllegalAccessException {
			  Connection cnx=JDBC.connect();	
				
				ArrayList<Produit> pro=new ArrayList<Produit>();
				String query="Select numPro from produit where nomPro='"+nom+"'";
				System.out.println(query);
				int id=0;
				try {
		  			Statement stm=JDBC.connect().createStatement();
		  			ResultSet rs=stm.executeQuery(query);
		  			while(rs.next()) {
		  				id=rs.getInt(1);
		  				System.out.println("recup");
		  				System.out.println("id ---------->"+id);
		  			}
				
			  }catch (SQLException e) {
					 e.printStackTrace();
				}
				return id;
				}
		  
		  public static Produit getProduit(String nom) throws InstantiationException, IllegalAccessException {
			  Connection cnx=JDBC.connect();	
				
				Produit pro=new Produit();
				String query="Select * from produit where nomPro='"+nom+"'";
				System.out.println(query);
				int id=0;
				double pu=0;
				String nmPro="";
				
				try {
		  			Statement stm=JDBC.connect().createStatement();
		  			ResultSet rs=stm.executeQuery(query);
		  			while(rs.next()) {
		  				id=rs.getInt(1);
		  				pu=rs.getDouble(2);
		  				nmPro=rs.getString(3);
		  				pro.setNomProduit(nmPro);
		  				pro.setPuProduit(pu);
		  				
		  				System.out.println("recup");
		  				System.out.println("id ---------->"+id);
		  			}
				
			  }catch (SQLException e) {
					 e.printStackTrace();
				}
				return pro;
				}
		  
		  
		  public static void modifyProduct(Produit c,String nom,double prix ) {
		    	 try {
		    		 PreparedStatement ps=JDBC.connect().prepareStatement("Update  Produit Set nomPro='"+nom+"', puPro='"+prix+"' where nomPro='"+c.getNomProduit()+"'");
		    		 ps.executeUpdate();
		    		 
		    	 }catch(Exception e){
		    		 e.printStackTrace();
		
		    	 }
		  }
}
