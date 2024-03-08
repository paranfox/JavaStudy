package edu.java.contact06;

import java.sql.*;
import java.util.*;

import oracle.jdbc.driver.OracleDriver;

public class ContactDAOImple implements ContactDAO, OracleQuery {

	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() {
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	// 전체 검색 데이터 list에서 size를 리턴
	public int getSize() {
		return select().size();
	}

	@Override
	public int insert(ContactDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println("insert()"); // 로그 찍기
		System.out.println("dto = " + dto);
		System.out.println("JDBC 5 - 입력받은 데이터를 쿼리에 적용하여 insert");
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(SQL_INSERT);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getEmail());
			// SQL 쿼리의 ? 순서와 parameterIndex의 값을 동일하게 지정
			// 예시) ?가 첫 번째이면 parameterIndex = 1

			// setInt() : DB의 Number 타입
			// setString() : DB의 varchar, varchar2 타입
			// setFloat() : DB의 Float 타입
			// setDate() : DB의 Date 타입

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
	} // end insert

	@Override
	public ArrayList<ContactDTO> select() {
		ArrayList<ContactDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select query 결과 저장할 클래스

		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int contactId = rs.getInt(1); // COMTACT_ID 컬럼
				String name = rs.getString(2); // NAME 컬럼
				String phone = rs.getString(3); // PHONE 컬럼
				String email = rs.getString(4); // EMAIL 컬럼

				ContactDTO dto = new ContactDTO(contactId, name, phone, email);
//						System.out.println(vo);
				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public ContactDTO select(int contactId) {
		ContactDTO dto = new ContactDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select query 결과 저장할 클래스
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);

			pstmt.setInt(1, contactId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				contactId = rs.getInt(1); // CONTACT_ID 컬럼
				String name = rs.getString(2); // NAME 컬럼
				String phone = rs.getString(3); // PHONE 컬럼
				String email = rs.getString(4); // EMAIL 컬럼

				dto = new ContactDTO(contactId, name, phone, email);
//						System.out.println(vo);
				return dto;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public int update(int contactId, ContactDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_UPDATE);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getEmail());
			pstmt.setInt(4, contactId);
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			int result = pstmt.executeUpdate();

			// 8. DB 서버가 보낸 경과 확인/처리
			System.out.println(result + "행이 수정되었습니다.");
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return 1;
	}

	@Override
	public int delete(int contactId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_DELETE);

			pstmt.setInt(1, contactId);
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			int result = pstmt.executeUpdate();

			// 8. DB 서버가 보낸 경과 확인/처리
			System.out.println(result + "행이 수정되었습니다.");
		} catch (SQLException e) {
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return 1;
	}
}
