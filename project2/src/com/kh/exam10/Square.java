package com.kh.exam10;

public class Square extends Shape {
	public Square(double width) {
		super(width, width);
	}
	
	public Square(double width, double height) {
		super(width, height);
	}
	
	@Override
	public String toString() {
		return "Square [width=" + getWidth() + ", height=" + getHeight() + "]";
	}
}
