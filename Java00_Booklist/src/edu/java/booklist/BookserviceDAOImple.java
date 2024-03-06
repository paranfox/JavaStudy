package edu.java.booklist;

import java.util.ArrayList;

public class BookserviceDAOImple implements BookserviceDAO {
	// 1. private static 자기 자신 타입의 변수 선언
	private static BookserviceDAOImple instance = null;

	// 2. private 생성자
	private BookserviceDAOImple() {
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static BookserviceDAOImple getInstance() {
		if (instance == null) {
			instance = new BookserviceDAOImple();
		}
		return instance;
	}

	@Override
	public BooklistVO bookinoutselect(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooklistVO bookouttime(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooklistVO bookintime(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int bookoutuser(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<BooklistVO> bookallselect() {
		// TODO Auto-generated method stub
		return null;
	}

}
