package edu.java.codeup;

import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		int[] n = new int[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			n[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(n[k - 1]);

	}

}
