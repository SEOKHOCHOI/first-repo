package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		r.setX(x);	r.setY(y);	r.setHeight(height);	r.setWidth(width);
		int area = r.getHeight() * r.getWidth();
		return r.toString() + "/" + area;
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);	r.setY(y);	r.setHeight(height);	r.setWidth(width);
		int area = 2 * (r.getHeight() + r.getWidth());
		return r.toString() + "/" + area;
	}
}

