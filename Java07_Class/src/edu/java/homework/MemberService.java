package edu.java.homework;

//과제2. 혼자 공부하는 자바 - Chap6. 클래스 : 확인문제 3, 4(페이지 268)
//String id = "hong";
//id.equal;("hong");=>true
public class MemberService {
//	id, password는 주소값이 전송됨
//	id == "hong" : 주소값 비교
//	id.equals("hong") : 실제 데이터 비교
	
	public MemberService() {
		// TODO Auto-generated constructor stub
	} // end MemberService()
	
	public boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		}
		return false;
		
	}
	
	public void logout(String password) {
		System.out.println("로그아웃 되었습니다.");
	}
	
} // end MemberService
