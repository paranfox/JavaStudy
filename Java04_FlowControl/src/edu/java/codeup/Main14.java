package edu.java.codeup;

import java.util.Scanner;

public class Main14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <=9; i++) {
			int ster = n * i;
				for(int j = 0; j <ster; j++) {
				System.out.print("*");
			}
				System.out.println();
		}
		
	}

}
