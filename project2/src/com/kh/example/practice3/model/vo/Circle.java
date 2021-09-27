package com.kh.example.practice3.model.vo;

public class Circle {
	private double PI = 3.14;
	private int radius = 1;
	
	public Circle() {}
	
	public void incrementRadius() {
		this.radius++;
	}
	
	public void getAreaOfCircle() {
		// 원 넓이
		System.out.println("원 넓이 : " + (this.PI * this.radius * this.radius));
	}
	
	public void getSizeOfCircle() {
		// 원 둘레
		 System.out.println("원 둘레 : " + (2 * this.PI * this.radius));
	}
}
