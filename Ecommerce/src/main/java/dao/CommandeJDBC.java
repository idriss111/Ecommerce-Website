package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Metier.Famille;
import Metier.Produit;

public class CommandeJDBC {
  
	
	public static int saveCommande() throws InstantiationException, IllegalAccessException {		
		int id = 0;
		Connection cnx=JDBC.connect();
		System.out.println("--------------------------------===============");
		 LocalDateTime localDateTime = LocalDateTime.now();
		 System.out.print("daaaaaaaaaaaaaaaaaaateeeeeeee :  "+localDateTime);
		
		 Date sqlDate = Date.valueOf(localDateTime.toLocalDate());
		
		try {
			PreparedStatement ps= cnx.prepareStatement("INSERT INTO commande(dateCde) VALUES(?)");
			ps.setDate(1,sqlDate);
			
			System.out.println(ps);
			ps.executeUpdate();
			ps.close();
			System.out.println("coomande valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
		try {
			Statement stm=JDBC.connect().createStatement();
  			ResultSet rs=stm.executeQuery("Select numCde from commande where dateCde='"+sqlDate+"'");
  			while(rs.next()) {
  				id=rs.getInt(1);
  				System.out.println("recup");
		}}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	
return id;
}
	public static void saveProcde(int a,int b,int c) throws InstantiationException, IllegalAccessException {		
		
		Connection cnx=JDBC.connect();
		
		
		try {
			PreparedStatement ps= cnx.prepareStatement("INSERT INTO procde(numpro,numcde,qte) VALUES(?,?,?)");
			ps.setInt(1, a);ps.setInt(2,b);ps.setInt(3,c);
			
			System.out.println(ps);
			ps.executeUpdate();
			ps.close();
			System.out.println("coomande valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}}
		
		public static void saveCde(int cde,int session) throws InstantiationException, IllegalAccessException {		
			
			Connection cnx=JDBC.connect();
			
			
			try {
				PreparedStatement ps= cnx.prepareStatement("INSERT INTO cdecli(numcde,numcli) VALUES(?,?)");
				ps.setInt(1, cde);ps.setInt(2,session);
				
				System.out.println(ps);
				ps.executeUpdate();
				ps.close();
				System.out.println("coomande valide");
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}

}
		public static  ArrayList<Integer> getnumcli() throws InstantiationException, IllegalAccessException {		
			Connection cnx=JDBC.connect();	
			
			ArrayList<Integer> nums=new ArrayList<Integer>();
			String query="Select numCli from cdecli";
	 		System.out.println(query);
		   int i=0;
		   
		   try {
				Statement stm=JDBC.connect().createStatement();
				ResultSet rs=stm.executeQuery(query);
				while(rs.next()) {	
					int numcli=rs.getInt(1);
					nums.add(numcli);
					i++;
				}
		}
		   catch (SQLException e) {
				
				e.printStackTrace();

	}
		   return nums;
		}
		public static  ArrayList<Integer> getnumcmd() throws InstantiationException, IllegalAccessException {		
			Connection cnx=JDBC.connect();	
			
			ArrayList<Integer> nums=new ArrayList<Integer>();
			String query="Select numcde from cdecli";
	 		System.out.println(query);
		   int i=0;
		   
		   try {
				Statement stm=JDBC.connect().createStatement();
				ResultSet rs=stm.executeQuery(query);
				while(rs.next()) {	
					int numcmd=rs.getInt(1);
					nums.add(numcmd);
					i++;
				}
		}
		   catch (SQLException e) {
				
				e.printStackTrace();

	}
		   return nums;
		}
		public static  ArrayList<Integer> getNumcli() throws InstantiationException, IllegalAccessException {		
			Connection cnx=JDBC.connect();	
			
			ArrayList<Integer> nums=new ArrayList<Integer>();
			String query="Select numCli from cdecli";
	 		System.out.println(query);
		   int i=0;
		   
		   try {
				Statement stm=JDBC.connect().createStatement();
				ResultSet rs=stm.executeQuery(query);
				while(rs.next()) {	
					int numcli=rs.getInt(1);
					nums.add(numcli);
					i++;
				}
		}
		   catch (SQLException e) {
				
				e.printStackTrace();

	}
		   return nums;
		} 
		
		public static  ArrayList<Date> getDate() throws InstantiationException, IllegalAccessException {		
			Connection cnx=JDBC.connect();	
			ArrayList <Integer> cmd=getnumcmd();
			ArrayList <Date> dt= new ArrayList<>();
			for(int i=0;i<cmd.size();i++) {
				 int d=cmd.get(i);
			String query="Select dateCde from commande where numCde='"+d+"'";
	 		System.out.println(query);
	 		
	 		
		   int c=0;
		   
		   try {
				Statement stm=JDBC.connect().createStatement();
				ResultSet rs=stm.executeQuery(query);
				while(rs.next()) {	
					Date date=rs.getDate(1);
					dt.add(date);
					c++;
				}
		}
		   catch (SQLException e) {
				
				e.printStackTrace();

	}
			}
		   return dt;
		}
		public static  ArrayList<String> getNomCli() throws InstantiationException, IllegalAccessException {		
			Connection cnx=JDBC.connect();	
			ArrayList <Integer> cmd=getNumcli();
			ArrayList <String> dt= new ArrayList<>();
			for(int i=0;i<cmd.size();i++) {
				 int d=cmd.get(i);
			String query="Select nomCli from client where numCli='"+d+"'";
	 		System.out.println(query);
	 		
	 		
		   int c=0;
		   
		   try {
				Statement stm=JDBC.connect().createStatement();
				ResultSet rs=stm.executeQuery(query);
				while(rs.next()) {	
					String nom=rs.getString(1);
					dt.add(nom);
					c++;
				}
		}
		   catch (SQLException e) {
				
				e.printStackTrace();

	}
			}
		   return dt;
		}
		public static  ArrayList<String> getAdrCli() throws InstantiationException, IllegalAccessException {		
			Connection cnx=JDBC.connect();	
			ArrayList <Integer> cmd=getNumcli();
			ArrayList <String> dt= new ArrayList<>();
			for(int i=0;i<cmd.size();i++) {
				 int d=cmd.get(i);
			String query="Select adrCli from client where numCli='"+d+"'";
	 		System.out.println(query);
	 		
	 		
		   int c=0;
		   
		   try {
				Statement stm=JDBC.connect().createStatement();
				ResultSet rs=stm.executeQuery(query);
				while(rs.next()) {	
					String nom=rs.getString(1);
					dt.add(nom);
					c++;
				}
		}
		   catch (SQLException e) {
				
				e.printStackTrace();

	}
			}
		   return dt;
		}
		
		
		
}