package com.training.bean;

public class LoginBean {
	private String myEmail;
	private String firstName;
	private String lastName;

	public LoginBean() {
	}

	public LoginBean(String myEmail, String firstName, String lastName) {
		super();
		this.myEmail = myEmail;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/*
	 * public String getEmail() { return myEmail; }
	 */

	public void setMyEmail(String myEmail) {
		this.myEmail = myEmail;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "LoginBean [email=" + myEmail + ", firstname=" + firstName + ", lastname="+lastName;
	}

}
