package com.kh.exam13;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sample3 {

	public static void main(String[] args) {
		// 날짜 관련 클래스
		Date dt = new Date();
		
		// Fri Aug 20 16:55:40 KST 2021 형식으로 출력됨
		System.out.println(dt);
		
		// 1970년 1월 1일 0시 0분 0초 0밀리초 를 기준으로 얼마나 지났는지를 반환
		System.out.println(dt.getTime());
		
		String sDate = "%tY년";
		System.out.println(String.format(sDate, dt));
		
		sDate = "%tm월";
		System.out.println(String.format(sDate, dt));
		
		sDate = "%td일";
		System.out.println(String.format(sDate, dt));
		
		sDate = "%tH시";
		System.out.println(String.format(sDate, dt));
		
		sDate = "%tM분";
		System.out.println(String.format(sDate, dt));
		
		sDate = "%tS초";
		System.out.println(String.format(sDate, dt));
		
		sDate = "%tL밀리초";
		System.out.println(String.format(sDate, dt));
		
		// 캘린더 클래스
		Calendar cd = Calendar.getInstance();
		
		int year = cd.get(Calendar.YEAR);
		System.out.println(year + "년");
		
		int month = cd.get(Calendar.MONTH) + 1;
		System.out.println(month + "월");
		
		int date = cd.get(Calendar.DATE);
		System.out.println(date + "일");
		
		int hour = cd.get(Calendar.HOUR);
		System.out.println(hour + "시");
		
		int minute = cd.get(Calendar.MINUTE);
		System.out.println(minute + "분");
		
		int second = cd.get(Calendar.SECOND);
		System.out.println(second + "초");
		
		int millis = cd.get(Calendar.MILLISECOND);
		System.out.println(millis + "밀리초");
		
		System.out.println("현재 날짜 -> " + cd.getTime());
		
		cd.add(Calendar.YEAR, 1);
		System.out.println("다음 년도 -> " + cd.getTime());
		
		cd.setTime(new Date());
		cd.add(Calendar.MONTH, 2);
		System.out.println("2달 뒤 -> " + cd.getTime());
		
		cd.setTime(new Date());
		cd.add(Calendar.DATE, -7);
		System.out.println("일주일 전 -> " + cd.getTime());
		
		// 그레고리안 캘린더 클래스
		GregorianCalendar gd = new GregorianCalendar();
		
		year = gd.get(Calendar.YEAR);
		System.out.println(year + "년");
		
		month = gd.get(Calendar.MONTH) + 1;
		System.out.println(month + "월");
		
		date = gd.get(Calendar.DATE);
		System.out.println(date + "일");
		
		hour = gd.get(Calendar.HOUR);
		System.out.println(hour + "시");
		
		minute = gd.get(Calendar.MINUTE);
		System.out.println(minute + "분");
		
		second = gd.get(Calendar.SECOND);
		System.out.println(second + "초");
		
		millis = gd.get(Calendar.MILLISECOND);
		System.out.println(millis + "밀리초");
		
		System.out.println("현재 날짜 -> " + gd.getTime());
		
		gd.add(Calendar.YEAR, 1);
		System.out.println("다음 년도 -> " + gd.getTime());
		
		gd.setTime(new Date());
		gd.add(Calendar.MONTH, 2);
		System.out.println("2달 뒤 -> " + gd.getTime());
		
		gd.setTime(new Date());
		gd.add(Calendar.DATE, -7);
		System.out.println("일주일 전 -> " + gd.getTime());
		
		// 날자 포멧용 클래스
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = df.format(cd.getTime());
		System.out.println(dateStr);
		
		dateStr = df.format(gd.getTime());
		System.out.println(dateStr);
		
		dateStr = df.format(dt);
		System.out.println(dateStr);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}