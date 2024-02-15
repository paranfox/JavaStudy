package edu.java.codeup;

import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, i, t;
		int a[] = new int[24]; // 배열을 만드는 데 첫번째는 0이 들어간다 무조건
		n = sc.nextInt(); // 개수 입력받기
		for (i = 1; i <= n; i++) // 개수만큼 입력받기
		{
			t = sc.nextInt(); // 읽어서
			a[t] = a[t] + 1; // 들어있던 값에 1만큼 더해 다시 저장. a[t]+=1 과 같다.
		}
		for (i = 1; i <= 23; i++) {
			System.out.print(a[i] + " "); // 1~23 번 배열에 저장되어있는 값 출력하기
		}
	}
}
