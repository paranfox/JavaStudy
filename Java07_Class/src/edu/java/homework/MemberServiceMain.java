package edu.java.homework;

import java.util.Scanner;

public class MemberServiceMain {

	public static void main(String[] args) {
		MemberService rect1 = new MemberService();
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String password = sc.next();
		boolean result = rect1.login(id, password);
		if(result) {
			System.out.println("로그인 되었습니다.");
			rect1.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		
		sc.close();
	} // end main()

} // end MemberServiceMain
