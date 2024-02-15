package edu.java.inherit09;

public class Test1 {
	private int a;
	int b;
	protected int c;
	public int d;
	
	public void display() {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
	}

} // end Test1

class Test2 extends Test1{
	@Override
	public void display() {
//		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
	}
}


