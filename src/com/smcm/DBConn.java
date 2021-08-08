package com.smcm;

import java.sql.*;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBConn {
	private Connection con;
	private BasicDataSource ds;

	public DBConn() {
		this.con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			ds = new BasicDataSource();
			ds.setDriverClassName(PropertyReader.dbDriverClassName());
			ds.setUrl(PropertyReader.dbUrl());
			ds.setUsername(PropertyReader.dbUser());
			ds.setPassword(PropertyReader.dbPassword());
			ds.setMinIdle(100);
			ds.setMaxIdle(1000);

			con = ds.getConnection();

			pstmt = con.prepareStatement("SHOW DATABASES");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			con.close();
			System.out.println("Successfully connected to DB");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
