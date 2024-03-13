package edu.java.booklist;

import java.util.ArrayList;

public interface BookserviceDAO { //도서 대여/관리 기능 메서드 정의 
//	BookserviceDAO.java
//	: DAO Implement 클래스. 도서 대여/관리 기능 메서드 구현
//	 DB에 접근하여 데이터 등록/검색/수정/삭제 수행
	// choice를 사용하여 검색한 결과 값을 가져오기
	public abstract ArrayList<BookTableVO> searchbookchoice(String selectchoice, String serch);
	
	// 도서 대여 상태
	public abstract int bookinoutselect(String bookname);
	
	// 도서 대여 시간
	public abstract BooklistVO bookouttime(int index);
	
	// 도서 반납 시간
	public abstract BooklistVO bookintime(int index);
	
	// 도서 정보 책이름으로 찾기
	public abstract BookTableVO searchallbookname(String bookname);
	
	// 도서 대여 회원 찾기
	public abstract int bookoutuser(int index);
	
	// 도서 전체 정보(회원명)
	public abstract ArrayList<BookTableVO> bookallselect();
	
	// 도서 전체 정보(저자명)
	public abstract ArrayList<BookTableVO> bookallselectwriter(String userid);
	
	// 도서명과 회원명으로 정보 찾기 
	public abstract ArrayList<BookTableVO> searchbookusername(String serch);
	
	// 도서명으로 정보 찾기
	public abstract ArrayList<BookTableVO> searchbookname(String serch);
	
	// 회원명으로 정보 찾기
	public abstract ArrayList<BookTableVO> searchusername(String serch);
	
		
} // end BookserviceDAO
