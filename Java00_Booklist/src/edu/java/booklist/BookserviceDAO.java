package edu.java.booklist;

import java.util.ArrayList;

public interface BookserviceDAO { //도서 대여/관리 기능 메서드 정의
//	BookserviceDAO.java
//	: DAO Implement 클래스. 도서 대여/관리 기능 메서드 구현
//	 DB에 접근하여 데이터 등록/검색/수정/삭제 수행
	// 도서 대여 상태
	public abstract BooklistVO bookinoutselect(int index);
	
	// 도서 대여 시간
	public abstract BooklistVO bookouttime(int index);
	
	// 도서 반납 시간
	public abstract BooklistVO bookintime(int index);
	
	// 도서 대여 회원 찾기
	public abstract int bookoutuser(int index);
	
	// 도서 전체 정보
	public abstract ArrayList<BookTableVO> bookallselect();
	
	// 도서명과 회원명으로 정보 찾기 
	public abstract ArrayList<BookTableVO> searchbookusername(String serch);
	
	// 도서명으로 정보 찾기
	public abstract ArrayList<BookTableVO> searchbookname(String serch);
	
	// 회원명으로 정보 찾기
	public abstract ArrayList<BookTableVO> searchusername(String serch);
	
		
} // end BookserviceDAO
