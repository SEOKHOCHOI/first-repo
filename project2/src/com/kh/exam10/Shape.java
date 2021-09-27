package com.kh.exam10;

public class Shape {
	private double width;
	private double height;
	private String color;
	private double angle;
	
	public Shape(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return this.width * this.height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	@Override
	public String toString() {
		return "Shape [width=" + width + ", height=" + height + "]";
	}
}
