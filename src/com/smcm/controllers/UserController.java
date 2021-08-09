package com.smcm.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.smcm.models.User;

public class UserController {
	public List<User> getAllUsers() {

		List<User> userList = null;
		try {
			//File file = new File("Users.dat");
			File file = new File("Yee.dat");
			if (!file.exists()) {
				User user = new User(1, "Mahesh", "Teacher", "", "");
				userList = new ArrayList<User>();
				userList.add(user);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				userList = (List<User>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public List<User> getUserById(int userId) {
		User user = new User(1, "13circle97@gmail.com", "password", "name", "position");
		List<User> list = new ArrayList<>();
		list.add(user);
		return list;
	}
}
