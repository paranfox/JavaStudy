package edu.java.codeup;

import java.util.Scanner;

public class Main12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = 0;
		for (int i = a; i <= b; i++) {
			if (i % 2 == 1) {
				if (i == a) {
					System.out.print(i);
				} else if (i != a) {
					System.out.print("+" + i);
				}
				sum += i;
			} else {
				sum -= i;
				System.out.print("-" + i);

			}
		}
		System.out.println("=" + sum);

	}

}