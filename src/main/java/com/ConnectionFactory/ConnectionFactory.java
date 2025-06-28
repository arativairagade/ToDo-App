package com.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

		public static Connection con;
		public static Connection getCon() {
			try {
				
				//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//db info
				String url="jdbc:mysql://localhost:3306/mydatabase";
				String username="root";
				String password="";
				
				//getting connection
				con =DriverManager.getConnection(url, username, password);
				
							
			}catch(Exception e) {
				System.out.println(e);
			}
			finally {
				return con;
			}
			
			
		}



}
