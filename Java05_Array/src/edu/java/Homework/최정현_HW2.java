package edu.java.Homework;

import java.util.*;

public class 최정현_HW2 {

	public static void main(String[] args) {
//		과제1 : 배열 6 8 4 2 5의 값 중에 최대값 출력하기
//		* 배열 직접 선언할 것!
		Integer[] arr = { 6, 8, 4, 2, 5 }; // 배열 선언
		Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬로 가장 큰 수가 앞으로 옴
		System.out.println(arr[0]); // 첫번째 값을 뽑으면 최대값

//		과제2 : 과제1의 배열(6 8 4 2 5)의 전체 합과 평균 값을 구하기
		int sum = 0;
		for (int i = 0; i < arr.length; i++) { // 배열에 있는 값들을 전부 더해줌
			sum += arr[i];
		}
		System.out.println("전체 합 : " + sum); // 전체합 출력
		System.out.println("평균 값 : " + (sum / (arr.length * 1.0))); // 평균값 출력

//		과제3: 피보나치 수열 20개를 출력
//		피보나치(Fibonacci) 수열: 1, 1, 2, 3, 5, 8, 13, 21, ...
//		힌트)
//		f[0] = 1
//		f[1] = 1
//		f[n] = f[n-1] + f[n-2], n >= 2

//		1) 정수 20개를 저장할 수 있는 배열 선언
		int[] f = new int[20];
//		2) 배열의 인덱스 0번째, 1번째 원소는 1로 초기화
		f[0] = 1;
		f[1] = 1;

//		3) 배열의 인덱스 2번째 원소부터 19번째 원소까지는 반복문을 사용해서 초기화
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
//		4) 배열의 내용을 출력
		for (int i : f) {
			System.out.print("[" + i + "]");
		}
		System.out.println(); // 한 칸 건너뛰기
//		과제4: 				
//		int[][] array2 = {
//		{95, 86}, 
//		{44, 22, 96}, 
//		{78, 83, 93, 87, 88}
//		};				
//		위 2차원 배열의 전체 합과 평균과 최대값 구하기
		sum = 0;
		double count = 0;
		int max = Integer.MIN_VALUE;
		int[][] array2 = { { 95, 86 }, { 44, 22, 96 }, { 78, 83, 93, 87, 88 } };
		for (int i = 0; i < array2.length; i++) { // i,j를 이용한 배열의 좌표값 찾기
			for (int j = 0; j < array2[i].length; j++) {
				System.out.print(array2[i][j] + " ");  // 전체 값 만들어 보기
				sum += array2[i][j];
				count++;
				if (max < array2[i][j]) {
					max = array2[i][j];
				}
			}
			System.out.println();
//			count += array2[i].length;
//			System.out.println(count);
		}
		System.out.println("전체 합 : " + sum);
		System.out.println("평균 값 : " + (sum / count));
		System.out.println("최대 값 : " + max);
	} // end main()

} // end Homework
