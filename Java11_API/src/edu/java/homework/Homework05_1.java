package edu.java.homework;

//Homework04_1.java 생성하여 풀이
//다음 문자열에서 숫자들을 구분하여 합을 구하시오.
//String str = "2024년 02월 19일 16:37:53";

public class Homework05_1 {

	public static void main(String[] args) {
		String str = "2024년 02월 19일 16:37:53";
		
		String[] result = str.split(" |년 |월 |일 |:");
		int sum = 0;
		for(int i=0; i < result.length; i++) {
                sum += Integer.parseInt(result[i]);
		}
		System.out.println(sum);
	}

}