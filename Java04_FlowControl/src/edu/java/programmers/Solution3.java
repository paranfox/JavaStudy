package edu.java.programmers;

import java.util.Scanner;

public class Solution3 {

	public static int solution(int a, int b, int c) {
        int answer = 0;
        if(a != b && b!=c && a!=c) {
        	answer = a + b + c;
        } else if (a == b && b==c && a==c) {
        	answer = (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
		} else {
			answer = (a + b + c) * (a*a + b*b + c*c);
		}
        
        return answer;
    }
   
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      
      int result = solution(a, b, c);
      System.out.println(result);
   } // end main()

}

