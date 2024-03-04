package edu.java.jdbc03;

public class ContactVO {
	private int contactID;
	private String name;
	private String phone;
	private String email;
	public ContactVO() { }
	public ContactVO(int contactID, String name, String phone, String email) {
		super();
		this.contactID = contactID;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	@Override
	public String toString() {
		return "ContactVO [contactID=" + contactID + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
