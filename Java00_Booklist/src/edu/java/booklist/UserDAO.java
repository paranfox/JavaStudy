package edu.java.booklist;

import java.util.ArrayList;

public interface UserDAO {
//	UserDAO.java : DAO Interface. 유저 관리 기능 메서드 정의
//	UserDAOImple.java
//	: DAO Implement 클래스. 유저 관리 기능 메서드 구현
//	 DB에 접근하여 데이터 등록/검색/수정/삭제 수행
	// 유저 정보 추가
	public abstract int userinsert(UserVO vo);
	
	// 유저 로그인 확인
	public abstract int usercheck(UserVO vo);
	
	// 유저 정보 검색
	public abstract UserVO userselect();
	
	// 유저 정보 수정
	public abstract int userupdate(int index, UserVO vo);
	
	// 유저 정보 삭제
	public abstract int userdelete(int index);
	
	// 유저 전체 대여 상황
	public abstract ArrayList<BooklistVO> userbookallselect();
	
	
} // end UserDAO
