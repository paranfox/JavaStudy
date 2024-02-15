package edu.java.codeup;

import java.util.Scanner;

public class Main9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		for(int i = 1; i <= n; i++) {
			if(i % 10 == 1) {
				count++;
			}
		}
		System.out.println(count);

		sc.close();
	} // end main()

} // end Main09
