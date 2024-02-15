package edu.java.homework;

import java.util.Scanner;

public class 최정현_HW1 {

	public static void main(String[] args) {
		// 1. 반복문을 사용해서, 'A'부터 'Z'까지 출력하는 프로그램
		for (char i = 'A'; i < 'Z'; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 2. While문과 Math.random() 함수를 이용해서 두 개의 주사위를 던졌을 때 나오는
		// 눈의 합이 5이면 실행을 멈추고 5가 아니면 주사위를 계속 던지는 코드를 작성
		// 예시) 합의 5가 나올때까지 아래와 같이 실행
		// (1, 3)
		// (2, 6)
		// (3, 1)
		// (4, 1)
		while (true) {
			int dice1 = (int) (Math.random() * 6) + 1;
			int dice2 = (int) (Math.random() * 6) + 1;
			System.out.println("(" + dice1 + ", " + dice2 + ")");
			if ((dice1 + dice2) == 5) {
				System.out.println("주사위의 합이 5가 되었습니다.");
				break;
			}
		}

		// 3. 숫자가 1 + (-2) + 3 + (-4) + 5 + ... + n 형태로 더해진다.
		// (n은 값이 정해지지 않았음)
		// sum = 1 + (-2) + 3 + (-4) + 5 + ... + n 의 값이
		// 100 이상으로 넘어갔을 때의 n의 값과 sum의 값을 출력

		// sum = 1 + 2 + 3 + 4 + 5 + ... + n
		// sum >= 100인 n과 sum 값
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (i == n) {
				System.out.println("sum이 100에 도달하지 못했습니다.");
				break;
			}
			if (i % 2 == 1) {
				sum += i;
			} else {
				sum -= i;

			}
			if (sum >= 100) {
				System.out.println("sum이 100에 도달했습니다.");
				n = i;
				System.out.println("n = " + n);
				System.out.println("sum = " + sum);
				break;
			}
		}

		// 4. 다음과 같이 출력하는 프로그램(보너스 문제)
		// *
		// **
		// ***
		// ****
		// *****

		// *****
		// 0****
		// 00***
		// 000**
		// 0000*

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i < j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	} // end main()

}
