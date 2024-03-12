package edu.java.booklist;

public class AdminVO {
		// 멤버 변수(필드, 프로퍼티)
		private int admincode; // 관리자 인덱스
		private String adminId; // 관리자 아이디
		private String adminpassword; // 관리자 비밀번호
		public AdminVO() { 
			super();
			// TODO Auto-generated constructor stub
		}
		public AdminVO(int admincode, String adminId, String adminpassword) {
			super();
			this.admincode = admincode;
			this.adminId = adminId;
			this.adminpassword = adminpassword;
		}
		public AdminVO(String adminId, String adminpassword) {
			this.adminId = adminId;
			this.adminpassword = adminpassword;
		}
		public int getAdmincode() {
			return admincode;
		}
		public void setAdmincode(int admincode) {
			this.admincode = admincode;
		}
		public String getAdminId() {
			return adminId;
		}
		public void setAdminId(String adminId) {
			this.adminId = adminId;
		}
		public String getAdminpassword() {
			return adminpassword;
		}
		public void setAdminpassword(String adminpassword) {
			this.adminpassword = adminpassword;
		}
		@Override
		public String toString() {
			return "AdminVO [admincode=" + admincode + ", adminId=" + adminId + ", adminpassword=" + adminpassword
					+ "]";
		}
		
		
		

} // end AdminVO