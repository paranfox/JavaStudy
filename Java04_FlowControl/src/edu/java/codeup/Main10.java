package edu.java.codeup;

import java.util.Scanner;

public class Main10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int j = 0;
		for(int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if(j < n) {
				j = n;
			}
		}
		System.out.println(j);
		sc.close();
	} // end main()

} // end Main10
