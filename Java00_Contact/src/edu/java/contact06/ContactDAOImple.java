package edu.java.contact06;

import java.sql.*;
import java.util.*;

import oracle.jdbc.driver.OracleDriver;

public class ContactDAOImple implements ContactDAO {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // select query 결과 저장할 클래스

	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() throws Exception {
		initDataDir();
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() throws Exception {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	// 파일 연동을 위해 사용
	private ArrayList<ContactDTO> list = new ArrayList<>(); // 연락처 정보를 저장할 배열

	private void initDataDir() {
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // end initDataDir()

	public int getCount() {
		int count = 0;

		String SQL_MAX_COUNT = "SELECT MAX(CONTACT_ID) FROM " + TABLE_NAME;

		try {
			
			pstmt = conn.prepareStatement(SQL_MAX_COUNT);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1); // 첫 번째 열의 값(MAX(COUNT))을 가져옴
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	@Override
	public int insert(ContactDTO dto) {
		System.out.println("insert()"); // 로그 찍기
		System.out.println("dto = " + dto);
		System.out.println("JDBC 5 - 입력받은 데이터를 쿼리에 적용하여 insert");
		String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?)";
		try {
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
			int result = pstmt.executeUpdate();

			// 8. DB 서버가 보낸 경과 확인/처리
			System.out.println(result + "행이 삽입되었습니다.");

			System.out.println("데이터 저장 완료");

		} catch (Exception e) {
			e.toString();
		} finally {

		}
		return 1;
	}

	@Override
	public ArrayList<ContactDTO> select() {
		try {
			 // 리스트를 초기화
		    list = new ArrayList<>();
		    
			String sql_select = "SELECT * FROM " + TABLE_NAME + // 테이블명을 한번에 바꾸기 위해서 이렇게 사용
					" ORDER BY " + COL_CONTACT_ID;
			pstmt = conn.prepareStatement(sql_select);

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

		}
		return list;
	}

	@Override
	public ContactDTO select(int index) {
		try {
			 // 리스트를 초기화
		    list = new ArrayList<>();
			String SQL_SELECT_BY_CONTACT_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_CONTACT_ID + " = ?";
			pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);

			System.out.println("인덱스 입력>");
			int contactId = index;

			pstmt.setInt(1, contactId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString(2); // NAME 컬럼
				String phone = rs.getString(3); // PHONE 컬럼
				String email = rs.getString(4); // EMAIL 컬럼

				ContactDTO dto = new ContactDTO(contactId, name, phone, email);
//						System.out.println(vo);
				list.add(dto);
				return dto;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return list.get(index);
	}

	@Override
	public int update(int index, ContactDTO dto) {
		try {
			String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET " + COL_NAME + " = ?, " + COL_PHONE + " = ?, "
					+ COL_EMAIL + " = ? " + "WHERE " + COL_CONTACT_ID + " = ?";
			pstmt = conn.prepareStatement(SQL_UPDATE);

			// 6. SQL 문장 완성 = SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getEmail());
			pstmt.setInt(4, index);
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			int result = pstmt.executeUpdate();

			// 8. DB 서버가 보낸 경과 확인/처리
			System.out.println(result + "행이 수정되었습니다.");
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return 1;
	}

	@Override
	public int delete(int index) {
		String SQL_DELETE = "DELETE " + TABLE_NAME + " WHERE " + COL_CONTACT_ID + " = ?";
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);

			pstmt.setInt(1, index);
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			int result = pstmt.executeUpdate();

			// 8. DB 서버가 보낸 경과 확인/처리
			System.out.println(result + "행이 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
}
