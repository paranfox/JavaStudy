package edu.java.oper04;

public class OperatorMain04 {

	public static void main(String[] args) {
		System.out.println("비교 연산자");
		
		System.out.println(10 > 20); // 10이 20보다 큰가?
		System.out.println(10 < 20); // 10이 20보다 작은가?
		System.out.println(123 == 100); // 123이 100과 같은가?
		System.out.println(123 != 100); // 123이 100보다 다른가?

		System.out.println("논리 연산자");
		boolean A = true; // 1
		boolean B = false; // 0
		System.out.println(A && B); // 곱연산자(and)
		System.out.println(A || B); // 합연산자(or)
		System.out.println(!B); // 부정연산자(not)

		int age = 20;
		String sex = "남";
		
		// 나이가 19세 이상이고, 성별이 "남"인 경우
		System.out.println((age >= 19) && (sex == "남"));
		System.out.println((10 > 0) && (10 < 100));
		System.out.println((10 > 0) || (10 < 100));
		System.out.println((10 <= 0) || (10 <= 100));
		System.out.println(!(111 < 100));
		
		
		
		
		
	} // end main()

} // end OperatorMain04
