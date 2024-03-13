package edu.java.booklist;

import java.sql.Date;

public class BookTableVO { 

	String bookname ; // bookname 컬럼
	String userid ; // userid 컬럼
	Date bookserviceouttime ; // bookserviceouttime 컬럼
	String bookserviceinout ; // bookserviceinout 컬럼
	Date bookserviceintime ; // bookserviceintime 컬럼
	String bookwriter; // bookwriter 컬럼
	int bookrentalcount; //BOOK_RENTAL_COUNT 컬럼
	String bookcategory; // bookcategory 컬럼
	
	public BookTableVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookTableVO(String bookname, String userid, Date bookserviceouttime, String bookserviceinout,
			Date bookserviceintime) {
		super();
		this.bookname = bookname;
		this.userid = userid;
		this.bookserviceouttime = bookserviceouttime;
		this.bookserviceinout = bookserviceinout;
		this.bookserviceintime = bookserviceintime;
	}
	public BookTableVO(String bookname, String bookwriter, String bookcategory) {
		this.bookname = bookname;
		this.bookwriter = bookwriter;
		this.bookcategory = bookcategory;
	}
	public BookTableVO(String bookname, String bookwriter, int bookrentalcount) {
		this.bookname = bookname;
		this.bookwriter = bookwriter;
		this.bookrentalcount = bookrentalcount;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getBookserviceouttime() {
		return bookserviceouttime;
	}
	public void setBookserviceouttime(Date bookserviceouttime) {
		this.bookserviceouttime = bookserviceouttime;
	}
	public String getBookserviceinout() {
		return bookserviceinout;
	}
	public void setBookserviceinout(String bookserviceinout) {
		this.bookserviceinout = bookserviceinout;
	}
	public Date getBookserviceintime() {
		return bookserviceintime;
	}
	public void setBookserviceintime(Date bookserviceintime) {
		this.bookserviceintime = bookserviceintime;
	}
	public String getBookwriter() {
		return bookwriter;
	}
	public void setBookwriter(String bookwriter) {
		this.bookwriter = bookwriter;
	}
	public String getBookcategory() {
		return bookcategory;
	}
	public void setBookcategory(String bookcategory) {
		this.bookcategory = bookcategory;
	}
	public int getBookrentalcount() {
		return bookrentalcount;
	}
	public void setBookrentalcount(int bookrentalcount) {
		this.bookrentalcount = bookrentalcount;
	}
	@Override
	public String toString() {
		return "BookTableVO [bookname=" + bookname + ", userid=" + userid + ", bookserviceouttime=" + bookserviceouttime
				+ ", bookserviceinout=" + bookserviceinout + ", bookserviceintime=" + bookserviceintime
				+ ", bookwriter=" + bookwriter + ", bookcategory=" + bookcategory + ", bookrentalcount="
				+ bookrentalcount + "]";
	}

}
