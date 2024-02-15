package edu.java.codeup;

import java.util.*;

public class Main07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			count[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print(count[j] + " ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print(count[j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}