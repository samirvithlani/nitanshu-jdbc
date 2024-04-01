package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 1)loading driver class
 * 2)getting connection with DB
 * 3)prepare Query
 * 4)create statement 
 * 5)submit query
 * 6)getting result set
 * 
 * 7) optional: Transaction management
 * */
public class DBConnection {

	private static String userName = "root";
	private static String password = "root";
	private static String driverClass = "com.mysql.jdbc.Driver"; // jar..
	private static String connectionURl = "jdbc:mysql://localhost:3306/nitanshu";

	public static Connection getDBConnection() {

		// loading driver class --> create an appropriate object of driver class
		Connection conn = null;
		try {
			Class.forName(driverClass); // loading driver class

			// getting connection with database....

			conn = DriverManager.getConnection(connectionURl, userName, password);
			if (conn != null) {
				System.out.println("connected with database...");
			} else {

				System.out.println("not connected with database...");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}
	
	public static void main(String[] args) {
		
		DBConnection.getDBConnection();
		
		
	}

}
