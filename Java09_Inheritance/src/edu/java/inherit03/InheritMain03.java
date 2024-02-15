package edu.java.inherit03;

public class InheritMain03 {

	public static void main(String[] args) {
		Phone phone1 = new Phone("010");
		SmartPhone phone = new SmartPhone("010-1111-1111");
		
		Phone ph = new Phone("안녕하세용");
		System.out.println(ph.toString());

	} // end main()

} // end InheritMain03

