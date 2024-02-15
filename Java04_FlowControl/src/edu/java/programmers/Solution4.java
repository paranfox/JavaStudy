package edu.java.programmers;

import java.util.Scanner;

public class Solution4 {

    public static int[] solution(int l, int r) {
        int[] answer = {};
        String result = "";
        
        
        
        
        for(int i = l; i <= r; i++) {
        	answer[i] = i + 1;
        	
        }
        
        

        return answer;
    }
   
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int l = sc.nextInt();
      int r = sc.nextInt();
      
      int[] result = solution(l, r);
      System.out.println(result);
   } // end main()

}

