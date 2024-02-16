package edu.java.contact02;

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
	private final int MAX = 100; // 최대 회원수
	private ContactDTO[] list = new ContactDTO[MAX]; // 회원 정보를 저장할 배열
	private int count; // 배열에 저장될 데이터 개수

	public int getCount() {
		return count;
	}

	@Override
	public int insert(ContactDTO dto) {
		System.out.println("insert()"); // 로그 찍기
		System.out.println("dto = " + dto);
		list[count] = dto;
		count++;
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public ContactDTO[] select() {
		return list;
	} // end select()

	@Override
	public ContactDTO select(int index) {
		return list[index];
	}

	@Override
	public int update(int index, ContactDTO dto) {
		list[index].setPhone(dto.getPhone());
		list[index].setEmail(dto.getEmail());
		return 1;
	}

} // end ContactDAOImple
