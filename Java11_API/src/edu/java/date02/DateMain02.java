package edu.java.date02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMain02 {

	public static void main(String[] args) {
		// 날짜를 원하는 형식(format)으로 출력
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		// yy or yyyy : 년도 표현
		// MM : 월 표현
		// dd : 일 표현
		// hh : 시간 표현
		// mm : 분 표현
		// ss : 초 표현
		String dateString = sdf.format(currentDate);
		System.out.println(dateString);
		
		sdf = new SimpleDateFormat("yy-MM-dd");
		dateString = sdf.format(currentDate);
		System.out.println(dateString);

	} // end main()

} // end DateMain02
