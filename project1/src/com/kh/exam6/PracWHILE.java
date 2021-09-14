package com.kh.exam6;

import java.util.Scanner;

public class PracWHILE {

	static Scanner sc = new Scanner(System.in);
	
	public static void ex1() {
		System.out.println("for 문으로 출력함!");
		for(char c = 'a'; c<= 'z';c++) {
			System.out.print(c);
			if(c == 'z') {
				System.out.print("");
			} else {
				System.out.print(", ");
			
			}
		}
			System.out.println("\nwhile 문으로 출력함!");
			char c = 'a';
			while(c <= 'z'){
				System.out.print(c);
				if(c == 'z') {
					System.out.print("");
				}else {
					System.out.print(", ");
				}
				c++;
			}
			System.out.println("\nDo~While 문으로 출력함!");
			c = 'a';
			do {
				System.out.print(c);
				if(c == 'z') {
					System.out.print("");
				}else {
					System.out.print(", ");
				}
				c++;
			}while(c <= 'z');
	}
	
	public static void ex2() {
		System.out.println("for 문으로 출력함!");
		for(char c = 'Z'; c >= 'A'; c--) {
			sc.nextLine();
			System.out.println("DEBUG -> c:" + c + ", (int)c:" + (int)c);
			System.out.print(c);
			if(c == 'A') {
				System.out.print("");
			}else {
				System.out.print(", ");
			}
		}
		char c = 'Z';
		while(c >= 'A') {
			System.out.print(c);
			if(c == 'A') {
				System.out.print("");
			}else {
				System.out.print(", ");
			}
			c--;
		}
	}
	public static void ex3() {
		System.out.println("for 문으로 출력함!");
		int cnt = 0;
		for(char c = 'a'; c<='z'; c++) {
			System.out.print(c);
			cnt += 1;
			if(c == 'z') {
				break; //z때,안나오게 하려고!
			}
			if(cnt % 5 == 0) {
				System.out.print("\n");
				//cnt == 5 쓰려면 여기다 cnt = 0;으로 카운트 초기화해줘.
			}else {
				System.out.print(", ");
			}
		}
		System.out.println("\n중첩 반복문으로 출력함!");
		char code = 'a' - 1;
		for(;;) {
			for(int i = 1; i <= 5; i ++) {
				code++;
				System.out.print(code);
				if(i != 5) {
					if(code != 'z') {
					System.out.print(", ");
					}
				}
				if(code == 'z') {
					break;
					}
			}
			if(code == 'z') {break;}
		
		System.out.print("\n");
		}
	}
	
	public static void ex4() {
		
	}
	public static void ex5() {
		int min, max, row;
		
		System.out.print("최소값 : ");
		min = sc.nextInt(); sc.nextLine();
		
		System.out.print("최대값 : ");
		max = sc.nextInt(); sc.nextLine();
		
		System.out.print("열 수 : ");
		row = sc.nextInt(); sc.nextLine();
		
		int cnt = 0;
		for(int i = 11; i <= 99; i++) {
			System.out.print(i);
			cnt += 1;
			
			if(cnt % 10 == 0) {
				System.out.print("\n");
				//cnt = 0;
			}else {
				System.out.print("\t");
			}
		}		
	}
	public static void ex6() {
		int num;
		
		System.out.print("배수 값 : ");
		num = sc.nextInt(); sc.nextLine();
		
		int cnt = 0;
		int loop = 1;
		for(int i = 100; i<= 999; i++) {
			if(i % num == 0) {
				System.out.print(i);
				cnt += 1;
				
				if(cnt % 5 == 0) {
					System.out.print("\n");
				} else {
					System.out.print("\t");
				}
				
			}
			}
	}
	
	public static void ex7rlqhsRhf() {
		String text = "hello";
		
		for(int i = 0; i <= text.length()-1; i++) {
			System.out.println(text.charAt(i));
		}
		//System.out.println(text.charAt(0));
		//System.out.println(text.length());
		
	}
	public static void ex7() {
		String text;
		System.out.print("문자열 입력 : ");
		text = sc.nextLine();
		
		int cnt = 0;
		for(int i = 0; i <= text.length()-1; i++) {
			switch(text.charAt(i)) {
			case 'a' :
			case 'e' :
			case 'i' :
			case 'o' :
			case 'u' :
				cnt += 1;
			}
			
		}
		System.out.println("a, e, i, o, u 문자의 수는 " + cnt + "입니다.");
	}
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		//ex5();
		//ex6();
		//ex7rlqhsRhf();
		//ex7();
	}

}
