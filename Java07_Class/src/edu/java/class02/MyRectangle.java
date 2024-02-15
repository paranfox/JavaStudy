package edu.java.class02;

// 클래스 : 
// 	   상태(속성, 성질) : 맴버 변수(field, property)
//     기능 - 메소드
//     생성자(constructor) - 맴버 변수들을 초기화
//        - 클래스 이름과 동인
//        - 매개변수는 있을 수 도 있고, 없을 수도 있음
//        - 클래스를 작성할 때 생성자를 하나도 정의하지 않은 경우,
//          자바 컴파일러가 기본 생성자를 자동으로 만들어 중.
//        - 생성자를 하나라도 정의한 경우에는 , 자동으로 기본 생성자를 만들지 않음

public class MyRectangle {
	// 맴버 변수
	double width; // 사각형의 가로
	double height; // 사각형의 세로

	// 기본 생성자
	public MyRectangle() {

	}

	// 매개변수가 있는 생성자
	public MyRectangle(double width, double height) {
		this.width = width;
		this.height = height;
		// this : 자기 자신(MyRectangle 클래스)
	}

	// 메소드
	public double calcArea() {
		return width * height;
	}

} // end MyRectangle
