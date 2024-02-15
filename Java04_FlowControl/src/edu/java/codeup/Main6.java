package edu.java.codeup;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			if(i%3==0) {
				continue;
			} else {
				System.out.print(i);
			}
			System.out.print(" ");
		}

	}

}
