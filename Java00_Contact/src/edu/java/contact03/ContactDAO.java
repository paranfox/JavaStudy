package edu.java.contact03;

import java.util.ArrayList;

public interface ContactDAO {
	// 연락처 정보 등록
	public abstract int insert(ContactDTO dto);

	// 연락처 정보 전체 검색
	public abstract ArrayList<ContactDTO> select();
	
	// 연락처 정보 인덱스 검색
	public abstract ContactDTO select(int index);

	// 연락처 정보 인덱스 수정
	public abstract int update(int index, ContactDTO dto);
	
	// 연락처 삭제 인덱스
	public abstract int delete(int index);
	
} // end ContactDAO
