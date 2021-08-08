package com.smcm;

import java.sql.*;

public class DBConn {
	public DBConn() {
		try {
			Class.forName ("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(
				"jdbc:mariadb://127.0.0.1:3306/test",
				"root",
				"Dodge4college!");
			con.close();
			System.out.println("Successfully connected to DB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
