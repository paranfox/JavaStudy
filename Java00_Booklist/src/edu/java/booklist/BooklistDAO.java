package edu.java.booklist;

import java.util.ArrayList;

public interface BooklistDAO {
		// 도서 전체 검색
		public abstract ArrayList<AdminVO> bookselect();
		
		// 도서 인덱스 검색
		public abstract BooklistVO bookselect(int index);
		
}
