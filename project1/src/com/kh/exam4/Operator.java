package com.kh.exam4;

import java.util.Scanner;

public class Operator {
	
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int a = 10;
		int b = a++; //나중에 증감
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		int x = 10;
		int y = ++x;
		System.out.println("x : " + x);
		System.out.println("y : " + y);

		int x1 = 10;
		//int y1 = 0; 0으로는 나눌수없음.
		double y1 = 2.0;
		
		System.out.println("10 / 2.0 -> " + (x1 / y1));
		
		
		int x2 = 10;
		System.out.println("x1 == 10 -> " + (x1 == 10));
		System.out.println("x1 == 12 -> " + (x1 == 12));
	
		double y2 = 10.0; //비교할때 굳이 자료형 구별 필요X 라는 뜻.
		System.out.println("y2 == 10 ->" + (y2 == 10));
		System.out.println("y2 == 10.0 ->" + (y2 == 10.0));
		
		int x3 = 65;  //문자와 정수의 비교.
		System.out.println("x3 == 65 ->" + (x3 == 65));
		System.out.println("x3 == 'A' ->" + (x3 == 'A'));
	
		char y3 = 'A';
		System.out.println("y3 == 65 ->" + (y3 == 65));
		System.out.println("y3 == 'A' ->" + (y3 == 'A'));
	
		String x4 = "A"; // 문자열과 정수또는 문자와는 비교 불가능.
		System.out.println("x4 == \"A\" -> " + (x4 == "A"));
		//System.out.println("x4 == 'A' -> " + (x4 == 'A'));
	
		String y4 = new String("A"); //새로운 참조 주소를 생성하여 해당역역에 값 저장.
		System.out.println("y4 -> " + y4);
		System.out.println("x4 -> " + x4);
		System.out.println("x4 == y4 -> " + (x4 == y4));
		//문자열에대한 비교를 할때 일반적인 비교연산자 쓰면 안됨.
		System.out.println("x4.equals(y4) -> " + (x4.equals(y4)));
		//문자열.equals(문자열) 사용해서 비교해야함.
		/*JVM
		 * 메모리
		 * 		STACK
		 * 			String x4 = 0x0004;
		 * 			String y4 - 0x0008; //new String("A");2
		 * 		
		 * 		HEAP
		 * 			0x0004 = "A"
		 * 			0x0008 = "A"
		 */
		
		String x7;
		x7 = sc.nextLine();
		System.out.println("x7 == \"A\" -> " + (x7 == "A"));
		System.out.println("x7.equals(\"A\") -> " + (x7.equals("A")));
	
		
		int x8 = 10;
		int res;
		res = x8 > 10? x8 - 5 : x8 + 5;
		System.out.println(res);
	
		int x9 = 5;
		String r;
		r = x9 % 2 == 0 ? "짝수" : "홀수";
		System.out.println("x9는 " + r + "입니다.");
	}

}
