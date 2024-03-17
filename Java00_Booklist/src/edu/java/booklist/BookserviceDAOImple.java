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
	public static String user = null;
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
	public int bookinoutselect(String bookname) {
		user = bookname;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int bookrentalcount = 0;
		System.out.println("bookinoutselect()"); // 로그 찍기

		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_SELET_BOOK_INOUT);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOKSERVISE_SELET_BOOK_INOUT); // 로그

			pstmt.setString(1, bookname);
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);
			// 8. DB 서버가 보낸 경과 확인/처리
			if (rs.next()) {
				System.out.println("진입 성공");
				bookrentalcount = rs.getInt(1);

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

		return bookrentalcount;
	} // end bookinoutselect

	@Override
	public ArrayList<BookTableVO> bookouttime(String bookname, String user_id) {
		list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("bookouttime()"); // 로그 찍기

		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			System.out.println(bookname);
			System.out.println(user_id);
			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOK_RENTAL_USER);
			System.out.println(1);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOK_RENTAL_USER); // 로그

			pstmt.setString(1, user_id);
			System.out.println(1);
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
			System.out.println(1);
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);

			// 8. DB 서버가 보낸 경과 확인/처리
			while (rs.next()) {
				System.out.println("진입 성공");
				String bookname1 = rs.getString(1);
				System.out.println(1);
				String username = rs.getString(2);
				System.out.println(2);
				Date bookserviceouttime = rs.getDate(3);
				System.out.println(3);
				String bookserviceinout = rs.getString(4);
				System.out.println(4);
				Date bookserviceintime = rs.getDate(5);
				System.out.println(5);

				BookTableVO vo = new BookTableVO(bookname1, username, bookserviceouttime, bookserviceinout,
						bookserviceintime);
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
	} // end bookouttime()

	@Override
	public BookTableVO bookintime(int index) {

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

				BookTableVO vo = new BookTableVO(bookname, username, bookserviceouttime, bookserviceinout,
						bookserviceintime);
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

				BookTableVO vo = new BookTableVO(bookname, username, bookserviceouttime, bookserviceinout,
						bookserviceintime);
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

				BookTableVO vo = new BookTableVO(bookname, username, bookserviceouttime, bookserviceinout,
						bookserviceintime);
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

				BookTableVO vo = new BookTableVO(bookname, username, bookserviceouttime, bookserviceinout,
						bookserviceintime);
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

	@Override
	public ArrayList<BookTableVO> bookallselectwriter(String userid) {
		list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("bookallselectwriter()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_ALL_SELET_BOOKNAME_WRITERNAME);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOKSERVISE_ALL_SELET_BOOKNAME_WRITERNAME); // 로그

			pstmt.setString(1, userid);
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
//			String bookname1 = rs.getString(1);
//			System.out.println(userid);
			// 8. DB 서버가 보낸 경과 확인/처리
			while (rs.next()) {
				System.out.println("진입 성공");
				String bookname = rs.getString(1);
				System.out.println(1);
				String writername = rs.getString(2);
				System.out.println(2);
				Date bookserviceouttime = rs.getDate(3);
				System.out.println(3);
				String bookserviceinout = rs.getString(4);
				System.out.println(4);
				Date bookserviceintime = rs.getDate(5);
				System.out.println(5);

				BookTableVO vo = new BookTableVO(bookname, writername, bookserviceouttime, bookserviceinout,
						bookserviceintime);
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
	} // end bookallselectwriter()

	@Override
	public ArrayList<BookTableVO> searchbookchoice(String selectchoice, String serch) {
		// choice를 사용하여 검색 결과를 찾기
		String SQL_SELECT_CHOICE_BOOK_LIST = "SELECT * FROM " + TABLE_BOOKLIST + " WHERE  " + selectchoice + "  = ?";
		list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("searchbookchoice()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_SELECT_CHOICE_BOOK_LIST);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_SELECT_CHOICE_BOOK_LIST); // 로그

			pstmt.setString(1, serch);
			System.out.println(1);
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
			System.out.println(1);
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);
			// 8. DB 서버가 보낸 경과 확인/처리
			while (rs.next()) {
				System.out.println("진입 성공");
				String bookname = rs.getString(2);
				System.out.println(1);
				String writername = rs.getString(4);
				System.out.println(1);
				String bookcategory = rs.getString(3);
				System.out.println(1);

				BookTableVO vo = new BookTableVO(bookname, writername, bookcategory);
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
	} // end searchbookchoice()

	@Override
	public BookTableVO searchallbookname(String searchbookname) {
		BookTableVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("searchallbookname()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_SELET_BOOK_NAME);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOKSERVISE_SELET_BOOK_NAME); // 로그

			pstmt.setString(1, searchbookname);

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);
			// 8. DB 서버가 보낸 경과 확인/처리
			if (rs.next()) {
				System.out.println("진입 성공");
				String bookname = rs.getString(2);
				System.out.println(2);
				String writername = rs.getString(4);
				System.out.println(4);
				int bookrentalcount = rs.getInt(6);
				System.out.println(6);

				vo = new BookTableVO(bookname, writername, bookrentalcount);
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

		return vo;
	}

	@Override
	public Void bookouttimeuser(String bookname, String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("bookouttime()"); // 로그 찍기

		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_BOOK_DELETE_RENTAL_USER);
			pstmt.setString(1, bookname);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement(SQL_BOOK_RENTAL_COUNT_DOWN);
			pstmt.setString(1, bookname);
			pstmt.setString(2, bookname);
			pstmt.executeUpdate();

			// 8. DB 서버가 보낸 경과 확인/처리

			System.out.println("진입 성공");

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_RENTAL_USER_OUT);
			pstmt.setString(1, bookname);
			pstmt.setString(2, user_id);
			pstmt.executeUpdate();

			// 8. DB 서버가 보낸 경과 확인/처리

			System.out.println("진입 성공");

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	} // end bookouttimeuser();

	@Override
	public int bookinoutcheck(String bookname, String user_id) {
		int check = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("bookinoutcheck()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOK_NOW_RENTAL_USER);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOK_NOW_RENTAL_USER); // 로그

			pstmt.setString(1, user_id);
			pstmt.setString(2, bookname);

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);
			// 8. DB 서버가 보낸 경과 확인/처리
			if (rs.next()) {
				System.out.println("진입 성공");
				String bookrentalcount = rs.getString(1);
				System.out.println(6);
				if (bookrentalcount.equals("대여")) {
					check = 1;
				} else if (bookrentalcount.equals("반납")) {
					check = 2;
				}

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

		return check;
	} // end bookinoutcheck()

	@Override
	public Void bookintime(String bookname, String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("bookintime()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
 
			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
		
			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOK_RENTAL_COUNT_DOWN);
			pstmt.setString(1, bookname);
			pstmt.setString(2, bookname);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
		
			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			
			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_RENTAL_USER_IN);
			pstmt.setString(1, bookname);
			pstmt.executeUpdate();
			

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;

	} // end bookintime()

} // BookserviceDAOImple
