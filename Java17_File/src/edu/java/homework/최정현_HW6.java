package edu.java.homework;

import java.io.*;
import java.util.*;

public class 최정현_HW6 {

	public static void main(String[] args) {
		System.out.println("ArrayList<MemberVO> 객체를 파일에 저장하는 코드");
		Scanner sc = new Scanner(System.in);
		// ArrayList를 이용하여 memberlist.txt안에 내용을 넣기
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream("temp/memberlist.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);

			List<Student> list = new ArrayList<>();
			for (int i = 0; i < 5; i++) { // 5번 이름, 수학, 영어 넣기
				System.out.println("이름>");
				String name = sc.next();
				System.out.println("수학>");
				String math = sc.next();
				System.out.println("영어>");
				String eng = sc.next();
				Student m = new Student(name, math, eng);
				list.add(m); // list배열에 추가
			}
			oout.writeObject(list);
			System.out.println("데이터 저장 완료");

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ArrayList를 이용하여 memberlist.txt안에 있는 내용을 출력하는 방법
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		try {
			in = new FileInputStream("temp/memberlist.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			ArrayList<Student> list = (ArrayList<Student>) oin.readObject(); // 강제형 변환
			
			for(Student m : list) { // list배열 안에 있는 내용 출력
				System.out.println(m.displayInfo());
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sc.close();

	} // end main

} // end HW_06
