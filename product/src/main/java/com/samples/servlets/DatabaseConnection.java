package com.samples.servlets;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	static Connection con=null;
	public static Connection getMyConnection() {
		try{  
			//step1 load the driver class  
			Class.forName("com.mysql.cj.jdbc.Driver");  //com.mysl.jdbc.driver //com.mysql.cj.jdbc.Driver  //oracle.jdbc.driver.OracleDriver
			 
			//step2 create  the connection object 
			 
		con=DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Caravind@9750");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return con;
		
		}

}