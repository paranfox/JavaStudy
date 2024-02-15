package edu.java.access04;

public class AccessMain04 {

	public static void main(String[] args) {
		// 객체 생성 및 데이터 저장 방식 1
		// 처음 만들때 미리 넣어 버리는 방식
		Contact c1 = new Contact(0, "유재석", "010-2222-2222" , "you@gmail.com");
		System.out.println(c1.toString());
		
		System.out.println();
		// 전화번호를 변경하라!
		c1.setPhone("010-4444-5555");
		System.out.println(c1.toString());
		
		// 객체 생성 및 데이터 저장 방식 2
		// 왔다 갔다 하는 방식
		Contact c2 = new Contact();
		System.out.println(c2.toString());
		c2.setNo(1);
		c2.setName("박명수");
		c2.setPhone("010-3333-4444");
		c2.setEmail("park@gmail.com");
		System.out.println(c2.toString());
		
		// 3명의 연락처 정보를 배열로 묶음
		Contact[] contacts = new Contact[3];
		// 유재석의 정보를 contacts[0]에 저장
		contacts[0] = c1;
		// 박명수의 정보를 contact[1]에 저장
		contacts[1] = c2;
		// 아이유의 정보를 contact[2]에 저장
		contacts[2] = new Contact(2, "아이유", "010-2222-3333", "iu@gmail.com");
		
		for(Contact c : contacts) {
//			System.out.println(c);
			System.out.println(c.getNo());
			System.out.println(c.getName());
			System.out.println(c.getPhone());
			System.out.println(c.getEmail());
		}
		

	} // end main()

} // AccessMain04
