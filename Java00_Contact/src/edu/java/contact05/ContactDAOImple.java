package edu.java.contact05;

import java.io.*;
import java.util.*;

public class ContactDAOImple implements ContactDAO {
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() throws Exception {
		initDataDir();
		initDataFile();
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

	// 데이터를 저장할 폴더와 파일 이름 정의
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data";

	// data 폴더의 contact.data 파일을 관리할 File 객체 선언
	private File dataDir; // mkdir() : 디렉토리를 생성하는 메소드, 성공하면 true, 실패하면 false
	private File dataFile; // mkdirs() : 상위디렉토리를 포함하여 생성하는 메소드.

	// TODO : data 폴더가 있는지 검사하고, 없으면 생성하는 함수 "../data/contact.data"
	private void initDataDir() {
		dataDir = new File(DATA_DIR);

		if (!dataDir.exists()) { // 폴더가 없으면
			System.out.println("폴더가 없습니다.");
			// mkdir() : 디렉토리를 생성하는 메소드, 성공하면 true, 실패하면 false
			// mkdirs() : 상위디렉토리를 포함하여 생성하는 메소드.
			if (dataDir.mkdirs()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
		} else { // 파일, 폴더가 있는 경우
			System.out.println("폴더가 이미 존재합니다.");

		}
	} // end initDataDir()

	// TODO : 데이터 파일이 존재하는지 검사하고,
	// 없는 경우 - 새로운 데이터 파일 생성
	// 있는 경우 - 기존 파일에서 데이터를 읽어서 ArrayList에 추가
	private void initDataFile() throws Exception {
		String filePath = DATA_DIR + File.separator + DATA_FILE; //"data/contact.data"
		dataFile = new File(filePath);

		if (!dataFile.exists()) {
			System.out.println("파일이 없습니다.");

			// createNewFile() : 새로운 빈 파일을 생성
			
				if (dataFile.createNewFile()) {
					System.out.println("파일 생성 성공");
				} else {
					System.out.println("파일 생성 실패");
				}
			
		} else {
			System.out.println("파일이 이미 존재합니다.");
			if(dataFile.length() != 0) {
				readDataFromFile();
			}
		}
	} // end initDataFile()

	// TODO : 멤버 변수 list 객체를 data\contact.data 파일에 저장(쓰기)
	private void writeDataToFile() {
		System.out.println("ArrayList<ContactDTO> 객체를 파일에 저장하는 코드");
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream(dataFile);
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);

			oout.writeObject(list);

			System.out.println("데이터 저장 완료");

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} // end wrtieDataToFile()

	// TODO : data\contact.data 파일에서 ArrayList 객체를 읽어와서
	// 멤버 변수 list에 저장(읽기)
	private void readDataFromFile() {
		System.out.println("readDataFromFile()");
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;

		try {
			System.out.println("try 내부");
			in = new FileInputStream(dataFile);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);

			list = (ArrayList<ContactDTO>) oin.readObject();
			System.out.println("데이터 불러옴");
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	} // end readDataFromFile()

	public int getCount() {
		return list.size();
	}

	@Override
	public int insert(ContactDTO dto) {
		System.out.println("insert()"); // 로그 찍기
		System.out.println("dto = " + dto);
		list.add(dto);
		writeDataToFile();
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public ArrayList<ContactDTO> select() {
		return list;
	}

	@Override
	public ContactDTO select(int index) {
		return list.get(index);
	}

	@Override
	public int update(int index, ContactDTO dto) {
		list.set(index, dto);
		writeDataToFile();
		return 1;
	}
	@Override
	public int delete(int index) { // 수박 겉할기
		list.remove(index);
		return 1;
	}
}
