package edu.java.file05;

import java.io.*;

import edu.java.file04.MemberVO;

// 프로그램 <=== ObjectInputStream <=== FileInputStream <=== 파일(HDD)

public class FileMain05 {

	public static void main(String[] args) {
		InputStream in = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream("temp/member.txt");
			oin = new ObjectInputStream(in);
			while (true) {
				try {

					MemberVO m = (MemberVO) oin.readObject(); // 강제형변환
					System.out.println(m);
				} catch (EOFException e) {
					break;
				}
			}

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

	} // end main()

} // end FileMain05
