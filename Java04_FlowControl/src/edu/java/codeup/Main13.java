package edu.java.codeup;

import java.util.Scanner;

public class Main13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = -1000000, min = 1000000;
		for (int i = 0; i < 5; i++) {
			int N = sc.nextInt();

			if (N > max) {
				max = N;
			} else if (N < min) {
				min = N;
			}

		}
		System.out.println(max);
		System.out.println(min);

	}

}
