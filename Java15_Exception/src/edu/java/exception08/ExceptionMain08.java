package edu.java.exception08;

import java.util.Scanner;

public class ExceptionMain08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// try-catch를 사용하여 숫자가 정상적으로 입력되면 종료되도록
			// 코드 작성
			try {
				System.out.println("메뉴 선택");
				int choice = Integer.parseInt(sc.next());
				System.out.println("choice : " + choice);
				break;
			} catch (Exception e) {
				System.out.println("숫자가 아닙니다. : ");
			}
		}

	} // end main()

} // ExceptionMain08
