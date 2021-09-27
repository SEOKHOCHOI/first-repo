package com.kh.exam10;

public class Triangle extends Shape {
	
	public Triangle(double width) {
		super(width, width);
	}
	
	public Triangle(double width, double height) {
		super(width, height);
	}
	
	@Override
	public double getArea() {
		return super.getArea() / 2;
	}

	@Override
	public String toString() {
		return "Triangle [width=" + getWidth() + ", height=" + getHeight() + "]";
	}
	
}
