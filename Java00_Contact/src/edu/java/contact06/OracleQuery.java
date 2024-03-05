package edu.java.contact06;

// JDBC에서 DB 접속에 사용될 상수들, SQL 문장들 정의
public interface OracleQuery {
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";
	
	// 데이터 등록
	// INSERT INTO EX_CONTACT
	// VALUES (CONTACT_SEQ.nextval, ?, ?, ?);
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME 
								+ " VALUES (CONTACT_SEQ.nextval, ?, ?, ?)";

	// SELECT * FROM EX_CONTACT WHERE CONTACT_ID = ?;
	public static final String SQL_SELECT_BY_CONTACT_ID =
			"SELECT * FROM " + TABLE_NAME + 
			" WHERE " + COL_CONTACT_ID + " = ?";
	
	
	public static final String SQL_SELECT_ALL = 
			"SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_CONTACT_ID;
	
	
	// 데이터 수정
	// UPDATE EX_CONTACT
	// SET NAME = ?, PHONE = ?, EMAIL = ?
	// WHERE CONTACT_ID = ?
	public static final String SQL_UPDATE = 
			"UPDATE " + TABLE_NAME + " SET " + 
					COL_NAME + " = ? , " +
					COL_PHONE + " = ? , " +
					COL_EMAIL + " = ? " +
					"WHERE " + COL_CONTACT_ID + " = ?";
	
	// 데이터 삭제
	// DELETE EX_CONTACT WHERE CONTACT_ID = ?
	public static final String SQL_DELETE = 
			"DELETE " + TABLE_NAME + " WHERE " + COL_CONTACT_ID + " = ?";

	
} // end OracleQuery
