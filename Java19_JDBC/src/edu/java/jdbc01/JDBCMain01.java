package edu.java.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

//JDBC : Java DataBase Connection
//0. 데이터베이스 라이브러리를 프로젝트에 추가
//		1) 프로젝트에 lib 폴더를 생성
//		2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
//		폴더에 있는 ojdbc6.jar 파일을 프로젝트의 lib 폴더에 복사
//		3) 복사한 jar 파일(라이브러리)을 build path에 추가
//		(마우스 오른쪽 클릭 -> Build Path -> Add External Archives to Java Build Path
//		-> C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib -> ojdbc6.jar 파일 선택)
//1. 데이터 저장을 위한 DB 테이블 생성
//2. JDBC 드라이버를 메모리에 로드
//3. DB와 연동하기 위해 필요한 상수들을 정의
//4. DB와 Connection(연결)을 맺음
//5. Connection 객체를 사용하여 Statement 객체를 생성
//6. SQL 문장을 생성
//7. Statement 객체를 사용하여 SQL 문장을 실행(DB 서버로 SQL 문장을 전송)
//8. DB 서버가 보내준 결과를 확인/처리
// 정형화된 형태라서 여기다가 작성을 해두는 것

public class JDBCMain01 {
	// 3. DB와 연동하기 위해 필요한 상수들을 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	public static void main(String[] args) {
		System.out.println("JDBC 1 - insert");
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// 2. JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			stmt = conn.createStatement();
			
			// 6. SQL 문장 작성
//			INSERT INTO EX_CONTACT
//			VALUES (CONTACT_SEQ.NEXTVAL, 'MOK', '010-2222-2222', 'TEST@TEST.COM');
			String sql_insert = "INSERT INTO " + TABLE_NAME
					+ " VALUES (CONTACT_SEQ.NEXTVAL, 'MOK', '010-2222-2222', 'TEST@TEST.COM')"; // ;은 필요없음
			System.out.println(sql_insert);
			
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			int result = stmt.executeUpdate(sql_insert);
			
			// 8. DB 서버가 보낸 결과 처리/확인
			System.out.println(result + "행이 삽입되었습니다." );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		

	} // end Main()

} // end JDBCMain01
