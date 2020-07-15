package com.training.bean;

public class UserdetailsBean {
	private String firstName;
	private String lastName;
	private String eMail;
	private String phone;
	private String login;
	private String password;
	private String profile;
	
	public UserdetailsBean() {
	}

	public UserdetailsBean( String firstName, String lastName, String eMail, String phone,String password, String login, String profile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.phone = phone;
		this.login = login;
		this.password = password;
		this.profile = profile;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getEmail() {
		return eMail;
	}

	public void setEmail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return "UserdetailsBean [firstName=" + firstName + ", lastName ="+lastName+",email="+eMail+",phone="+phone+",login="+login+", password=" + password + ",profile="+profile+"]";
	}

}
