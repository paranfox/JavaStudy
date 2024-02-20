package edu.java.contact03;

import java.util.ArrayList;

public class ContactDAOImple implements ContactDAO {
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() {
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	// 나중에 DB에서 사용 할 것이지만 지금은 이렇게 사용
	private ArrayList<ContactDTO> list = new ArrayList<>(); // 회원 정보를 저장할 배열

	public int getCount() {
		return list.size();
	}

	@Override
	public int insert(ContactDTO dto) {
		System.out.println("insert()"); // 로그 찍기
		System.out.println("dto = " + dto);
		list.add(dto);
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public ArrayList<ContactDTO> select() {
		return list;
	} // end select()

	@Override
	public ContactDTO select(int index) {
		return list.get(index);
	}

	@Override
	public int update(int index, ContactDTO dto) {
		list.set(index, dto);
		return 1;
	}

	@Override
	public int delete(int index) {
		list.remove(index);
		return 1;
	}

} // end ContactDAOImple
