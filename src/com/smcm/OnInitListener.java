package com.smcm;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OnInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		PropertyReader.load();
		DBConn dbConn = new DBConn();
	}

}
