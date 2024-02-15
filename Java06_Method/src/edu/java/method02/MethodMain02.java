package edu.java.method02;

public class MethodMain02 {

	// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 합을 리턴
	// 메소드 이름 : add
	// 리턴타입 : int
	// 매개변수 : int x, int y
	public static int add(int x, int y) {
		int result = x + y;
		return result;
	} // end add()
	
	// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 차을 리턴
	// 메소드 이름 : sub
	// 리턴타입 : int
	// 매개변수 : int x, int y
	public static int sub(int x, int y) {
		int result = x - y;
		return result;
	} // end sub()
	
	
	public static void main(String[] args) {
		System.out.println("메소드 연습");
		int result = add(10, 20);
		System.out.println(result);
		result = sub(10, 20);
		System.out.println(result
				
				);
		
	} // end main()

} // end MethodMain02
