package edu.java.booklist;

import java.sql.Date;

public class BookTableVO {

	String bookname ; // COMTACT_ID 컬럼
	String userid ; // COMTACT_ID 컬럼
	Date bookserviceouttime ; // COMTACT_ID 컬럼
	String bookserviceinout ; // COMTACT_ID 컬럼
	Date bookserviceintime ; // COMTACT_ID 컬럼
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
	@Override
	public String toString() {
		return "BookTableVO [bookname=" + bookname + ", userid=" + userid + ", bookserviceouttime=" + bookserviceouttime
				+ ", bookserviceinout=" + bookserviceinout + ", bookserviceintime=" + bookserviceintime + "]";
	}
	

}
