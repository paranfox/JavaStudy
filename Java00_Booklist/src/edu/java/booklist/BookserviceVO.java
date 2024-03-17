package edu.java.booklist;

public class BookserviceVO {
	private int BookServiceInout; // 도서 대여상태
	private String BookServiceOuttime; // 도서 대여시간
	private String BookServiceIntime; // 도서 반납시간
	public BookserviceVO() { 
		super();
		// TODO Auto-generated constructor stub
	} 
	public BookserviceVO(int bookServiceInout, String bookServiceOuttime, String bookServiceIntime) {
		super();
		BookServiceInout = bookServiceInout;
		BookServiceOuttime = bookServiceOuttime;
		BookServiceIntime = bookServiceIntime;
	}
	public int getBookServiceInout() {
		return BookServiceInout;
	}
	public void setBookServiceInout(int bookServiceInout) {
		BookServiceInout = bookServiceInout;
	}
	public String getBookServiceOuttime() {
		return BookServiceOuttime;
	}
	public void setBookServiceOuttime(String bookServiceOuttime) {
		BookServiceOuttime = bookServiceOuttime;
	}
	public String getBookServiceIntime() {
		return BookServiceIntime;
	}
	public void setBookServiceIntime(String bookServiceIntime) {
		BookServiceIntime = bookServiceIntime;
	}
	@Override
	public String toString() {
		return "BookserviceVO [BookServiceInout=" + BookServiceInout + ", BookServiceOuttime=" + BookServiceOuttime
				+ ", BookServiceIntime=" + BookServiceIntime + "]";
	}
	
	
} // end BookserviceVO
