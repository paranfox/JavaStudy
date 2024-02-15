package edu.java.inherit08;

public class EmployeeUtil {
	// instanceof
	// - 기본 형태
	//   참조변수 instanceof 클래스 이름
	// - 명시한 클래스 타입의 인스턴스와 갑으면 true, 아니면 false를 리턴하는 키워드
	// - 특정 인스턴스가 실제 어떤 클래스인지 확인할 때 사용
	public static void prinyEmployeeInfo(Employee[] emps) {
		for(Employee e : emps) {
			if (e instanceof Manager) {
				System.out.println("이름 : " + e.getName());
                System.out.println("직책 : " + ((Manager) e).getType());
            } else {
            	System.out.println("이름 : " + e.getName());
				System.out.println("직책 : Not specified");
			}
		}
	}

}
