package com.project.facebook.util;
import java.sql.*;
public class ConnectionUtil {

	private static Connection conn = null;
	
	private ConnectionUtil() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		
		if (conn == null) {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/facebook", "username", "password");
		}
		return conn;
	}
}
