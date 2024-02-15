package edu.java.array09;

public class ArrayMain09 {

	public static void main(String[] args) {
		System.out.println();
		String[] avengers = {"아이언맨","토르","헐크","캡틴"}; // 2차원
		String[] villain = {"타노스","하이드라","레드스컬"}; // 2차원
		String[][] characters = { // 계층구조 차원을 묶어서 3차원이 됨
				avengers,
				villain
		};
		
		// 모든 문자열 출력
		// 문자열 2차원 -> 문자열 1차원 -> 문자열
		for(String[] group : characters) {
			for(String name : group) {
				System.out.print(name + " ");
			}
			System.out.println();
		}
		
		int count = 0;
		for(String[] group : characters) {
			for(String name : group) {
				for(int i = 0; i < name.length(); i++) {
					if(name.charAt(i) == '이') {
						count++;
					}
				}
			}
		}
		System.out.println(count);

	} // end main()

} // end ArrayMain09
