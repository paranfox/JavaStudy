package edu.java.variable08;

import java.util.Scanner;

public class ScannerMain01 {

	public static void main(String[] args) {
		System.out.println("변수 입력");
		
		// 입력을 받기 위한 변수는 Scanner 선언
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요: ");
		int userInput = sc.nextInt(); // 정수 입력
		System.out.println("입력받은 정수는 " + userInput + "입니다.");
		
		// nextInt() : 정수를 입력받는 메소드
		// nextDouble() : 실수를 입력받는 메소드
		// nextLine() : 문자열 한 줄을 입력받는 메소드
		// next() : 문자열 한 줄을 입력 받는 메소드, 엔터 버퍼를 처리
		
		System.out.println();
		System.out.println("실수 입력 : ");
		double x = sc.nextDouble();
		System.out.println("x = " + x);
		
		
		
	} // end main()

} // end ScannerMain01
