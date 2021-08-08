package com.smcm.models;

public class Model {
	private final String dbName;

	public Model() {
		this.dbName = System.getenv("DB_NAME");
	}

	public boolean isTableExists(String tableName) {
		return true;
	}
}
