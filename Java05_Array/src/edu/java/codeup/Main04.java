package edu.java.codeup;

import java.util.Scanner;

public class Main04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] n = new String[N];
		
		for (int i = 0; i < N - 1; i++) {
			int in = sc.nextInt();
			n[in -1] = in + "";
		}
		for (int i = 0; i < N; i++) {
			if (n[i] == null) {
				System.out.println(i + 1);
				break;
			}
		}
		
	}

}
