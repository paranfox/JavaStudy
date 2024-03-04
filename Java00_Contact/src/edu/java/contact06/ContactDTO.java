package edu.java.contact06;

import java.io.Serializable;

public class ContactDTO implements Serializable{
	// 멤버 변수(필드, 프로퍼티)
	private int index;
	private String name; // 이름
	private String phone; // 연락처
	private String email; // 이메일

	public ContactDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactDTO(int index, String name, String phone, String email) {
		super();
		this.index = index;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Contact [NO = " + index + ", name = "+ name +", phone = " + phone + ", email = " + email + "]";
	}

}
