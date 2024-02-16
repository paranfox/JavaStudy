package edu.java.interface06;

import java.util.Scanner;

// MVC 디자인 패턴에서 View 클래스
// - UI를 담당하는 역활
// * 현재 시스템은 규모가 작으므로 Controller 역활도 수행
public class MemberMain {
	private static Scanner sc;
	private static MemberDAO dao; // MemeberDAOImple 인스턴스를 저장할 변수

	public static void main(String[] args) {

		System.out.println("회원 관리 프로그램");
		sc = new Scanner(System.in);

		dao = MemberDAOImple.getInstance(); // 다형성. 싱글톤 인스턴스 생성

		boolean run = true;
		while (run) {
			showMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case Menu.INSERT:
				InsertMember();
				break;
			case Menu.SELECT_ALL:
				selectAll();
				break;
			case Menu.SELECT_BY_INDEX:
				break;
			case Menu.UPDATE:
				break;
			case Menu.QUIT:
				break;
			default:
				System.out.println("다시 선택하세요.");
				break;
			}
		}

	} // end main()

	private static void selectAll() {
		MemberVO[] list = dao.select();
		
		int count = ((MemberDAOImple)dao).getCount();
	} // end selectAll()

	private static void InsertMember() {
		System.out.println("--- 회원 정보 등록 ---");
		System.out.println("아이디 입력>");
		String id = sc.next();
		System.out.println("비밀번호 입력>");
		String pw = sc.next();
		System.out.println("이메일 입력>");
		String email = sc.next();
		
		MemberVO vo = new MemberVO(id, pw, email);
		dao.insert(vo);
		
		
	} // end InsertMember()

	private static void showMainMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체 검색 | 3. 상세 검색 | 4. 수정 | 0. 종료");
		System.out.println("------------------------------------------------");
		System.out.println("선택>");

	} // end showMainMenu()

} // end MemberMain
