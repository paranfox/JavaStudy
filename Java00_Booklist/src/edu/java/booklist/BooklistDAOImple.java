package edu.java.booklist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class BooklistDAOImple implements BooklistDAO, OracleQuery {
	// 1. private static 자기 자신 타입의 변수 선언
	private static BooklistDAOImple instance = null;

	// 2. private 생성자
	private BooklistDAOImple() { 
	} 

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static BooklistDAOImple getInstance() {
		if (instance == null) {
			instance = new BooklistDAOImple();
		}
		return instance;
	}

	@Override
	public ArrayList<AdminVO> bookselect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooklistVO bookselect(String bookname) {
		BooklistVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("bookselect()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_BOOKNAME);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOKSERVISE_BOOKNAME); // 로그

			pstmt.setString(1, bookname);

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);
			// 8. DB 서버가 보낸 경과 확인/처리
			while (rs.next()) {
				System.out.println("진입 성공");
				String booknamedb = rs.getString(2);
				System.out.println(1);
				String bookwriter = rs.getString(4);
				System.out.println(2);
				int bookprice = rs.getInt(5);
				System.out.println(3);

				vo = new BooklistVO(booknamedb, bookwriter, bookprice);
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

		return vo;
	}

}
