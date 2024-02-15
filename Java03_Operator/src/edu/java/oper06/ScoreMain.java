package edu.java.oper06;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		System.out.println("총점 및 평균 계산 프로그램");
		// 1. 입력받을 준비 : Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		// 2. 국어, 영어, 수학 점수를 정수로 입력잗아서 변수에 저장
		System.out.println("국어점수를 입력해주세요 : ");
		int kor = sc.nextInt();
		System.out.println("영어점수를 입력해주세요 : ");
		int eng = sc.nextInt();
		System.out.println("수학점수를 입력해주세요 : ");
		int met = sc.nextInt();
		
		// 3. 국어, 영어, 수학 점수를 출력
		System.out.println("국어점수입니다 : " + kor);
		System.out.println("영어점수입니다 : " + eng);
		System.out.println("수학점수입니다 : " + met);
		
		// 4. 총점을 계산하여 출력
		int tot = 0;
		tot = (kor + eng + met);
		System.out.println("총점입니다 : " + tot);
		
		// 5. 평균을 계산하여 출력(소숫점 셋째자리까지)
		System.out.printf("평균입니다 : %.3f", (tot / 3.0));		
		
		sc.close();
		
	} // end main()

} // end ScoreMain
