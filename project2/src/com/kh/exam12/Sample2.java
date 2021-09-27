package com.kh.exam12;

public class Sample2 {

	public static void main(String[] args) {
		// 문자열을 기본 자료형으로 변환
		int resInt = Integer.parseInt("1234");
		System.out.println(resInt + 10);
		
		double resDouble = Double.parseDouble("123.456");
		System.out.println(resDouble + 10);
		
		boolean resBool = Boolean.parseBoolean("true");
		System.out.println(resBool);
		
		// 기본 자료형을 String 으로 변환
		String resStr = "" + 123;
		System.out.println(resStr + ".");
		
		resStr = "" + 123.45;
		System.out.println(resStr + ".");
		
		resStr = Integer.valueOf(123).toString();
		System.out.println(resStr + ".");
	}

}
