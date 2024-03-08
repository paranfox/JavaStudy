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
	
		
} // end BookserviceDAO
