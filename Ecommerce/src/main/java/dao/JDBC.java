package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	private static Connection connection;
	
	static String url="jdbc:mysql://localhost:3306/ecom";
	static String user="root";
	static String password="idriss2001";
	
	

public static Connection connect() throws InstantiationException, IllegalAccessException {
	Connection connection = null;
	try {
		System.out.println("connexion établie !!!");
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("connexion établie !!!");
		connection=DriverManager.getConnection(url,user,password);
		System.out.println("connexion établie !!!");
	} 
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}	
	
	return connection;
	
}
}
