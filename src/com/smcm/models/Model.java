package com.smcm.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smcm.DBConn;
import com.smcm.PropertyReader;

public class Model {
	public static String getDbName() {
		String[] dbUrlStrs = PropertyReader.dbUrl().split("/");
		return dbUrlStrs[dbUrlStrs.length - 1];
	}

	public static boolean isTableExists(String tableName) {
		Connection con = DBConn.getConnection();
		String sql = String
				.format("SELECT table_name FROM information_schema.tables "
						+ "WHERE table_schema = '%s' AND table_name = '%s' LIMIT 1",
						getDbName(), tableName);
		PreparedStatement pstmt;
		ResultSet rs;
		boolean ret;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ret = rs.next();
		} catch (SQLException e) {
			ret = false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		return ret;
	}

	public static void dropTable(String tableName) {
		Connection con = DBConn.getConnection();
		String sql = "DROP TABLE IF EXISTS " + tableName + " CASCADE";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
		} catch (SQLException e) {
		}
	}

	public static void initTable(String tableName, String sql) {
		Connection con = DBConn.getConnection();
		PreparedStatement pstmt;
		try {
			if (isTableExists(tableName)) {
				System.out.println(tableName + " table already exists");
				if (PropertyReader.isDev()) {
					System.out.println("Drop " + tableName
							+ " table (Development mode)");
					dropTable(tableName);
				}
			}
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			if (PropertyReader.isDev()) {
				System.out.println(tableName
						+ " table updated (Development mode)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
