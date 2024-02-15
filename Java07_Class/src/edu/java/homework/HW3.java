package edu.java.homework;

public class HW3 {

	public static void main(String[] args) {
		MyCircle rect1 = new MyCircle();

		rect1.radies = 3.0;
		
		System.out.println("반지름 : " + rect1.radies);
		System.out.printf("넓이 : %.2f", rect1.calcArea());
	}

}
