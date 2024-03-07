package edu.java.booklist;

public class UserVO {
	private int usercode; 		// 유저 인덱스
	private String userId; 		// 유저 아이디
	private String userpassword;// 유저 비밀번호
	private String username;	// 유저 이름
	private String userphone;	// 유저 전화번호
	private String useremail; 	// 유저 이메일
	private String usergenser; 	// 유저 성별
	private String userbirthdate;// 유저 생년월일
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVO(int usercode, String userId, String userpassword, String username, String userphone, String useremail,
			String usergenser, String userbirthdate) {
		super();
		this.usercode = usercode;
		this.userId = userId;
		this.userpassword = userpassword;
		this.username = username;
		this.userphone = userphone;
		this.useremail = useremail;
		this.usergenser = usergenser;
		this.userbirthdate = userbirthdate;
	}
	public UserVO(String userId, String userpassword, String username) {
		this.userId = userId;
		this.userpassword = userpassword;
		this.username = username;
	}
	public UserVO(String userId, String userpassword) {
		this.userId = userId;
		this.userpassword = userpassword;
	}
	public UserVO(String userpassword) {
		this.userpassword = userpassword;
	}
	public int getUsercode() {
		return usercode;
	}
	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsergenser() {
		return usergenser;
	}
	public void setUsergenser(String usergenser) {
		this.usergenser = usergenser;
	}
	public String getUserbirthdate() {
		return userbirthdate;
	}
	public void setUserbirthdate(String userbirthdate) {
		this.userbirthdate = userbirthdate;
	}
	@Override
	public String toString() {
		return "UserVO [usercode=" + usercode + ", userId=" + userId + ", userpassword=" + userpassword + ", username="
				+ username + ", userphone=" + userphone + ", useremail=" + useremail + ", usergenser=" + usergenser
				+ ", userbirthdate=" + userbirthdate + "]";
	}
	
	
	
}
