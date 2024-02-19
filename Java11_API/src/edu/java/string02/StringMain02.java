package edu.java.string02;

public class StringMain02 {

	public static void main(String[] args) {
		// length() : 문자열의 길이를 리턴
		String str1 = "abc";
		String str2 = "Hello";
		System.out.println(str1.length());
		System.out.println(str2.length());
		
		System.out.println("----------------------");
		// equals() : 문자열의 내용을 비교
		System.out.println(str1.equals(str2));
		
		System.out.println("----------------------");
		String str3 = "hello";
		String str4 = "Hello";
		System.out.println(str3.equals(str4));
		System.out.println(str3.equalsIgnoreCase(str4));
		
		System.out.println("----------------------");
		// charAt() : 문자열 중에서 해당 인덱스의 문자 하나를 리턴
		System.out.println(str3.charAt(1));
		
		System.out.println("----------------------");
		// indexOf() : 해당 문자 또는 문자열이 처음으로 등장하는 인덱스를 리턴
		//             해당 문자 또는 문자열이 없으면 -1을 리턴
		// lastIndexOf() : 문자 또는 문자열이 가장 마지막으로 등장하는 인덱스를 리턴
		String str5 = "Hello, world!";
		System.out.println(str5.indexOf("l"));
		System.out.println(str5.indexOf("world"));
		System.out.println(str5.lastIndexOf("l"));
		
		System.out.println("----------------------");
		// startWith() : 해당 문자열로 시작하는지 아닌지 확인
		String str6 = "https://www.google.com";
		System.out.println(str6.startsWith("https://")); // prefix = 접두어
		
		System.out.println("----------------------");
		// contains() : 해당문자열이 포함하는지 아닌지
		System.out.println(str6.contains("google")); // 필터링에 많이 사용이 된다.
		
		System.out.println("----------------------");
		// split() : 문자열을 특정 기준(구분자)으로 나눠서 배열을 리턴
		String str7 = "2024.02.19";
		String[] result = str7.split("\\."); // 프로그램 내부에서 특별한 역활을 하는 친구들은 결코 그냥 사용하면 안된다.
		// 특수기호(.$()[{^?*+\\) 사용은 기호 앞에 "\\"를 붙여주어야 함(전기기호)
		for(String x : result) {
			System.out.println(x); // 아무 것도 안뜨는 이유 : 위에 있음(해결은 백슬래이스 2개 넣어라)
		}
		
		String str8 = "C:\\Program Files\\test folder";
		result = str8.split("\\\\| |:");
		for(String x : result) {
			System.out.println(x);
		}
		
		String str9 = "2024-02-19 11:30:42";
		// 퀴즈) 위 문자열을 "2024", "02", "19", "11, "30", "42"
		// 로 나누기 나눈 데이터를 활용하여
		// 월 데이터가 1월 ~ 6월이면 "상반기", 7 ~ 12월이면 "하반기"
		// 가 출력되도록 코드 작성
		result = str9.split("-| |:");
		int month = Integer.parseInt(result[1]); // 문자열을 숫자로 변환
		if(month >= 1 && month <= 6) {
			System.out.println("상반기");
		} else {
			System.out.println("하반기");
		}
		for(String x : result) {
			System.out.println(x);
		}
		
		System.out.println("----------------------");
		// compareTo() : 해당 문자열과 비교해서 서로 다른 문자의 개수 리턴
		// compareIgnoreCase() : 해당 문자열과 대소문자 구분없이
		//                       비교 후 서로 다른 문자의 개수 리턴
		String str10 = "abc";
		String str11 = "bbc";
		System.out.println(str10.compareTo("abc"));
		System.out.println(str10.compareTo("ab"));
		System.out.println(str10.compareTo("a"));
		System.out.println(str10.compareTo("b"));
		System.out.println(str10.compareTo(str11));
//		첫 번째 문자열이 두 번째 문자열보다 사전 순으로 앞에 온다는 것을 의미합니다. 이는 첫 번째 문자열이 두 번째 문자열보다 작다는 것을 나타냅니다.
		
		System.out.println("----------------------");
		// toUpperCase() : 문자열을 대문자로 변경
		// toLowerCase() : 문자열을 소문자로 변경
		String str12 = "Hello, Java!";
		System.out.println(str12.toUpperCase());
		System.out.println(str12.toLowerCase());
		
		System.out.println("----------------------");
		// substring(begin, end) : begin부터 end까지 문자열을 리턴
		// begin 인덱스는 포함, end 인덱스는 포함되지 않음
		System.out.println(str12.substring(0, 5)); // 즉! 0 <= index < 5 라는 뜻이다.
		int begin = str12.indexOf("J"); // 변하는 형태를 맞추기 위한 방법
		int end = str12.length();
		System.out.println(str12.substring(begin, end));
		// 글자가 동적으로 바뀌면 에러가 발생한다.(하드 코딩의 또다른 문제점) - 에러) 없는 인덱스에 참조해서 애러가 난다.
		// 아까는 됬는 데 지금은 안되요 같은 건 없다 그냥 안되는 것이지
		
		System.out.println("----------------------");
		// concat() : 문자열을 이어주는 메소드
		System.out.println(str12.concat(" World!"));
		
		System.out.println("----------------------");
		// replace(A, B) : A문자열을 B로 변경
		String str13 = str12.replace("Java", "c++");
		System.out.println(str13);
		// 어떤 문자를 찾아가지고 다른 문자로 바꾸어 주는 것
		
		
		
		
	} // end main()

} // end StringMain02
