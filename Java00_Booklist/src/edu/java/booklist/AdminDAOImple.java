package edu.java.booklist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class AdminDAOImple implements AdminDAO, OracleQuery { 
	// 1. private static 자기 자신 타입의 변수 선언
	private static AdminDAOImple instance = null;

	// 2. private 생성자
	private AdminDAOImple() {
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static AdminDAOImple getInstance() {
		if (instance == null) {
			instance = new AdminDAOImple();
		}
		return instance;
	}
	
	@Override
	public int admincheck(String chackid) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("admincheck()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_SELETE_USER_ADMIN);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, chackid);
			System.out.println(SQL_SELETE_USER_ADMIN); // 로그

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
			
			// 8. DB 서버가 보낸 경과 확인/처리
			if (rs.next()) {
				result = 1;
			} else {
				result = 0;
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

		return result;
	} // end admincheck()
	
	@Override
	public int login(AdminVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("login()"); // 로그 찍기
		System.out.println("vo = " + vo);
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_ADMIN_CHECK);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, vo.getAdminId());
			System.out.println(vo.getAdminId());
			System.out.println(SQL_ADMIN_CHECK); // 로그

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();

			// 8. DB 서버가 보낸 경과 확인/처리
			if (rs.next()) {
				System.out.println("성공");
				String userpassword = rs.getString(3);
				System.out.println(vo.getAdminpassword());
				if (userpassword.equals(vo.getAdminpassword())) {
					System.out.println("로그인 성공");
					result = 1;
				} else {
					result = 0;
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

		return result;
	} // end login()

	@Override
	public int Logout(AdminVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AdminVO adminselect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminUpdate(AdminVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bookinsert(BooklistVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bookupdate(int index, BooklistVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bookdelete(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<UserVO> adminuserallselect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminuserdelete(int index, UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
