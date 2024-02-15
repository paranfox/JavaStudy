package edu.java.programmers;

import java.util.Scanner;

public class Solution2 {

	public static int solution(String ineq, String eq, int n, int m) {
		int answer = 0;
		// equals() : 문자열 비교. 같으면 true, 아니면 false
		if (ineq.equals("<")) { // ineq가 "<"인 경우
			if (eq.equals("=")) { // eq가 "="인 경우
				if(n <= m) {
					answer = 1;
				} else {
					answer = 0;
				}
			} else if (eq.equals("!")) { // eq가 "!"인 경우
				if(n < m) {
					answer = 1;
				} else {
					answer = 0;
				}
			}

		} else if (ineq.equals(">")) {
			if (eq.equals("=")) { // eq가 "="인 경우
				if(n >= m) {
					answer = 1;
				} else {
					answer = 0;
				}
			} else if (eq.equals("!")) { // eq가 "!"인 경우
				if(n > m) {
					answer = 1;
				} else {
					answer = 0;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String ineq = sc.next();
		String eq = sc.next();
		int n = sc.nextInt();
		int m = sc.nextInt();

		int result = solution(ineq, eq, n, m);
		System.out.println(result);
	} // end main()

}
