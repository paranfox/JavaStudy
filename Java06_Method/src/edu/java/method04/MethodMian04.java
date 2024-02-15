package edu.java.method04;

import java.util.Scanner;

public class MethodMian04 {

	public static void main(String[] args) {
		System.out.println("배열을 매개변수로 갖는 메소드");
		
		// 변수 선언 -> 공간 생성 -> 주소값 존재
		int[] scores = new int[5];
		System.out.println("주소값 : " + scores);
		
		inputSource(scores);
		
		printScores(scores);
		
		
	} // end main()

	private static void printScores(int[] scores) {
		System.out.println("주소값 : "+ scores);
		for(int x : scores) {
			System.out.println("입력한 점수 : " + x);
		}
		
	}

	private static void inputSource(int[] scores) {
		Scanner sc = new Scanner(System.in);
		for(int i =0; i < scores.length; i++) {
			System.out.println("점수 : " + i + "번째 입력");
			scores[i] = sc.nextInt();
		}
		
	}

} // end MethodMain04
