package com.kh.exam10;

public class Circle extends Shape {
	private double radius;
	
	public Circle(double radius) {
		super(radius, radius);
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return super.getArea() * Math.PI;
	}
	
	@Override
	public void setWidth(double radius) {
		super.setWidth(radius * 2);
		this.radius = radius;
	}
	
	@Override
	public double getWidth() {
		return this.radius;
	}
	
	@Override
	public void setHeight(double radius) {
		super.setHeight(radius * 2);
		this.radius = radius;
	}
	
	@Override
	public double getHeight() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
}
