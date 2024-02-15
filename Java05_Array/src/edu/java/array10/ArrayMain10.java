package edu.java.array10;

import java.util.*;

public class ArrayMain10 {

	public static void main(String[] args) {
		System.out.println("<학생 점수 관리 프로그램>");
		// 학생 점수를 저장하는 변수

		// 변수 명명 규칙
		// 1. 첫 번째 글자는 문자이거나, '$', '_' 이어야 하고 숫자로 시작할 수 없다.(필수)
		// 2. 영어 대소문자가 구분된다. (필수)
		// 3. 첫 문자는 영어 소문자로 시작하되, //{카멜케이스(낙타)
		// 다른 단어가 붙을 경우 첫 문자를 대문자로 한다. (관례)
		// 4. 문자 수(길이)의 제한은 없다.
		// 5. 자바 예약어는 사용할 수 없다. (필수)

		// 자바 예약어
		// boolean, byte, char, private, public, new, true, if 등등

		Scanner sc = new Scanner(System.in);
		System.out.println("학생 수를 입력하세요>");
		int stuNo = sc.nextInt();
		System.out.println("입력된 학생 수 : " + stuNo);
		Integer[] stuScores = new Integer[stuNo];

		boolean run = true; // while문 종료 여부
		while (run) {
			System.out.println("---------------------------------------");
			System.out.println("1. 점수입력 | 2. 점수리스트 | 3. 분석 | 4. 종료");
			System.out.println("---------------------------------------");
			System.out.println("선택>");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("<점수입력>");
				for (int i = 0; i < stuNo; i++) {
					System.out.println(i + "번 학생의 점수를 입력하세요>");
					stuScores[i] = sc.nextInt();
				}
				break;
			case 2:
				System.out.println("<점수리스트>");
				for (int i = 0; i < stuNo; i++) {
					System.out.println(i + "번 학생의 점수 : " + stuScores[i]);
				}
				break;
			case 3:
				System.out.println("<분석>");
				Arrays.sort(stuScores, Collections.reverseOrder());
				for (int i = 0; i < stuNo; i++) {
					System.out.println((i+1)+"등 : "+stuScores[i]);
				}
				break;

			case 4:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				break;
			}

		}

		sc.close();
	} // end main()

} // end ArrayMain10
