package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import edu.java.file04.MemberVO;

public class FileMain07 {

	public static void main(String[] args) {
		/* 데이터 파일을 읽어서 ArrayList의 내용을 출력 */
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		try {
			in = new FileInputStream("temp/list.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			
			ArrayList<MemberVO> list = (ArrayList<MemberVO>) oin.readObject();

			
			for(MemberVO m : list) {
				System.out.println(m);
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

} // end FileMain07