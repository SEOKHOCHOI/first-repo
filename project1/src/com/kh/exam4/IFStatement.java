package com.kh.exam4;

import java.util.Scanner;

public class IFStatement {

	static Scanner sc = new Scanner(System.in);	
	
	public static void main(String[] args) {
		int a;
		
		System.out.print("정수값 입력 : ");
		a = sc.nextInt();  sc.nextLine();
		
		if(a > 100) {
			System.out.println("변수 a에 저장된 값이 100 보다 큽니다.");
		}
		
		int b;
		System.out.print("정수값 입력 : ");
		b = sc.nextInt(); sc.nextLine();
		
		if(b % 7 == 0) {
			System.out.println("변수 b에 저장된 값은 7의 배수입니다.");
		} else {
		System.out.println("변수 b에 저장된 값은 7의 배수가 아닙니다.");
		}
		
	}
}
