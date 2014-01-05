package com.musala.tapestry.tutorial.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;

import com.musala.tapestry.tutorial.model.User;


public class Another {
	private String passedMessage;

	public String getPassedMessage() {
		return passedMessage;
	}

	public void setPassedMessage(String passedMessage) {
		this.passedMessage = passedMessage;
	}

	void onActivate(String message) {
		System.out.println("Another page is activated! The message is: "
				+ message);
		this.passedMessage = message;
	}

	String onPassivate() {
		System.out.println("Another page is passivated...");
		return passedMessage;
	}

	@SessionState
	private User myUser;

	public User getMyUser() {
		return myUser;
	}
}
