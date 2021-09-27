package com.kh.exam9;

import java.util.Scanner;

public class Sample2 {

	public static void main(String[] args) {
		/*
		 * 삼각형 클래스를 이용하여 객체배열 활용
		 * 		사용자 입력을 통해 정삼각형 또는 삼각형을 반복 생성할 수 있도록
		 * 		객체 배열을 활용한다.
		 * 
		 * 		정적 배열을 이용하여 5개의 삼각형 정보를 생성하거나
		 * 		동적 배열을 이용하여 사용자가 원하는 만큼 삼각형 정보를 생성한다.
		 * 
		 * 		필요한 만큼 정보를 생성하였으면 삼각형의 종류, 삼각형의 밑변/높이/넓이
		 * 		정보가 출력되게 한다.
		 */
		Scanner sc = new Scanner(System.in);
		Triangle[] tArr = new Triangle[0];
		
		while(true) {
			double width = 0;
			double height = 0;
			System.out.println("어떤 삼각형을 생성하겠습니까?");
			System.out.print("(정삼각형, 삼각형, 종료) : ");
			String type = sc.nextLine();
			if(type.equals("정삼각형")) {
				System.out.print("길이 입력 : ");
				width = sc.nextDouble();	sc.nextLine();
				
				Triangle[] copy = new Triangle[tArr.length + 1];
				System.arraycopy(tArr, 0, copy, 0, tArr.length);
				copy[copy.length - 1] = new Triangle(width);
				tArr = copy;
				
			} else if(type.equals("삼각형")) {
				System.out.print("밑변 입력 : ");
				width = sc.nextDouble();	sc.nextLine();
				System.out.print("높이 입력 : ");
				height = sc.nextDouble();	sc.nextLine();
				
				Triangle[] copy = new Triangle[tArr.length + 1];
				System.arraycopy(tArr, 0, copy, 0, tArr.length);
				copy[copy.length - 1] = new Triangle(width, height);
				tArr = copy;
				
			} else if(type.equals("종료")) {
				break;
				
			} else {
				System.out.println("잘못 입력하였습니다. 다시 입력하세요.");
			}
		}
		
		for(int i = 0; i < tArr.length; i++) {
			System.out.println("밑변(" + tArr[i].getWidth() + "), 높이("
					+ tArr[i].getHeight() + "), 넓이(" + tArr[i].getArea()
					+ ") 인 " + tArr[i].getName() + "데이터가 존재합니다.");
		}
	}

}