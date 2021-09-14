package com.kh.exam4;

import java.util.Scanner;

public class IFStatement1 {

		static Scanner sc = new Scanner(System.in);
		
		public static void main(String[] args) {
		int a;
		
		System.out.print("1 ~ 12월 입력 : ");
		a = sc.nextInt(); sc.nextLine();
		
		if(a >= 1 && a <= 3) {
			System.out.println("1 분기 입니다.");
		} else if(a >= 4 && a <= 6) {
			System.out.println("2 분기 입니다.");
		} else if(a >= 7 && a <= 9) {
			System.out.println("3 분기 입니다.");
		} else if(a >= 10 && a <= 12) {
			System.out.println("4 분기 입니다.");
		} else {
			System.out.println("반드시 1 ~ 12 사이의 값을 입력하세요.");
		}
	
		if(a >= 1 && a <= 12) {
			System.out.printf("%d 분기 입니다.\n", ((a - 1)/3)+1);
		}else {
			System.out.println("반드시 1~12 사이의 값을 입력하세요.");
		}
		
		//TAB = 안쪽으로
		//SHIFT+TAB = 바깥쪽으로
		//ctrl+/ 하면 한번에 주석
	}
}
