package edu.java.variable10;

import java.util.Scanner;

public class ScannerMain03 {

	public static void main(String[] args) {
		System.out.println("문자 하나 입력");
		
		Scanner sc = new Scanner(System.in);
		
		char ch1 = sc.next().charAt(0); // 문자 하나 입력 후 저장
		System.out.println("ch1 = " + ch1);
		
		
		
		sc.close();

	} // end main()

} // end ScannerMain03
