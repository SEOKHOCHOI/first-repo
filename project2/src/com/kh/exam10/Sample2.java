package com.kh.exam10;

public class Sample2 {

	public static void main(String[] args) {
		Shape[] s = new Shape[3];
		s[0] = new Circle(20);
		s[1] = new Square(10, 20);
		s[2] = new Triangle(10, 20);
		
//		for(int i = 0; i < s.length; i++) {
//			((Circle)s[i]).getRadius();
//		}
		
		for(Shape c: s) {
			if(c instanceof Circle) {
				Circle cc = (Circle)c;
				System.out.println(c.getArea() + "|" + cc.getRadius());
			} else {
				System.out.println(c.getArea() + "|" + c.getWidth());
			}
		}
		
//		System.out.println(s[0].getArea() + "|" + s[0].getWidth());
//		System.out.println(s[1].getArea() + "|" + s[1].getWidth());
//		System.out.println(s[2].getArea() + "|" + ((Circle)s[2]).getRadius());
		
//		Circle c = new Circle(5);
//		Square s = new Square(10, 20);
//		Triangle t = new Triangle(10, 20);
//		
//		System.out.println(c);
//		System.out.println(s);
//		System.out.println(t);
//		
//		System.out.println(c.getArea());
//		System.out.println(s.getArea());
//		System.out.println(t.getArea());
	}

}
