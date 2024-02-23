package edu.java.contact03;

import java.io.*;
import java.util.*;

public class ContactDAOImple implements ContactDAO {
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

	// 나중에 DB에서 사용 할 것이지만 지금은 이렇게 사용
	private ArrayList<ContactDTO> list = new ArrayList<>();

	// 데이터를 저장할 폴더와 파일 이름 정의
	   private static final String DATA_DIR = "data";
	   private static final String DATA_FILE = "contact.data";
	//   private static final String TEST_DIR3 = 
//	          "date" + File.separator + "Study" + File.separator + "test3";
	   
	   // data 폴더의 contact.data 파일을 관리할 File 객체 선언
	   private File dataDir;
	   private File dataFile;
	   
	   // TODO : data 폴더가 있는지 검사하고, 없으면 생성하는 함수
	   private void initDataDir() {
//	      System.out.println(dataDir);
//	        System.out.println(dataFile);
//	        System.out.println(TEST_DIR3);
//	        
//	        File f = new File(TEST_DIR3); // 파일, 폴더를 다루기 위한 객체
//	      // exists() : 파일, 폴더 존재 여부 확인
//	        if(!f.exists()) { // 파일, 폴더가 없는 경우
//	         System.out.println("폴더가 없습니다.");
//	         //mkdir() : 디렉토리를 생성하는 메소드, 성공하면 true, 실패하면 false
//	         // mkdirs() : 상위디렉토리를 포함하여 생성하는 메소드.
//	         if(f.mkdirs()) {
//	            System.out.println("폴더 생성 성공");
//	         } else {
//	            System.out.println("폴더 생성 실패");
//	         }
//	      } else { // 파일, 폴더가 있는 경우
//	          System.out.println("폴더가 이미 존재합니다. ");
//	      }
	        
	   }// end initDataDir()
	   
	   // TODO 위치를 알 수 있는 메모 : 데이터 파일이 존재하는지 검사하고,
	   // 없는 경우 - 새로운 데이터 파일 생성
	   // 있는 경우 - 기존 파일에서 데이터를 읽어서 ArrayList에 추가
	   private void initDataFile() {
	      
	   } // end initDataFile()
	   
	   // TODO : 멤버 변수 list 객체를 data\contact.data 파일에 저장(쓰기)
	   private void writeDataToFile() {
	      
	   } // end writeDataToFile()
	   
	   // TODO : data\contact.data 파일에서 ArrayList 객체를 읽어와서
	   // 멤버 변수 list에 저장(읽기)
	   private void readDataFromFile() {
	      
	   } // end readDataFromFile()


	
	public int getCount() {
		return list.size();
	}

	@Override
	public int insert(ContactDTO dto) {
		System.out.println("insert()"); // 로그 찍기
		System.out.println("dto = " + dto);
		list.add(dto);
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public ArrayList<ContactDTO> select() {
		return list;
	} // end select()

	@Override
	public ContactDTO select(int index) {
		return list.get(index);
	}

	@Override
	public int update(int index, ContactDTO dto) {
		list.set(index, dto);
		return 1;
	}

	@Override
	public int delete(int index) {
		list.remove(index);
		return 1;
	}

} // end ContactDAOImple
