package com.smcm;

import java.sql.*;

public class DBConn {
	public DBConn() {
		try {
			Class.forName ("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection(
				"jdbc:mariadb://127.0.0.1:33060/test",
				"root",
				"1234");
			con.close();
			System.out.println("Successfully connected to DB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
