package com.smcm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

public class PropertyReader {
	private static Properties props = new Properties();

	public static void load(ServletContext sc) {
		try {
			props.load(sc.getResourceAsStream("/META-INF/env.properties"));
			System.out.println("env.properties loaded successfully");
		} catch (FileNotFoundException e) {
			System.out.println("env.properties file does not exist");
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Cannot read env.properties file");
			System.exit(-1);
		}
	}

	public static String dbUrl() {
		return props.getProperty("db.url");
	}

	public static String dbUser() {
		return props.getProperty("db.user");
	}

	public static String dbPassword() {
		return props.getProperty("db.password");
	}
}
