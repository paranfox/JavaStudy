package edu.java.contact01;

import java.util.*;

public class ContactMain01 {
	public static final int MENU_QUIT = 0; // 종료
	public static final int MENU_INSERT = 1; // 등록
	public static final int MENU_SELECT_ALL = 2; // 전체검색
	public static final int MENU_SELECT = 3; // 상세검색
	public static final int MENU_UPDATE = 4; // 수정
	public static final int MENU_DELETE = 5; // 삭제

	public static final int MAX = 100; // 연락처 최대 저장 개수
	// 연락처 저장 배열
	public static Contact[] contactList = new Contact[MAX];
	public static int count = 0; // 배열에 데이터를 저장하면 증가

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String name, phone, email;
		boolean run = true;
		while (run) {
			System.out.println("------------------------------------------------");
			System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 삭제 | 0. 종료");
			System.out.println("------------------------------------------------");
			System.out.println("선택>");
			int result = sc.nextInt();
			switch (result) {
			case MENU_QUIT:
				run = false;
				break;
			case MENU_INSERT:

				System.out.println("-------------");
				System.out.println("연락처 등록 메뉴");
				System.out.println("-------------");
				System.out.println("이름 입력>");
				name = sc.next();
				

				 
				
				System.out.println("전화번호 입력>");
				phone = sc.next();

				System.out.println("이메일 입력>");
				email = sc.next();
				contactList[count] = new Contact(name, phone, email);
				count++;
				System.out.println("등록된 연락처 개수 : " + count);
				System.out.println("연락처 등록 완료!");
				break;
			case MENU_SELECT_ALL:
				System.out.println("연락처 개수 : " + count);
				for (int i = 0; i < count; i++) {
					System.out.println("--- 연락처 " + i + " ---");
					System.out.println(contactList[i].toString());
				}
				break;
			case MENU_SELECT:
				System.out.println("-------------");
				System.out.println("검색할 인덱스 입력>");
				int i = sc.nextInt();
				System.out.println(contactList[i].toString());

				break;
			case MENU_UPDATE:
				System.out.println("-------------");
				System.out.println("수정할 인덱스 입력>");
				i = sc.nextInt();
				System.out.println("이름 입력>");
				name = sc.next();

				System.out.println("전화번호 입력>");
				phone = sc.next();

				System.out.println("이메일 입력>");
				email = sc.next();
				contactList[i] = new Contact(name, phone, email);
				System.out.println("연락처 수정 완료!");

				break;
			case MENU_DELETE:
				System.out.println("-------------");
				System.out.println("삭제할 인덱스 입력>");
				i = sc.nextInt();
				name = "";
				phone = "";
				email = "";
				contactList[i] = new Contact(name, phone, email);
				System.out.println("삭제 완료");

				break;
			default:
				break;
			} //end switch

		} // end while

	} // end main();

} // end ContactMain01
