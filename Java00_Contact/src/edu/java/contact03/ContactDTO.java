package edu.java.contact03;

public class ContactDTO {
	// 멤버 변수(필드, 프로퍼티)
	private String name; // 이름
	private String phone; // 연락처
	private String email; // 이메일

	public ContactDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactDTO(String name, String phone, String email) {
		super();
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

	@Override
	public String toString() {
		return "MemberVO [name="+ name +"phone=" + phone + ", email=" + email + "]";
	}

}
