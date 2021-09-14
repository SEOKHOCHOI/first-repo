package com.kh.exam4;

import java.util.Scanner;

public class PracIF {

	static Scanner sc = new Scanner(System.in);
	
	public static void ex1() {
	int menuNum;
	
	System.out.println("1. 입력 메뉴");
	System.out.println("2. 수정 메뉴");
	System.out.println("3. 검색 메뉴");
	System.out.println("4. 삭제 메뉴");
	System.out.println("5. 종료");
	System.out.println();
	System.out.print("메뉴 번호 입력 : ");

	menuNum = sc.nextInt(); sc.nextLine();
	
	if(menuNum == 1) {
		System.out.println("입력 메뉴를 입력하였습니다.");
	}else if(menuNum == 2) {
		System.out.println("수정 메뉴를 입력하였습니다.");
	}// 이거 반복 노가다.
	}
																																						
	
	public static void ex2() {
		int code;
		
		System.out.println("영문자 범위의 ASCII 코드 번호 입력 : ");
		code = sc.nextInt(); sc.nextLine();
		
		if(code >= 65 && code <= 90) {
			System.out.printf("입력한 ASCII 코드 %d 의 영문자는 '%c' 입니다.\n", code, code);
		
		}else if(code >= 97 && code <= 122) {
			System.out.printf("입력한 ASCII 코드 %d 의 영문자는 '%c' 입니다.\n", code, code);
			
		}else {
			System.out.println("ASCII 코드 영문자 범위를 벗어났습니다.");
		}
	}//ASCII 코드 범위 잘 보르면 'A'부터 'Z'까지로 문자로 표시해도됨.
	//%d는 정수고 %c는 문자임.
	
	public static void ex3() {
		double kor, eng, mth;
		double tot, avg;
		
		System.out.println("국어 점수 입력 : ");
		kor = sc.nextDouble(); sc.nextLine();

		System.out.println("영어 점수 입력 : ");
		eng = sc.nextDouble(); sc.nextLine();
		
		System.out.println("수학 점수 입력 : ");
		mth = sc.nextDouble(); sc.nextLine();
	
		tot = kor + eng + mth;
		avg = tot / 3.0;
		
		System.out.println("총합 : " + tot);
		System.out.println("평균 : " + avg);
		
		if(avg >= 60) {
			System.out.println("합격입니다.");
		}else {
		System.out.println("불합격입니다.");
		}
	}
	public static void ex4() {
		double jumsu;
		String msg;
		
		System.out.print("점수 입력(0 ~ 100) : ");
		jumsu = sc.nextDouble(); sc.nextLine();
		if(jumsu>= 0 && jumsu <= 100) {
		if(jumsu >= 90) {
			msg = "A 등급";
		}else if(jumsu >= 80 && jumsu <90) {
			msg = "B 등급";
		}else if(jumsu >= 70 && jumsu <80) {
			msg = "C 등급";
		
		}else if(jumsu >= 60 && jumsu <70) {
			msg = "D 등급";
		}else 
			msg = "F 등급";
		}
			System.out.println("입니다.");
	}
	
	public static void ex5() {
		int day;
		
		System.out.println("일자 입력 : ");
		day = sc.nextInt(); sc.nextLine();
		if(day % 7 == 0) {
			System.out.println("수요일 입니다.");
		}else if (day % 7 == 1) {
			System.out.println("목요일 입니다.");
		}else if (day % 7 == 2) {
			System.out.println("금요일 입니다.");
		}else if (day % 7 == 3) {
			System.out.println("토요일 입니다.");
		}else if (day % 7 == 4) {
			System.out.println("일요일 입니다.");
		}else if (day % 7 == 5) {
			System.out.println("월요일 입니다.");
		}else if (day % 7 == 6) {
			System.out.println("화요일 입니다.");
		}
	}
	
	
	public static void ex6() {
		String str;
		
		System.out.println("더하기, 빼기, 나누기 , 곱하기 중 하나를 입력하시오.");
		System.out.println(": ");
		
		str = sc.nextLine();
		
		switch(str) {
		case "더하기" :
			System.out.println("더하기는 + 기호를 사용합니다.");break;
		case "빼기" :
			System.out.println("빼기는 - 기호를 사용합니다.");break;
		case "곱하기" :
			System.out.println("곱하기는 * 기호를 사용합니다.");break;
		case "나누기" :
			System.out.println("나누기는 / 기호를 사용합니다.");break;
		default:
			System.out.println("더하기, 빼기, 곱하기, 나누기중 하나를 입력하세요.");
		}
	}
	public static void ex7() {
		
		
	}
	public static void main(String[] args) {
		//ex1(); //메서드 실행(호출)
		//ex2();  << //를 지우면 실행됨. //하면 실행안됨 스위치라고 생각하셈.
		//ex3();
		//ex4();
		//ex6();
		//ex5();
	}

}
