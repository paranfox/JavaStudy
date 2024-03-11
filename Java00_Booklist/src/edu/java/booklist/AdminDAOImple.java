package edu.java.booklist;

import java.util.ArrayList;

public class AdminDAOImple implements AdminDAO { 
	// 1. private static 자기 자신 타입의 변수 선언
	private static AdminDAOImple instance = null;

	// 2. private 생성자
	private AdminDAOImple() {
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static AdminDAOImple getInstance() {
		if (instance == null) {
			instance = new AdminDAOImple();
		}
		return instance;
	}

	@Override
	public int login(AdminVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Logout(AdminVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AdminVO adminselect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminUpdate(AdminVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bookinsert(BooklistVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bookupdate(int index, BooklistVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bookdelete(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<UserVO> adminuserallselect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminuserdelete(int index, UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
