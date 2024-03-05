package edu.java.booklist;

import java.util.ArrayList;

public interface AdminDAO {
	// 관리자 로그인
	public abstract int login(AdminVO vo);
	
	// 관리자 로그아웃
	public abstract int Logout(AdminVO vo);
	
	// 관리자 정보 검색
	public abstract ArrayList<AdminVO> adminselect();
	
	// 관리자 정보 수정
	public abstract int adminUpdate(AdminVO vo);
	
	// 관리자 도서 추가
	public abstract int bookinsert(BookslistVO vo);
	
	// 관리자 도서 변경
	public abstract int bookupdate(int index, BookslistVO vo);
	
	// 관리자 도서 삭제
	public abstract int bookdelete(int index);
	
	
} // end AdminDAO
