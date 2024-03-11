package edu.java.booklist;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import oracle.jdbc.driver.OracleDriver;

public class UserDAOImple implements UserDAO, OracleQuery {
	// 1. private static 자기 자신 타입의 변수 선언
	private static UserDAOImple instance = null;

	// 2. private 생성자
	private UserDAOImple() { 
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static UserDAOImple getInstance() {
		if (instance == null) {
			instance = new UserDAOImple();
		}
		return instance;
	}

	@Override
	public int userinsert(UserVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println("insert()"); // 로그 찍기
		System.out.println("vo = " + vo);
		System.out.println("JDBC 5 - 입력받은 데이터를 쿼리에 적용하여 insert");
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_USER_INSERT);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserpassword());
			pstmt.setString(3, vo.getUsername());

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();

			// 8. DB 서버가 보낸 경과 확인/처리
			System.out.println(result + "행이 삽입되었습니다.");

			System.out.println("데이터 저장 완료");

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return result;
	} // end userinsert()

	@Override
	public UserVO userselect(String name) {
		UserVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("userselect()"); // 로그 찍기
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_BOOKSERVISE_USERNAME);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			System.out.println(SQL_BOOKSERVISE_USERNAME); // 로그

			pstmt.setString(1, name);

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
//			String bookname1 = rs.getString(1);
//			System.out.println(bookname1);
			// 8. DB 서버가 보낸 경과 확인/처리
			while (rs.next()) {
				System.out.println("진입 성공");
				String username = rs.getString(3);
				System.out.println(1);
				String userphone = rs.getString(5);
				System.out.println(2);
				Date userbirthdate = rs.getDate(8);
				System.out.println(3);

				vo = new UserVO(username, userphone, userbirthdate);
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
	} // end userselect()

	@Override
	public int userupdate(int index, UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	} // end userupdate()

	@Override
	public int userdelete(int index) {
		// TODO Auto-generated method stub
		return 0;
	} // end userdelete()

	@Override
	public ArrayList<BooklistVO> userbookallselect() {
		// TODO Auto-generated method stub
		return null;
	} // end userbookallselect()

	@Override
	public int usercheck(UserVO vo) { // 유저 로그인
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("usercheck()"); // 로그 찍기
		System.out.println("vo = " + vo);
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_USER_CHECK);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, vo.getUserId());
			System.out.println(vo.getUserId());
			System.out.println(SQL_USER_CHECK); // 로그

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();

			// 8. DB 서버가 보낸 경과 확인/처리
			if (rs.next()) {
				System.out.println("성공");
				String userpassword = rs.getString(4); // COMTACT_ID 컬럼
				System.out.println(vo.getUserpassword());
				if (userpassword.equals(vo.getUserpassword())) {
					System.out.println("로그인 성공");
					result = 1;
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
	} // end usercheck()

	@Override
	public String username(String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String user_name = null;

		System.out.println("username()"); // 로그 찍기
		System.out.println("user_id = " + user_id);
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_USER_NAME);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, user_id);
			System.out.println(SQL_USER_NAME); // 로그

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();

			// 8. DB 서버가 보낸 경과 확인/처리
			if (rs.next()) {
				System.out.println("성공");
				user_name = rs.getString(1); // COMTACT_ID 컬럼

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
		return user_name;
	}

	@Override
	public int userinsert2(UserVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println("insert()"); // 로그 찍기
		System.out.println("vo = " + vo);
		System.out.println("JDBC 5 - 입력받은 데이터를 쿼리에 적용하여 insert");
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_USER_INSERT_1);
			System.out.println(1);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, vo.getUsername());
			System.out.println(2);
			pstmt.setString(2, vo.getUserId());
			System.out.println(3);
			pstmt.setString(3, vo.getUserpassword());
			System.out.println(4);
			pstmt.setString(4, vo.getUserphone());
			System.out.println(5);
			pstmt.setString(5, vo.getUseremail());
			System.out.println(6);
			pstmt.setString(6, vo.getUsergenser());
			System.out.println(7);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = dateFormat.format(vo.getUserbirthdate());
			java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);
			pstmt.setDate(7, sqlDate);
			System.out.println(sqlDate);

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();
			System.out.println(9);
			// 8. DB 서버가 보낸 경과 확인/처리
			System.out.println(result + "행이 삽입되었습니다.");

			System.out.println("데이터 저장 완료");

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return result;
	}

}
