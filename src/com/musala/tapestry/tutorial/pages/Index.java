package com.musala.tapestry.tutorial.pages;

import java.util.Date;
import java.util.Locale;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

import com.musala.tapestry.tutorial.components.DateInput;
import com.musala.tapestry.tutorial.model.User;
import com.musala.tapestry.tutorial.util.CelebritySelectModel;
import com.musala.tapestry.tutorial.util.Security;

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

	private String userName;
	private String password;

	@SessionState
	private User user;

	public User getUser() {
		return user;
	}

	/*@OnEvent(value = "success", component = "loginForm")
	Object showCollection() {
		return ShowAll.class;
	}*/

	Object onSubmitFromLoginForm() {
		Class nextPage = null;
		User authenticatedUser = null;
		authenticatedUser = Security.authenticate(userName, password);
		if (authenticatedUser != null) {
			user = authenticatedUser;
			nextPage = ShowAll.class;
		} else {
			nextPage = Registration.class;
		}
		return nextPage;
	}

	/*
	 * @Component private Form loginForm;
	 * 
	 * @Inject private Messages messages;
	 * 
	 * Object onSuccessFromLoginForm() { return ShowAll.class; }
	 * 
	 * void onValidateFromLoginForm() { User authenticatedUser =
	 * Security.authenticate(userName, password); if (authenticatedUser != null)
	 * { user = authenticatedUser; } else {
	 * loginForm.recordError(messages.get("authentication-failed")); } }
	 */

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * void onSubmitFromUserInputForm(){
	 * System.out.println("Handling from submit, naming convention"); }
	 */

	private boolean userExists;

	public boolean getUserExists() {
		return userExists;
	}

	@Inject
	private Messages messages;

	public String getOrRegisterLabel() {
		return messages.get("or-register");
	}

	private Date theDate;

	public Date getTheDate() {
		return theDate;
	}

	public void setTheDate(Date theDate) {
		this.theDate = theDate;
	}

	public Date getLowerLimit() {
		return new Date();
	}
}