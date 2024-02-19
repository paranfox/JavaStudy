package edu.java.wrapper01;

//Wrapper 클래스 : 자바의 기본 데이터 타입을 감싸는 클래스
//- 기본 자료형 : boolean, byte, short, int, long, char, float, double
//- Wrapper 클래스 : 
//		Boolean, Byte, Short, Integer, Long, Character, Float, Double
//- Wrapper 클래스를 사용하는 이유 :
//		1. 클래스의 메소드(기능), 상수(public static final)을 사용하기 위해서
//		2. 매개변수 Object를 갖는 메소드의 인자값으로 사용하기 위해서
//		3. 컬렉션 프레임워크에서 사용하기 위해서
public class WrapperMain01 {

	public static void main(String[] args) {
		// Wrapper 클래스의 상수
		System.out.println("byte 타입의 최소값 : " + Byte.MIN_VALUE);
		System.out.println("byte 타입의 최대값 : " + Byte.MAX_VALUE);
		System.out.println("int 타입의 최소값 : " + Integer.MIN_VALUE);
		System.out.println("int 타입의 최대값 : " + Integer.MAX_VALUE);
		
		System.out.println();
		int n1 = 123;
//		Integer num1 = new Integer(123);
		Integer num1 = 123; // 할 수 있는 건 훨씬 강력하지만 무겁다.(마치 로켓)
		System.out.println("num1 = " + num1);
		
		int value1 = num1;
		System.out.println("value1 = " + value1);
		
		// valueOf() 메소드
		Integer num3 = Integer.valueOf(100);
		System.out.println("num3 = " + num3);
		
		Double num4 = Double.valueOf(3.14);
		System.out.println("num4 = " + num4);
		
		Integer num5 = Integer.valueOf("200");
		// 문자열 형태의 '숫자'를 Integer 타입의 변수에 저장
		System.out.println("num3 = " + num5);
		
		System.out.println();
		// parseXxx() :
		// 문자열을 전달받아서, 기본 자료형으로 리턴해주는 메소드
		int x = Integer.parseInt("12345");
		System.out.println("x = " + x);
		
		double y = Double.parseDouble("3.141592");
		System.out.println("y = " + y);
		
		
		
	} // end main()

} // end WrapperMain01
