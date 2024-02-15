package edu.java.if04;

import java.util.Scanner;

public class IfMain04 {

	public static void main(String[] args) {
		System.out.println("if - else if - else 연습");
		
		// 점수를 정수로 입력받아서 score 이름의 변수에 저장
		// score가 90점 이상이면 "A"를 출력
		// score가 80점 이상이면 "B"를 출력
		// score가 70점 이상이면 "C"를 출력
		// score가 70점 미만이면 "F"를 출력
		
		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		System.out.println("점수 등급은? ");
		
		if(score >= 90) {
			System.out.println("A");
		} else if(score >= 80) {
			System.out.println("B");
		} else if(score >= 70) {
			System.out.println("C");
		} else {
			System.out.println("F");
		}

	} // end main()

} // end IfMain04






