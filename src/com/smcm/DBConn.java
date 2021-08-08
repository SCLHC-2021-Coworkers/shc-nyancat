package com.smcm;

import java.sql.*;

public class DBConn {
	public DBConn() {
		try {
			Class.forName ("org.mariadb.jdbc.Driver");
			String dbHost = System.getenv("DB_HOST");
			String dbPort = System.getenv("DB_PORT");
			String dbName = System.getenv("DB_NAME");
			String dbUser = System.getenv("DB_USER");
			String dbPassword = System.getenv("DB_PASSWORD");
			Connection con = DriverManager.getConnection(
				String.format("jdbc:mariadb://%s:%s/%s", dbHost, dbPort, dbName),
				dbUser,
				dbPassword);
			con.close();
			System.out.println("Successfully connected to DB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
