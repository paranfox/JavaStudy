package edu.java.interface01;

// 예) 테스트 팀에서 임시 테스트용으로 사용
public class DummyImple implements DataBaseQuery { 

	@Override
	public int insert(String id, String pw) { // 무조건 몸통을 만들어 주어야 하니 강제성을 띄운다.
		// TODO Auto-generated method stub
		return 0;
	}

}
