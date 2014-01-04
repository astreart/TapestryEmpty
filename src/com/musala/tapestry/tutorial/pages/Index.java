package com.musala.tapestry.tutorial.pages;

import java.util.Date;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;

import com.musala.tapestry.tutorial.util.User;

public class Index {
	public String getMyProperty() {
		return "property from backend";
	}

	public Date getCurrentDate() {
		return new Date();
	}

	public String getCurrentTime() {
		Date date = new Date();
		String message = ". Tapestry is cool!";
		return date + message;
	}

	private int someValue = 12345;

	public void setSomeValue(int value) {
		this.someValue = value;
	}

	public int getSomeValue() {
		return someValue;
	}

	private String message = "initial message";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("Setting the message: " + message);
		this.message = message;
	}

	@InjectPage
	private Another another;

	@OnEvent(value = "submit", component = "userInputForm")
	Object onFormSubmit() {

		String[] words = message.split(" ");

		System.out.println("Words length: " + words.length);

		if (words.length > 0) {
			user.setFirstName(words[0]);
			if (words.length > 1) {
				user.setLastName(words[1]);
			}
		}
		another.setPassedMessage(message);
		return another;
	}

	@SessionState
	private User user;

	public User getUser() {
		return user;
	}

	/*
	 * void onSubmitFromUserInputForm(){
	 * System.out.println("Handling from submit, naming convention"); }
	 */

	private boolean userExists;

	public boolean getUserExists() {
		return userExists;
	}

}