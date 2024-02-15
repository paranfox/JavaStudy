package edu.java.codeup;

import java.util.Scanner;

public class Main06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[] count = new int[k];
		for (int i = 0; i < k; i++) {
			count[i] = sc.nextInt();
			System.out.println(count[i]);
		}
		for(int i = 0; i < k; i++) {
			System.out.println(count[i]);
		}
		
		sc.close();
	}

}
