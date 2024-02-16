package edu.java.contact02;

public interface ContactDAO {
	// 연락처 정보 등록
	public abstract int insert(ContactDTO dto);

	// 연락처 정보 전체 검색
	public abstract ContactDTO[] select();
	
	// 연락처 정보 인덱스 검색
	public abstract ContactDTO select(int index);

	// 연락처 정보 인덱스 수정
	public abstract int update(int index, ContactDTO dto);
	
} // end ContactDAO
