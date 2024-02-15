package edu.java.codeup;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 0; i >= 0; i++) {
			sum += i;
			if (sum >= n) {
				System.out.println(i);
				break;
			}
		}
	}
}
