package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		String menu = "===== 메뉴 =====\n";
		menu += "1. 원\n";
		menu += "2. 사각형\n";
		menu += "9. 끝내기\n";
		menu += "메뉴 번호 : ";
		
		while(true) {
			System.out.print(menu);
			
			int num = this.sc.nextInt(); this.sc.nextLine();
			
			switch(num) {
				case 1:
					this.circleMenu();		break;
				case 2:
					this.rectangleMenu();	break;
				case 9:
					return;
			}
		}
		
	}
	
	public void circleMenu() {
		String menu = "===== 원 메뉴 =====\n";
		menu += "1. 원 둘레\n";
		menu += "2. 원 넓이\n";
		menu += "9. 메인으로\n";
		menu += "메뉴 번호 : ";
		System.out.print(menu);
		
		int num = this.sc.nextInt(); this.sc.nextLine();
		
		switch(num) {
			case 1:
				this.calcCircum();		break;
			case 2:
				this.calcCircleArea();	break;
			case 9:
				return;
		}
	}
	
	public void rectangleMenu() {
		String menu = "===== 사각형 메뉴 =====\n";
		menu += "1. 사각형 둘레\n";
		menu += "2. 사각형 넓이\n";
		menu += "9. 메인으로\n";
		menu += "메뉴 번호 : ";
		System.out.print(menu);
		
		int num = this.sc.nextInt(); this.sc.nextLine();
		
		switch(num) {
			case 1:
				this.calcPerimeter();	break;
			case 2:
				this.calcRectArea();	break;
			case 9:
				return;
		}
	}
	
	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();	sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();	sc.nextLine();
		
		System.out.print("반지름 : ");
		int radius = sc.nextInt();	sc.nextLine();
		
		String res = cc.calcCircum(x, y, radius);
		System.out.println(res);
	}
	
	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();	sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();	sc.nextLine();
		
		System.out.print("반지름 : ");
		int radius = sc.nextInt();	sc.nextLine();
		
		String res = cc.calcArea(x, y, radius);
		System.out.println(res);
	}
	
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();	sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();	sc.nextLine();
		
		System.out.print("높이 : ");
		int height = sc.nextInt();	sc.nextLine();
		
		System.out.print("너비 : ");
		int width = sc.nextInt();	sc.nextLine();
		
		String res = rc.calcPerimeter(x, y, height, width);
		System.out.println(res);
	}
	
	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();	sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();	sc.nextLine();
		
		System.out.print("높이 : ");
		int height = sc.nextInt();	sc.nextLine();
		
		System.out.print("너비 : ");
		int width = sc.nextInt();	sc.nextLine();
		
		String res = rc.calcArea(x, y, height, width);
		System.out.println(res);
	}
}
