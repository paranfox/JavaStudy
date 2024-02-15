package edu.java.codeup;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 1;
		int sum = 0;
		while(true) {
			if(sum<n) {
				sum += i;
				i++;
			}else {
				break;
				
			}
		}
		System.out.println(sum);
		
		
	}

}
