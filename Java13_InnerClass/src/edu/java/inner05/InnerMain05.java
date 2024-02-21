package edu.java.inner05;

class OuterClass {
	private int value;
	
	public OuterClass(int value) {
		this.value = value;
	} // end OuterClass
	
	public void test() { // 지역 변수또한 이 안에서 만 사용
		int x = 123; // 지역 변수(local variable)
		
		// 지역 변수를 선언하는 위치에서 정의하는 클래스 : 지역 클래스
		// 여기서 생성하고 여기서 부를려고 만든 것
		class LocalClass {
			private int value2; // 지역클래스의 멤버 변수
			
			// 지역 클래스의 생성자
			public LocalClass(int value2) {
				this.value2 = value2;
			}
			
			// 지역 클래스의 메소드
			public void display() {
				// 외부 클래스의 멤버 변수를 참조 가능
				System.out.println("value = " + value);
				
				// 메소드의 지역 변수 사용 가능
				System.out.println("x = " + x);
				
				// 지역 클래스의 멤버 변수를 참조 가능
				System.out.println("value2 = " + value2);
			} // end display()
			
		} // end LocalClass
		
		// 지역 클래스의 인스턴스 생성 - 메소드 안에서만 가능(필수!!!)
		LocalClass local = new LocalClass(1234);
		// 일회용품 사용하고 버리는 형식이다.
		local.display();
		
	} // end test()
	
} // end OuterClass

public class InnerMain05 {

	public static void main(String[] args) {
		OuterClass outer = new OuterClass(100);
		outer.test();
	} // end main()

} // end InnerMain05







