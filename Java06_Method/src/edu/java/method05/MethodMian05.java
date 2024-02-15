package edu.java.method05;

// 메소드 overloading
// 1. 매개변수의 개수가 다르거나
// 2. 매개변수의 타입이 다른 경우
// 같은 이름으로 정의할 수 있음
// (주의) 메소드의 리턴타입만 다른 경우는 같은 이름으로 메소드를 정의할 수 없음

public class MethodMian05 {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("문자열");
		System.out.println(1);
		System.out.println(1.0);
		System.out.println(true);
		
		sayHello();
		sayHello(null);
		
	} // end main()
	
	public static void sayHello() {
		System.out.println("안녕하세요.");
		
	} // end sayHello()
	
	public static void sayHello(String name) {
		System.out.println("안녕하세요.");
		System.out.println("제 이름은 " + name + "입니다.");
		
	} // end sayHello()
	

} // end MethodMian05
