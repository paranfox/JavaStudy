package edu.java.programmers;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int length = str.length();
		
		for (int i = 0; i <= length - 1; i++) {
			
			char ch = str.charAt(i);
			if('a' <= ch && ch <= 'z') {
				System.out.print((char) (ch - 32));
				
			} else if('A' <= ch && ch <='Z') {
				System.out.print((char) (ch + 32));
			}
		}

	} // end main()

} // end Solution
