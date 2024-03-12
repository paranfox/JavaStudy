package edu.java.booklist;

public class BooklistVO { 
	// 멤버 변수(필드, 프로퍼티)
	private int BookId; // 도서 인덱스
	private String BookName; // 도서 이름
	private int BookCategory; // 도서 카테고리
	private String BookWriter; // 도서 저자
	private int BookPrice; // 도서 가격
	
	public BooklistVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BooklistVO(int bookId, String bookName, int bookCategory) {
		super();
		BookId = bookId;
		BookName = bookName;
		BookCategory = bookCategory;
	}
	public BooklistVO(String BookName, String BookWriter, int BookPrice) {
		this.BookName = BookName;
		this.BookWriter = BookWriter;
		this.BookPrice = BookPrice;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public int getBookCategory() {
		return BookCategory;
	}
	public void setBookCategory(int bookCategory) {
		BookCategory = bookCategory;
	}
	public String getBookWriter() {
		return BookWriter;
	}
	public void setBookWriter(String bookWriter) {
		BookWriter = bookWriter;
	}
	public int getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(int bookPrice) {
		BookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "BookslistVO [BookId=" + BookId + ", BookName=" + BookName + ", BookCategory=" + BookCategory + "]";
	}
	
	
	
} // end BookslistVO
