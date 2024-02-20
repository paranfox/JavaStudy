package edu.java.contact03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// MVC 디자인 패턴에서 View 클래스
// - UI를 담당하는 역활
// * 현재 시스템은 규모가 작으므로 Controller 역활도 수행
public class ContactMain03 {
	private static Scanner sc;
	private static ContactDAO dao; // ContactDAOImple 인스턴스를 저장할 변수

	public static void main(String[] args) {

		System.out.println("연락처 등록 메뉴");
		sc = new Scanner(System.in);

		dao = ContactDAOImple.getInstance(); // 다형성. 싱글톤 인스턴스 생성

		boolean run = true;
		while (run) {
			showMainMenu();
			try {
				int choice = sc.nextInt();
				switch (choice) {
				case Menu.INSERT:
					InsertMember();
					break;
				case Menu.SELECT_ALL:
					selectAll();
					break;
				case Menu.SELECT_BY_INDEX:
					selectByIndax();
					break;
				case Menu.UPDATE:
					updateMember();
					break;
				case Menu.DELETE:
					deleteMamber();
					break;
				case Menu.QUIT:
					sc.close();
					run = false;
					break;
				default:
					System.out.println("다시 선택하세요.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("올바른 선택이 아닙니다. 숫자를 입력하세요.");
				sc.next(); // Clear the invalid input
			} catch (Exception e) {
				System.out.println("오류가 발생했습니다: " + e.getMessage());
			}

		}

	} // end main()

	private static void deleteMamber() {
		System.out.println("검색할 인덱스 입력>");
		int index = sc.nextInt();

		int count = ((ContactDAOImple) dao).getCount();
		if (index >= 0 && index < count) {
			int result = dao.delete(index);
			if (result == 1) {
				System.out.println("연락처 정보 삭제 완료");
			}
		} else {
			System.out.println("존재하지 않는 인덱스입니다.");
		}
	} // end deleteMamber()

	private static void updateMember() {
		System.out.println("인덱스 입력>");
		int index = sc.nextInt();

		int count = ((ContactDAOImple) dao).getCount();
		if (index >= 0 && index < count) {
			System.out.println("전화번호 입력>");
			String phone = sc.next();

			System.out.println("이메일 입력>");
			String email = sc.next();

			ContactDTO dto = new ContactDTO("", phone, email);
			int result = dao.update(index, dto);
			if (result == 1) {
				System.out.println("연락처 정보 수정 완료");
			}

		}
	} // end updateMember()

	private static void selectByIndax() {
		System.out.println("검색할 인덱스 입력>");
		int index = sc.nextInt();

		int count = ((ContactDAOImple) dao).getCount();
		if (index >= 0 && index < count) {
			ContactDTO dto = dao.select(index);
			System.out.println(dto);
		} else {
			System.out.println("존재하지 않는 인덱스입니다.");
		}
	} // end selectByIndax()

	private static void selectAll() {
		ArrayList<ContactDTO> list = dao.select();

		int count = ((ContactDAOImple) dao).getCount();
		for (int i = 0; i < count; i++) {
			System.out.println("연락처 정보 [" + i + "]");
			System.out.println(list.get(i));
		}

	} // end selectAll()

	private static void InsertMember() {
		System.out.println("--- 연락처 정보 등록 ---");
		System.out.println("이름 입력>");
		String name = sc.next();
		System.out.println("전화번호 입력>");
		String phone = sc.next();
		System.out.println("이메일 입력>");
		String email = sc.next();

		ContactDTO dto = new ContactDTO(name, phone, email);
		dao.insert(dto);

	} // end InsertMember()

	private static void showMainMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체 검색 | 3. 상세 검색 | 4. 수정 | 5.삭제 | 0. 종료");
		System.out.println("------------------------------------------------");
		System.out.println("선택>");

	} // end showMainMenu()

} // end MemberMain
