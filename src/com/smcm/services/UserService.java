package com.smcm.services;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.smcm.DBConn;
import com.smcm.controllers.UserController;
import com.smcm.models.User;
@Path("/auth") 

public class UserService {
	@Context
	private ServletContext context;
	
	private UserController userController = new UserController();
	@GET 
	@Path("/users") 
	@Produces(MediaType.APPLICATION_XML) 
	public List<User> getUsers(){
		return userController.getAllUsers();
	}
}
