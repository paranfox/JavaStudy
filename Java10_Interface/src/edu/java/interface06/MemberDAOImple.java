package edu.java.interface06;

// DAO(Data Access Object) :
// - 데이터의 전송을 담당하는 역활
public class MemberDAOImple implements MemberDAO {

	// 싱글톤 디자인 패턴 적용

	// 1. private static 자기 자신 타입의 변수 선언
	private static MemberDAOImple instance = null;

	// 2. private 생성자
	private MemberDAOImple() {
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static MemberDAOImple getInstance() {
		if (instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}
	// 나중에 DB에서 사용 할 것이지만 지금은 이렇게 사용
	private final int MAX = 100; // 최대 회원수
	private MemberVO[] list = new MemberVO[MAX]; // 회원 정보를 저장할 배열
	private int count; // 배열에 저장될 데이터 개수
	
	public int getCount() {
		return count;
	}
	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert()"); // 로그 찍기
		System.out.println("vo = " + vo);
		list[count] = vo;
		count++;
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public MemberVO[] select() {
		return list;
	} // end select()

	@Override
	public MemberVO select(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int index, MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
