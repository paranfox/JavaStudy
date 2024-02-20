package edu.java.collection04;

import java.util.*;

public class CollectionMain04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Student> list = new ArrayList<>();
		Score score = new Score();
		Student student = new Student();
		
		// 학생 정보(이름, 점수) 3개 입력받아 list에 저장
		// 학생 정보를 입력받는다. 입력받은 정보를 Student 객체에 저장
		// 저장된 Student를 list에 추가한다.
		for (int i = 0; i < 3; i++){
			System.out.println("학생 이름 >");
			String name = sc.next();
			System.out.println("학생 수학 점수 >");
			int mat = sc.nextInt();
			System.out.println("학생 영어 점수 >");
			int eng = sc.nextInt();
			
			score = new Score(mat, eng);
			student = new Student(name, score);
			list.add(student);
		}
		
//		for (int i = 0; i < 3; i++){
//			System.out.println("학생 이름 >");
//			student.setName(sc.next());
//			System.out.println("학생 수학 점수 >");
//			score.setMath(sc.nextInt());
//			System.out.println("학생 영어 점수 >");
//			score.setEng(sc.nextInt());
//			student.setScore(score);
//			list.add(student);
//		}
		
		// 전체 데이터 검색(출력)
		for(int i = 0; i < list.size(); i++) {
			student = list.get(i);
			System.out.println("이름 : " + student.getName());
			System.out.println("수학 : " + student.getScore().getMath());
			System.out.println("영어 : " + student.getScore().getEng());
		}
		
		// 데이터 수정
		// -1번 인덱스의 학생의 정보를 변경
		// 예시) 이름 : 둘리
		// 		수학 : 100
		// 		영어 : 50
		String name = "둘리";
		int mat = 100;
		int eng = 50;
		score = new Score(mat, eng);
		student = new Student(name, score);
		list.set(1, student);
		
		
		// - 0번 인덱스 학생의 영어 점수만 변경
		System.out.println("0번 인덱스 학생 영어 점수 >");
		eng = sc.nextInt();
		score = new Score(mat, eng);
		student = new Student(name, score);
		list.set(0, student);
		
		
		// 변경된 리스트의 모든 데이터 출력
		for(int i = 0; i < list.size(); i++) {
			student = list.get(i);
			System.out.println("이름 : " + student.getName());
			System.out.println("수학 : " + student.getScore().getMath());
			System.out.println("영어 : " + student.getScore().getEng());
		}
		
		// 데이터 삭제 : 1번 인덱스 학생의 모든 정보 삭제
		list.remove(1);
		
		sc.close();
	} // end main()

} // end CollectionMain04
