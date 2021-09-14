package com.kh.exam3;

import java.util.Scanner;

public class InputScanner {
	
	//클래스 변수
	static Scanner sc = new Scanner(System.in);
	//static 붙여줘야 밑에서 사용가능.
	
	public static void main(String[] args) {
		//지역변수
		String name;
		System.out.print("이름을 입력하세요. : ");
		name = sc.next();
		
		System.out.println("사용자 입력 값 -> "+ name);
		
		int a;
		System.out.print("정수를 입력하세요. : ");
		a = sc.nextInt();
		
		System.out.println("사용자 입력 값 : " + a);
	
		sc.next().charAt(0);
		//"홍길동\r\n"이면 여기서 0번인 홍.
	
	}

}

/*
 * sc.nextInt();
 * "123\r\n"
 * "123" 읽고 버터에 "\r\n"남김
 * 
 *  sc.next();
 *  버퍼에 남은 "\r\n" 무시하고 새로 입력 받음
 *  홍길동"\r\n"
 *  홍길동 읽고 버퍼에"\r\n" 남김
 *  
 *  sc.nextLine();
 *  버퍼에 남은"\r\n"을 무시하지 못하고 읽음
 *  버퍼에 남은 데이터는 없음.
 *  
 *  
 *  
 *  입력 값 : 홍길동 입니다.\r\n
 *  sc.next();
 *  버퍼에 있는 문자열에서 공백전 내용 -> "홍길동" 까지 읽음
 *  "입니다.\r\n
 *  
 *  sc.nextLine();
 *  버퍼에 있는 문자열에서 개행까지 -> " 입니다.\r\n" 까지 읽음
 *  ""
 * */
