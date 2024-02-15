package edu.java.if07;

import java.util.Scanner;

public class IfMain07 {

	public static void main(String[] args) {
		// Ctrl + Shift + f : 코드 자동 정렬
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		sc.close();
		// 입력된 3 개의 숫자 중 가장 큰 수를 출력하시오.
		if(a >= b) { // a가 b보다 크거나 같은가?
			if(a >= c) {
				System.out.println(a);
			} else {
				System.out.println(c);
			}
		} else {
			System.out.println(b);
		}
		
		// 너무 긴 코드
		
		if(a>=b) { // a가 b보다 큰경우
			if(a>=c) { // a가 c보다 큰경우
				System.out.println("가장큰수 : "+a);
			}
		} else if(b>=a) { // b가 z보다 큰경우
			if(b>=c) { // b가 c보다 큰경우
				System.out.println("가장큰수 : "+b);
			}
		} else if(c>=a) { // c가 a보다 큰경우
			if(c>=b) { // c가 b보다 큰경우
				System.out.println("가장큰수 : "+c);
			}
		}
		
		// 3항으로 작성시
		System.out.println(a>=b ? (a>=c ? "가장큰수 : " + a: "가장큰수 : " + c) : "가장큰수 : " + b);
			
		

	} // end main()

} // end IfMain07
