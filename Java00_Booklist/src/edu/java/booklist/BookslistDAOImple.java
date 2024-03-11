package edu.java.booklist;

import java.util.ArrayList;

public class BookslistDAOImple implements BooklistDAO {
	// 1. private static 자기 자신 타입의 변수 선언
	private static BookslistDAOImple instance = null;

	// 2. private 생성자
	private BookslistDAOImple() { 
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static BookslistDAOImple getInstance() {
		if (instance == null) {
			instance = new BookslistDAOImple();
		}
		return instance;
	}

	@Override
	public ArrayList<AdminVO> bookselect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooklistVO bookselect(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
