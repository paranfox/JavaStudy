package edu.java.for04;

public class ForMain04 {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		int sum1 = 0;
		// 1. 1 ~ 10까지 더하시오.
		for (int i = 1; i <= 10; i++) {
			sum1 = sum1 + i;
		}
		System.out.println(sum1);

		// 1 ~ 100까지의 숫자 중 짝수들의 합을 출력
		// 2 + 4 + 6 + 8 + ... +96 + 98 + 100

		// 1 ~ 100까지 반복한다.
		// 그 중 짝수만 선택한다.
		// 선택한 수를 합친다.
		int sum2 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum2 += i;
			}
		}
		System.out.println(sum2);

		/*
		 * 1꼬마 2꼬마 3꼬마 인디언 4꼬마 5꼬마 6꼬마 인디언 7꼬마 8꼬마 9꼬마 인디언 10꼬마 인디언 보이~
		 */

		for (int i = 1; i < 16; i++) {
			if (i <= 10) {
				System.out.print(i + "꼬마");
				if (i % 4 == 0) {
					System.out.print("인디언");
					System.out.println();
				}
			} else if (i == 14) {
				System.out.print("인디언");
			} else if (i == 15) {
				System.out.print("보이~");
			}

		}

	} // end main()

} // end ForMain04
