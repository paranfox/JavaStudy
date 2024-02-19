package edu.java.date04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateMain04 {

	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar(2023, 1, 6);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String str = String.format("%d-%02d-%02d", year, month, day);
		System.out.println(str);
		
		System.out.println();
		// Calendar를 SimpleDateFormat으로 표현
		Calendar birth = new GregorianCalendar(1900, 0, 1);
		
		// 코드 한줄 작성
		Date date = birth.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String birthString = sdf.format(date);
		System.out.println(birthString);
				
	} // end main()

} // end DateMain04








