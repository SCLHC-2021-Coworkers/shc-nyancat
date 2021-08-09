package com.smcm;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.smcm.models.User;

public class OnInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		PropertyReader.load(sce.getServletContext());
		DBConn.initPool();
		User.init();
		System.out.println("Server started");
	}

}
