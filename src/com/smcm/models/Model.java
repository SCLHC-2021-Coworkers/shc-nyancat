package com.smcm.models;

import com.smcm.PropertyReader;

public class Model {
	private final String dbName;

	public Model() {
		String[] urlStrs = PropertyReader.dbUrl().split("/");
		this.dbName = urlStrs[urlStrs.length - 1];
		System.out.println(this.dbName);
	}

	public boolean isTableExists(String tableName) {
		return true;
	}
}
