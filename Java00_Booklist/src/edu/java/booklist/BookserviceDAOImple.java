package edu.java.booklist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class BookserviceDAOImple implements BookserviceDAO, OracleQuery {
	// 1. private static 자기 자신 타입의 변수 선언
	private static BookserviceDAOImple instance = null;

	// 2. private 생성자
	private BookserviceDAOImple() {
	} // 초기값

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static BookserviceDAOImple getInstance() {
		if (instance == null) {
			instance = new BookserviceDAOImple();
		}
		return instance;
	} // end getInstance()
	
	private ArrayList<BookTableVO> list = null;
	
	public int getsize() {
		return list.size();
	}

	@Override
	public BooklistVO bookinoutselect(int index) {
		// TODO Auto-generated method stub
		return null;
	} // end bookinoutselect

	@Override
	public BooklistVO bookouttime(int index) {
		// TODO Auto-generated method stub
		return null;
	} // end bookouttime()

	@Override
	public BooklistVO bookintime(int index) {
		// TODO Auto-generated method stub
		return null;
	} // end bookintime()

	@Override
	public int bookoutuser(int index) {
		// TODO Auto-generated method stub
		return 0;
	} // end bookoutuser()

	@Override
	public ArrayList<BookTableVO> bookallselect() {
		list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("bookallselect()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_ALL_SELET_BOOKNAME_USERNAME);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOKSERVISE_ALL_SELET_BOOKNAME_USERNAME); // 로그

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);
			// 8. DB 서버가 보낸 경과 확인/처리
			while (rs.next()) {
				System.out.println("진입 성공");
				String bookname = rs.getString(1); 
				System.out.println(1);
				String username = rs.getString(2);
				System.out.println(2);
				Date bookserviceouttime = rs.getDate(3);
				System.out.println(3);
				String bookserviceinout = rs.getString(4); 
				System.out.println(4);
				Date bookserviceintime = rs.getDate(5); 
				System.out.println(5);
				
				BookTableVO vo = new BookTableVO(bookname, username, bookserviceouttime, bookserviceinout, bookserviceintime);
				list.add(vo);
				System.out.println("list 추가 성공");
				System.out.println(vo);
			}

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return list;
	} // end bookallselect()

	@Override
	public ArrayList<BookTableVO> searchbookusername(String serch) {
		list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("searchbookusername()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_SELET_BOOKNAME_USERNAME);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOKSERVISE_SELET_BOOKNAME_USERNAME); // 로그
			
			pstmt.setString(1, serch);
			pstmt.setString(2, serch);

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);
			// 8. DB 서버가 보낸 경과 확인/처리
			while (rs.next()) {
				System.out.println("진입 성공");
				String bookname = rs.getString(1); 
				System.out.println(1);
				String username = rs.getString(2);
				System.out.println(2);
				Date bookserviceouttime = rs.getDate(3);
				System.out.println(3);
				String bookserviceinout = rs.getString(4); 
				System.out.println(4);
				Date bookserviceintime = rs.getDate(5); 
				System.out.println(5);
				
				BookTableVO vo = new BookTableVO(bookname, username, bookserviceouttime, bookserviceinout, bookserviceintime);
				list.add(vo);
				System.out.println("list 추가 성공");
				System.out.println(vo);
			}

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return list;
	} // end searchbookusername()

	@Override
	public ArrayList<BookTableVO> searchbookname(String serch) {
		list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("searchbookname()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_SELET_BOOKNAME);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOKSERVISE_SELET_BOOKNAME); // 로그
			
			pstmt.setString(1, serch);

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);
			// 8. DB 서버가 보낸 경과 확인/처리
			while (rs.next()) {
				System.out.println("진입 성공");
				String bookname = rs.getString(1); 
				System.out.println(1);
				String username = rs.getString(2);
				System.out.println(2);
				Date bookserviceouttime = rs.getDate(3);
				System.out.println(3);
				String bookserviceinout = rs.getString(4); 
				System.out.println(4);
				Date bookserviceintime = rs.getDate(5); 
				System.out.println(5);
				
				BookTableVO vo = new BookTableVO(bookname, username, bookserviceouttime, bookserviceinout, bookserviceintime);
				list.add(vo);
				System.out.println("list 추가 성공");
				System.out.println(vo);
			}

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return list;
	} // end searchbookname()

	@Override
	public ArrayList<BookTableVO> searchusername(String serch) {
		list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("searchusername()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_SELET_USERNAME);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOKSERVISE_SELET_USERNAME); // 로그
			
			pstmt.setString(1, serch);

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);
			// 8. DB 서버가 보낸 경과 확인/처리
			while (rs.next()) {
				System.out.println("진입 성공");
				String bookname = rs.getString(1); 
				System.out.println(1);
				String username = rs.getString(2);
				System.out.println(2);
				Date bookserviceouttime = rs.getDate(3);
				System.out.println(3);
				String bookserviceinout = rs.getString(4); 
				System.out.println(4);
				Date bookserviceintime = rs.getDate(5); 
				System.out.println(5);
				
				BookTableVO vo = new BookTableVO(bookname, username, bookserviceouttime, bookserviceinout, bookserviceintime);
				list.add(vo);
				System.out.println("list 추가 성공");
				System.out.println(vo);
			}

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return list;
	} // end searchusername()

} // BookserviceDAOImple
