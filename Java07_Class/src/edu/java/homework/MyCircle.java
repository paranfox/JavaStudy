package edu.java.homework;

//과제1. 원(MyCircle)클래스 정의하고
//HW3 클래스에서 인스턴스 생성 및 데이터 출력
//1) 맴버 변수: double radius
//2) 생성자: 기본 생성자, 매개변수(double radius)가 있는 생성자
//3) 메소드: 원의 면적을 계산 (3.14 * radius * radius)
//4) Mycircle 인 인스턴스를 HW3에서 생성하여 반지름 및 원 넓이 출력

public class MyCircle {

	double radies;
	
	public MyCircle() {
		
	}
	public double calcArea() {
		return 3.14 * radies * radies;
	}
	
} // end MyCircle
