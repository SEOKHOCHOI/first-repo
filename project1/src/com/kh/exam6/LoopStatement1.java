package com.kh.exam6;

import java.util.Scanner;

public class LoopStatement1 {

		public static void sample1() {
			int i = 1;
			while (i <= 5) {
				System.out.println(i + " 번째 반복");
				i++;
			}
			
//			for(int i = 1; i <= 5; i++) {
//				System.out.println(i + " 번째 반복");
//			}
		}
		public static void sample2() {
			// 5~ 1까지 반복 출력
			int i = 5;
			while(i >= 1) {
				System.out.println(i + " 입니다.");
				i--;
			}
		}

		public static void sample3() {
			while(true) {
				System.out.println("무한 반복 입니다.");
			}
		}
		
		public static void sample4() {
			while(true) {
				System.out.println("반복문 안에 종료 조건을 만들어서 break");
				if(true) {
					break;
				}
			}
		}
		public static void sample5() {
			int num;
			Scanner sc = new Scanner(System.in);
			
			do {
				System.out.print("정수 값 입력(11 이상 입력) : ");
				num = sc.nextInt(); sc.nextLine();
			}while(num <= 10);
		}
		public static void main(String[] args) {
			//sample1();
//			sample2();
//			sample3();
//			sample4();
			sample5();
		}
}