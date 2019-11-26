package com.ssi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	public static Connection connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wpdata","root","root");
		return con;
	}
	
}
