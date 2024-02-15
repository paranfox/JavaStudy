package edu.java.codeup;

import java.util.Scanner;

public class Main05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Integer n = sc.nextInt();
		int[] count = new int[n];
		int[] count2 = new int[n];
		for (int i = 0; i < count.length; i++) {
			count[i] = sc.nextInt();
		}
		for (int i = 0; i < count.length; i++) {
			count2[i] = count[n - 1];
			n--;
		}
		for (int i = 0; i < count.length; i++) {
			System.out.print(count2[i] + " ");
		}

		sc.close();
	}

}
