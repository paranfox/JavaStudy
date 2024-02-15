package edu.java.programmers;

import java.util.Scanner;

public class Solution1 {

	public static int main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		int a = sc. nextInt();
		int b = sc. nextInt();
		String str1 = String.valueOf(a);
		String str2 = String.valueOf(b);
		int sum1 = Integer.parseInt(str1+str2);
		int sum2 = 2 * a * b;
		if(sum1 > sum2) {
			answer = sum1;
		}else if(sum1 < sum2) {
			answer = sum2;
		}
return answer;
	}

}
