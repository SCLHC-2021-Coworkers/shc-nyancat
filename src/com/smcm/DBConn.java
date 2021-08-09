package com.smcm;

import java.sql.*;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBConn {
	private static BasicDataSource ds = new BasicDataSource();

	public static void initPool() {
		try {
			ds.setDriverClassName("org.mariadb.jdbc.Driver");
			ds.setUrl(PropertyReader.dbUrl());
			ds.setUsername(PropertyReader.dbUser());
			ds.setPassword(PropertyReader.dbPassword());
			ds.setMinIdle(100);
			ds.setMaxIdle(1000);
			if (PropertyReader.isDev()) {
				System.out.println("Successfully connected to DB");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}
}
