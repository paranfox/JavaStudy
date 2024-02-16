package edu.java.interface01;

public interface DataBaseQuery {
	// 인터페이스 멤버 변수 : public static final
	public static final int DATABASE_VERION = 1; // 인터페이스는 객체 생성 불가능 그렇기에 반드시 static이 필요함
//	int DATABASE_VERION = 1; //생략가능 하지만 이해를 위해선 전부 작성할 것

	// 인터페이스의 메소드 : public abstract
	public abstract int insert(String id, String pw); // 이것이 껍데기
	// 이걸 가져가서 너가 사용해~ 라는 것
	
} // end DataBaseQuery