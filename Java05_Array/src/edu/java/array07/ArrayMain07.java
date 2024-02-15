package edu.java.array07;

public class ArrayMain07 {

	public static void main(String[] args) {
		System.out.println("배열 연습3");
		String test = "문자열입니다.";
		System.out.println(test);
		System.out.println(test.length());
		
		for(int i = 0; i < test.length(); i++) {
			System.out.println(test.charAt(i));
			if(test.charAt(i) == '열') {
				break;
			}
		}
		
		// 문자열 배열 선언
		String[] subjects = {"국어", "영어", "수학", "프로그래밍"};
		
		// 모든 과목들의 문자열 길이를 출력
		// 각 문자열에 "어"라는 글자가 포함되어 있는 경우만
		// 문자열 길이를 출력하쇼.
		for(int i = 0; i < subjects.length; i++) {
			if(subjects[i].contains("어")) {
				System.out.println("과목명 : " + subjects[i]);
				System.out.println("문자열 길이 : " + subjects[i].length());
			}
			
		}
		
		for(String str : subjects) {
			if(str.equals("프로그래밍")) {  // 왠만해선 equals를 사용하자
				System.out.println("재밌다!");
				System.out.println(str.length());
			}
		}
		
		
		
		
		
		
	} // end main()

} // end ArrayMain07
