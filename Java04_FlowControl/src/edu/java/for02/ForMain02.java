package edu.java.for02;

public class ForMain02 {

	public static void main(String[] args) {
		// println() : 맨 마지막 줄바꿈(\n)이 포함된 출력 함수
		// print() : 문자열을 나열하여 출력
		
		// 0 2 4 6 8 10
		for(int x = 0; x <= 10; x += 2) {
			System.out.print(x + " ");
		}
		
		System.out.println();
		
		// 2*0 2*1 2*2 2*3 2*4 2*5
		// 2 * (0 1 2 3 4 5 )
		for(int x = 0; x <= 5; x++) {
			System.out.print(2 * x + " ");
		}
		System.out.println();
		
		// 0 1 2 3 4 5 6 7 8 9 10
		for(int x = 0; x <= 10; x++) {
			if(x % 2 == 0) {
				System.out.print(x + " ");
			}
		}

	} // end main()

} // end ForMain02






