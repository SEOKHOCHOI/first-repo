package com.kh.exam9;

public class Triangle {
	private String name = "삼각형";
	private double width;
	private double height;
	
	public Triangle(double width) {
		this.width = width;
		this.height = Math.sqrt((width * width) - ((width / 2) * (width / 2)));
		this.name = "정삼각형";
	}
	
	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void setLength(double width) {
		this.width = width;
		this.height = Math.sqrt((width * width) - ((width / 2) * (width / 2)));
		this.name = "정삼각형";
	}
	
	public void setLength(double width, double height) {
		this.width = width;
		this.height = height;
		this.name = "삼각형";
	}

	public double getWidth() {
		return this.width;
	}

	public double getHeight() {
		return this.height;
	}

	public String getName() {
		return this.name;
	}
	
	public double getArea() {
		return this.width * this.height / 2;
	}
	
}