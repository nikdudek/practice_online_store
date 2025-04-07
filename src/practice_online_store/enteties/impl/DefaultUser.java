package practice_online_store.enteties.impl;

import java.io.Serializable;

import practice_online_store.enteties.User;

public class DefaultUser implements User, Serializable {

	private static final long serialVersionUID = 1L;

	private static int userCounter = 0;

	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	
	{
		id = ++userCounter;
	}
	
	public DefaultUser() {
	}
	
	public DefaultUser(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}
	
	public DefaultUser(Integer id, String firstName, String lastName, String password, String email) {
		this.id = id;
		userCounter--;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public String toString() {
		return "First Name: " + this.getFirstName() + "\t\t" + "Last Name: " + this.getLastName() + "\t\t" + "Email: " + this.getEmail();
	}

	@Override
	public void setPassword(String password) {
		if (password == null) {
			return;
		}
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		if (newEmail == null) {
			return;
		}
		this.email = newEmail;
	}

	@Override
	public int getId() {
		return this.id;
	}
	
	void clearState() {
		userCounter = 0;
	}
}
