package edu.java.collection02;

import java.util.ArrayList;

class Student {
	// 멤버 변수
	private int stuNo;
	private String name;
	
	public Student() {}

	public Student(int stuNo, String name) {
		super();
		this.stuNo = stuNo;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", name=" + name + "]";
	}
	
	
}
public class ListMain02 {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(100);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("test");
		
		// Student 타입을 지정할 수 있는 ArrayList 인스턴스 생성
		ArrayList<Student> list3 = new ArrayList<>();
		
		list3.add(new Student(1, "kim")); // 형변환시켜 주어야 한다는 것 까지 생각을 해야 한다.
		Student stu1 = new Student(2, "park");
		list3.add(stu1);
		
		for(int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i));
		}
		
	} // end main()

} // end ListMain02
