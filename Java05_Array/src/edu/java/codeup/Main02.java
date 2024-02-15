package edu.java.codeup;

import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		String str;
		String result = "";
		str = sc.nextLine(); // 읽어서
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				result += str.charAt(i);
			}
		}
		System.out.println(result);

	} // end main()

} // end Main02
