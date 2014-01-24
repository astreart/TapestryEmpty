package com.musala.tapestry.tutorial.pages;

import java.io.IOException;
import java.util.Date;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

import com.musala.tapestry.tutorial.model.Country;
import com.musala.tapestry.tutorial.model.Gender;
import com.musala.tapestry.tutorial.model.User;

public class Registration {

	@Component
	private Form registrationForm;

	@Component(id = "password")
	private PasswordField passwordField;

	@SessionState
	private User user;

	@Inject
	private Messages messages;

	@Persist
	private String userName;

	@Persist
	private String password;

	private String password2;

	@Persist
	private Gender gender;// = Gender.FEMALE;

	@Persist
	private boolean subscribe;

	@Persist
	private String email;

	@Persist
	private Country country;

	private boolean unsubscribe;

	@Persist
	private double age;

	private Class nextPage;

	// void onSubmitFromRegistrationForm(){
	void onSubmit() {
		System.out.println("The form was submitted!");
	}

	void onValidateFromRegistrationForm() {
		System.out.println("In onValidate.");
			//if (!password.equals(password2)) {
				/*
				 * password = null; registrationForm.recordError(passwordField,
				 * messages.get("passwords-dont-match"));
				 */
			//}
		}
	

	Object onSuccess() {
		System.out.println("In onSuccess.");
		if (unsubscribe)
			subscribe = false;
		return nextPage;
	}

	void onFailure() {
		System.out.println("In onFailure.");
	}

	/*
	 * Object onSubmitFromRegistrationForm() {
	 * System.out.println("The form was submitted!"); if (unsubscribe) subscribe
	 * = false; return nextPage; }
	 */

	// @OnEvent(component="submitButton")
	void onSelectedFromSubmitButton() {
		System.out.println("Submit button was pressed!");
		User newUser = new User("John", "Johnson");
		this.user = newUser;
		nextPage = ShowAll.class;
	}

	// @OnEvent(component="resetButton")
	void onSelectedFromResetButton() {
		System.out.println("Resetting...");
		userName = null;
		password = null;
		email = null;
		gender = null;
		subscribe = false;
		this.country = null;
	}

	public SelectModel getCountries() {
		return new EnumSelectModel(Country.class, messages);
	}

	public Country getCountry() {
		System.out.println("Selected country is: " + country);
		return country;
	}

	public void setCountry(Country country) {
		System.out.println("Set country is: " + country);
		this.country = country;
	}

	public boolean isPasswordNotSubmitted() {
		return userName == null;
	}

	public boolean isUnsubscribe() {
		return unsubscribe;
	}

	public void setUnsubscribe(boolean unsubscribe) {
		this.unsubscribe = unsubscribe;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		System.out.println("Setting subscribe: " + subscribe);
		this.subscribe = subscribe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getMale() {
		return Gender.MALE;
	}

	public Gender getFemale() {
		return Gender.FEMALE;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("Setting user name: " + userName);
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("Setting password: " + password);
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Persist
	private Date dateOfBirth;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}
}
