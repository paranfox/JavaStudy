package edu.java.method03;

import java.util.Scanner;

public class MethodMain03 {

	// 1. 국어, 영어, 수학 점수를 입력받아서 3개의 변수에 저장
	// 2. 메소드를 정의하여 입력받은 점수를 출력
	// 3. 메소드를 정의하여 세 과목의 총점을 출력
	// 4. 메소드를 정의하여 세 과목의 평균을 출력
	// 5. 메소드를 정의하여 평균에 따른 등급을 출력

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수 입력>");
		int kor = sc.nextInt();
		System.out.println("영어점수 입력>");
		int eng = sc.nextInt();
		System.out.println("수학점수 입력>");
		int met = sc.nextInt();

		printScores(kor, eng, met);
		int sum = calcTotal(kor, eng, met);
		System.out.println("총점 : " + sum);
		double aver = calcAverage(sum);
		System.out.printf("평균 : %.2f %n", aver);
		String grade = selectGrade(aver);
		System.out.println("등급" + grade);
	} // end main()

	// 국/영/수 점수를 출력하는 메소드
	// 메소드 이름 : printScores()
	public static void printScores(int korean, int english, int math) {
		System.out.print("국어점수 : " + korean + " ");
		System.out.print("영어점수 : " + english + " ");
		System.out.print("수학점수 : " + math + " ");
		System.out.println();
	} // end printScores()

	// 국/영/수 총점를 출력하는 메소드
	// 메소드 이름 : calcTotal()
	public static int calcTotal(int korean, int english, int math) {
		int tot = korean + english + math;
		return tot;
	} // end calcTotal()

	// 국/영/수 평균를 출력하는 메소드
	// 메소드 이름 : calcAverage()
	public static double calcAverage(int x)  {
		double aver = x / 3.0;
		return aver;
	} // end calcAverage()

	// 등급를 출력하는 메소드
	// 메소드 이름 : selectGrade()
	public static String selectGrade(double x) {
		double aver = x;
		String grade = "";
		if(90 <= aver) {
			grade = "A";
		} else if(80 <= aver) {
			grade = "B";
		} else if(70 <= aver) {
			grade = "C";
		} else if(69 > aver) {
			grade = "D";			
		}
		return grade;
		
	} // end selectGrade()

} // end MethodMain03
