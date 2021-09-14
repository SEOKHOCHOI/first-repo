package com.kh.exam7;

public class Sample1 {

	public static void ex1() {
		/*
		 * 다음의 메서드 호출 형식을 보고 해당 형식에 적합한 메서드를 만드시오.
		 */
		Prac1 p = new Prac1();	// 이 클래스는 동일 패키지 안에 다른 자바 파일로 생성한다.
		
		// 짝수 홀수를 구분하여 짝수면 true, 홀수면 false 를 출력하는 메서드로 작성
		p.isEven(10);		p.isEven(11);
		
		// 짝수 홀수를 구분하여 짝수면 false, 홀수면 true 를 출력하는 메서드로 작성
		p.isOdd(10);		p.isOdd(11);
		
		// 2의 배수면 true, 아니면 false 를 출력하는 메서드로 작성
		p.isMulti(10);		p.isMulti(15);
		
		// 3의 배수면 true, 아니면 false 를 출력하는 메서드로 작성
		p.isMulti(10, 3);	p.isMulti(15, 3);
		
		// 5의 배수면 true, 아니면 false 를 출력하는 메서드로 작성
		p.isMulti(10, 5);	p.isMulti(15, 5);
		
		// 가장 큰값을 출력하는 메서드로 작성
		p.max(10, 20);		p.max(20, 10);
		
		int[] arr1 = {1, 7, 8, 9, 3};
		p.max(arr1);
		
		// 가장 작은값을 출력하는 메서드로 작성
		p.min(10, 20);		p.min(20, 10);
		
		int[] arr2 = {1, 7, 8, 9, 3};
		p.min(arr2);
	}
	
	public static void ex2() {
		/*
		 * 다음의 메서드 호출 형식을 보고 해당 형식에 적합한 메서드를 만드시오.
		 */
		Prac2 p = new Prac2();	// 이 클래스는 동일 패키지 안에 다른 자바 파일로 생성한다.
		
		// 짝수 홀수를 구분하여 짝수면 true, 홀수면 false 를 리턴하는 메서드로 작성
		System.out.println(p.isEven(10));
		System.out.println(p.isEven(11));
		
		// 짝수 홀수를 구분하여 짝수면 false, 홀수면 true 를 리턴하는 메서드로 작성
		System.out.println(p.isOdd(10));
		System.out.println(p.isOdd(11));
		
		// 2의 배수면 true, 아니면 false 를 리턴하는 메서드로 작성
		System.out.println(p.isMulti(10));
		System.out.println(p.isMulti(15));
		
		// 3의 배수면 true, 아니면 false 를 리턴하는 메서드로 작성
		System.out.println(p.isMulti(10, 3));
		System.out.println(p.isMulti(15, 3));
		
		// 5의 배수면 true, 아니면 false 를 리턴하는 메서드로 작성
		System.out.println(p.isMulti(10, 5));
		System.out.println(p.isMulti(15, 5));
		
		// 가장 큰값을 리턴하는 메서드로 작성
		System.out.println(p.max(10, 20));
		System.out.println(p.max(20, 10));
		
		int[] arr1 = {1, 7, 8, 9, 3};
		System.out.println(p.max(arr1));
		
		// 가장 작은값을 리턴하는 메서드로 작성
		System.out.println(p.min(10, 20));
		System.out.println(p.min(20, 10));
		
		int[] arr2 = {1, 7, 8, 9, 3};
		System.out.println(p.min(arr2));
	}
	
	public static void main(String[] args) {
		ex2();
		// ex1();
	}

}
