package model;

public class Account {
	private String userMail, password;
	private int role;
	private String name, address, phone;

	public Account(String userMail, String password, int role, String name, String address, String phone) {
		this.userMail = userMail;
		this.password = password;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	

	public Account(String userMail) {
		this.userMail = userMail;
	}



	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
