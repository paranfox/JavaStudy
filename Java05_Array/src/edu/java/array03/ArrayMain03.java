package edu.java.array03;

import java.util.Scanner;

public class ArrayMain03 {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		Scanner sc = new Scanner(System.in);
		// n명의 학생 점수를 입력받아
		// 모든 점수, 총합, 평균을 출력(점수는 직접 입력)
		// 뽀나스) 최대값, 최소값도 출력

		System.out.print("n명 입력 : ");
		int n = sc.nextInt();
		int[] scores = new int[n];
		int sum = 0;

		for (int i = 0; i < scores.length; i++) {
			System.out.printf((i + 1) + "번 학생의 점수입력 : %n");
			scores[i] = sc.nextInt();
			// 모든 점수의 합 출력
			sum += scores[i];
		}

		for (int i = 0; i < scores.length; i++) {
			// 모든 점수 출력
			System.out.println("scores[" + i + "] = " + scores[i]);
		}
		// 평균 출력하기(소수점까지 표현)
		// double avg = ((double) sum) / n;
		double avg = (sum / (n * 1.0));

		// 점수 최대값 출력
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < scores.length; i++) {

			if (scores[i] > max) { // 배열에 저장된 값이 max보다 큰 경우
				max = scores[i];
			} else if (scores[i] < min) { // 배열에 저장된 값이 min보다 작은 경우
				min = scores[i];
			}
		}

		System.out.println("n명의 학생 점수의 총합 : " + sum);
		System.out.printf("n명의 학생 점수의 평균 : %.2f%n", avg);
		System.out.println("n명의 학생 점수의 최대값 : " + max);
		System.out.println("n명의 학생 점수의 최소값 : " + min);

	} // end main()

} // end ArrayMain03
