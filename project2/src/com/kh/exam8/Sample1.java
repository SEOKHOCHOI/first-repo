package com.kh.exam8;

class Square {
	private int width;
	private int height;
	
	public Square() {}
	public Square(int x, int y) {
		this.width = x;
		this.height = y;
	}
	
	public int area() {
		return this.width * this.height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return this.height;
	}
}

class Triangle {
	private int width;
	private int height;
	private int area;
	
	public Triangle(int width) {
		this.width = width;
		this.height = width;
	}
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getArea() {
		this.area = this.width * this.height / 2;
		return this.area;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return this.height;
	}
	
}

class Circle {
	private final double PI = 3.141592;
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double area() {
		return this.PI * this.radius * this.radius;
	}
	
	public double round() {
		return this.PI * this.radius * 2;
	}

	public double getPI() {
		return this.PI;
	}

	public double getRadius() {
		return this.radius;
	}
	
	public double getDiameter() {
		return this.radius * 2;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}

/* 
 * Square 클래스를 만든것과 비슷한 Triangle, Circle 클래스를 작성한다.
 * 
 * Triangle 은 삼각형 도형을 객체화한 클래스이며, Circle 은 원 도형을 객체화한 클래스이다.
 * 
 * Triangle 클래스의 기능으로 삼각형의 넓이를 구하는 메서드만을 생성한다.
 * 
 * 삼각형은 밑변과 높이가 동일한 정삼각형이 존재하기 때문에 이를 클래스에서도 동일하게 생성할
 * 수 있도록 한다.
 * 
 * Circle 클래스의 기능으로 원의 넓이를 구하는 메서드와 원의 둘레를 구하는 메서드를 생성한다.
 * 원은 주로 반지름을 이용하기 때문에 반지름을 객체에 저장하여 사용하지만 지름을 원하는 경우도 있기 때문에
 * 원의 지름을 구하여 반환하는 메서드도 생성하도록 한다.
 */

public class Sample1 {

	public static void main(String[] args) {
		/*
		 * 클래스를 사용하여 인스턴스를 만들고 만들어진 인스턴스를 사용하는 코드를
		 * 보고 해당 코드에 적합한 클래스를 작성해보도록 한다.
		 */
		Square s = new Square();
		s.setWidth(100);
		s.setHeight(50);
//		s.width = 100;
//		s.height = 50;
		
		// 위에서 변경한 width, height 속성으로 넓이 계산을 하여 리턴.
		int area = s.area();
		
		System.out.println("사각형의 너비는 " + s.getWidth() + " 입니다.");
		System.out.println("사각형의 높이는 " + s.getHeight() + " 입니다.");
		System.out.println("사각형의 넓이는 " + area + " 입니다.");
		
		Square s1 = new Square(10, 20);
		
		System.out.println("사각형의 너비는 " + s1.getWidth() + " 입니다.");
		System.out.println("사각형의 높이는 " + s1.getHeight() + " 입니다.");
		System.out.println("사각형의 넓이는 " + s1.area() + " 입니다.");
		
		Triangle t = new Triangle(10);
		
		System.out.println("삼각형의 너비는 " + t.getWidth() + " 입니다.");
		System.out.println("삼각형의 높이는 " + t.getHeight() + " 입니다.");
		System.out.println("삼각형의 넓이는 " + t.getArea() + " 입니다.");
		
		Triangle t1 = new Triangle(10, 20);
		
		System.out.println("삼각형의 너비는 " + t1.getWidth() + " 입니다.");
		System.out.println("삼각형의 높이는 " + t1.getHeight() + " 입니다.");
		System.out.println("삼각형의 넓이는 " + t1.getArea() + " 입니다.");
		
		t1.setWidth(15);
		System.out.println("삼각형의 너비는 " + t1.getWidth() + " 입니다.");
		System.out.println("삼각형의 높이는 " + t1.getHeight() + " 입니다.");
		System.out.println("삼각형의 넓이는 " + t1.getArea() + " 입니다.");
		
		Circle c = new Circle(5);
		System.out.println("원의 반지름은 " + c.getRadius() + " 입니다.");
		System.out.println("원의 지름은 " + c.getDiameter() + " 입니다.");
		System.out.println("원의 넓이는 " + c.area() + " 입니다.");
		System.out.println("원의 둘레는 " + c.round() + " 입니다.");
		
	}

}

