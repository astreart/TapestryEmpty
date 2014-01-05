package com.musala.tapestry.tutorial.util;

import com.musala.tapestry.tutorial.model.User;

public class Security {

	private static final String USERNAME = "user";
	private static final String PASSWORD = "secret";

	public static User authenticate(String userName, String password) {
		if (USERNAME.equals(userName) && PASSWORD.equals(password)) {
			return new User("John", "Smith");
		}
		return null;
	}
}
