package com.kh.exam5;

class Other {
	public void method1() {
		System.out.println("메서드가 실행되었습니다.");
	}
	public static void method2() {
		System.out.println("static 메서드가 실행되었습니다.");
	}
	
	public final void method3() {
		System.out.println("final 키워드를 적용한 메서드");
	}
}

public class Sample1 {

	public static void ex1() {
		System.out.println("문제 1");
	}
	public static void main(String[] args) {
		Other oth = new Other();
		oth.method1();
		oth.method3();
		
		Other.method2();
		
		ex1();
	}

}
