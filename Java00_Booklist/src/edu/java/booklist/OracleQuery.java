package edu.java.booklist;

//JDBC에서 DB 접속에 사용될 상수들, SQL 문장들 정의
public interface OracleQuery {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_ADMIN = "ADMIN";
	public static final String COL_ADMIN_CODE = "ADMIN_CODE";
	public static final String COL_ADMIN_ID = "ADMIN_ID";
	public static final String COL_ADMIN_PASSWORD = "ADMIN_PASSWORD";

	public static final String TABLE_USERS = "USERS";
	public static final String COL_USER_CODE = "USER_CODE";
	public static final String COL_USER_ID = "USER_ID";
	public static final String COL_USER_NAME = "USER_NAME";
	public static final String COL_USER_PASSWORD = "USER_PASSWORD";
	public static final String COL_USER_PHONE = "USER_PHONE";
	public static final String COL_USER_EMAIL = "USER_EMAIL";
	public static final String COL_USER_GENDER = "USER_GENDER";
	public static final String COL_USER_BIRTH_DATE = "USER_BIRTH_DATE";

	public static final String TABLE_BOOKLIST = "BOOKLIST";
	public static final String COL_BOOK_ID = "BOOK_ID";
	public static final String COL_BOOK_NAME = "BOOK_NAME";
	public static final String COL_BOOK_CATEGORY_ID = "BOOK_CATEGORY_ID";

	public static final String TABLE_BOOKSERVICE = "BOOKSERVICE";
	public static final String COL_BOOK_CATEGORY = "BOOK_CATEGORY";
//	public static final String COL_FK_USER_CODE = "USER_CODE";  어떤 태리클에 외래키로 잡음
	
	public static final String TABLE_BOOKCATEGORY = "BOOKCATEGORY";
	public static final String COL_BOOK_SERVICE_INOUT = "BOOK_SERVICE_INOUT";
	public static final String COL_BOOK_SERVICE_OUTTIME = "BOOK_SERVICE_OUTTIME";
	public static final String COL_BOOK_SERVICE_INTIME = "BOOK_SERVICE_INTIME";
//  join 사용이 테이블 이름과 컬럼 이름
	public static final String TABLE_USERS_U = "USERS U";
	public static final String TABLE_BOOK_LIST_BL = "BOOKLIST BL";
	public static final String TABLE_BOOK_SERVICE_BS = "BOOKSERVICE BS";
	public static final String COL_USERS_U_USER_CODE = "U.USER_CODE";
	public static final String COL_USERS_U_USER_ID = "U.USER_ID";
	public static final String COL_BOOK_LIST_BL_BOOK_NAME = "BL.BOOK_NAME";
	public static final String COL_BOOK_LIST_BL_BOOK_ID = "BL.BOOK_ID";
	public static final String COL_BOOK_SERVICE_BS_USER_CODE = "BS.USER_CODE";
	public static final String COL_BOOK_SERVICE_BS_BOOK_ID = "BS.BOOK_ID";
	public static final String COL_BOOK_SERVICE_BS_BOOK_SERVICE_OUTTIME = "BS.BOOK_SERVICE_OUTTIME";
	public static final String COL_BOOK_SERVICE_BS_BOOK_SERVICE_INOUT = "BS.BOOK_SERVICE_INOUT";
	public static final String COL_BOOK_SERVICE_BS_BOOK_SERVICE_INTIME = "BS.BOOK_SERVICE_INTIME";
	
	// 유저 회원가입
	public static final String SQL_USER_INSERT = "INSERT INTO " + TABLE_USERS + " ( " + 
			COL_USER_CODE + " , " + COL_USER_ID + " , " + COL_USER_PASSWORD + " , " + 
			COL_USER_NAME + " ) " + " VALUES (USER_SEQ.nextval, ?, ?, ?)";

	// 유저 로그인
	public static final String SQL_USER_CHECK = "SELECT * FROM " +
			TABLE_USERS + " WHERE " + COL_USER_ID + " = ?";

	// 유저 이름
	public static final String SQL_USER_NAME = "SELECT " + COL_USER_NAME + " FROM "
			+ TABLE_USERS + " WHERE " + COL_USER_ID + " = ?";

	// 책에 관련한 모든 정보 잦기 (도서 제목과 회원명을 같이)
	public static final String SQL_BOOKSERVISE_SELET_BOOKNAME_USERNAME = 
//			"SELECT " + COL_BOOK_LIST_BL_BOOK_NAME + " , " + COL_USERS_U_USER_ID + " , " +
//			COL_BOOK_SERVICE_BS_BOOK_SERVICE_OUTTIME + " , " + COL_BOOK_SERVICE_BS_BOOK_SERVICE_INOUT + 
//			" , " + COL_BOOK_SERVICE_BS_BOOK_SERVICE_INTIME +
//			" FROM " + TABLE_BOOK_SERVICE_BS +
//			" JOIN " + TABLE_BOOK_LIST_BL + " ON " + COL_BOOK_SERVICE_BS_BOOK_ID + " = " + COL_BOOK_LIST_BL_BOOK_ID +
//			" JOIN " + TABLE_USERS_U + " ON " + COL_BOOK_SERVICE_BS_USER_CODE + " = " + COL_USERS_U_USER_CODE;
	
	"SELECT " + COL_BOOK_NAME + " , " + COL_USER_ID + " , " +
	COL_BOOK_SERVICE_OUTTIME + " , " + COL_BOOK_SERVICE_INOUT + 
	" , " + COL_BOOK_SERVICE_INTIME +
	" FROM " + TABLE_BOOKSERVICE +
	" BS JOIN " + TABLE_BOOKLIST + " BL ON BS." + COL_BOOK_ID + " = BL." + COL_BOOK_ID +
	" JOIN " + TABLE_USERS + " U ON BS." + COL_USER_CODE + " = U." + COL_USER_CODE;
	
			
	
	// 책에 관련한 모든 정보 잦기 (도서 제목)
	public static final String SQL_DELETE1 = "";
	
	// 책에 관련한 모든 정보 잦기 (회원명)
	public static final String SQL_DELETE2 = "";
	
	// 책에 
	public static final String SQL_DELETE3 = "";

	// 책에 관
	public static final String SQL_DELETE4 = "";
	
} // end OracleQuery