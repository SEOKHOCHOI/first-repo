package com.kh.exam6;

import java.util.Arrays;

public class Sample1 {
public static void ex1() {
	
	Prac1 p = new Prac1();
	
	p.method1(); p.method1(true); p.method1(10);
	p.method1(1.23); p.method1("Hello");
	p.method1(10, 20, 30);
	
	//배열로 매개변수 받도록 된경우.
	int[] x = {1, 2, 3, 4};
	p.method1(x); //이렇게 배열 만들어서 해주면 됨.
	//함수 호출이 끝나고난 다음 이후에.
	//int[] x에서 x는 변수이름이고 (참조값,주소값!) 그 주소를 arr에
	//전달해준거임 x를 보낸게 아니라 x에 저장된 참조값을 
	//arr이라는 이름의 변수에다가 전달한것.
	//즉 arr=x 이렇게 된거임.
	
	System.out.println(Arrays.toString(x));
	
	p.method1(1.1, 2.1, 3.1, 4.1);
	
	//매개변수가 클래스인 경우임
	MyData d1 = new MyData();
	d1.name = "홍길동";
	d1.num = 30;
	p.method1(d1);
	System.out.println(d1.num + " | " + d1.name);
}

	public static void ex2() {
		Prac2 p = new Prac2();
		
		System.out.println(p.method1());
		
		int x1 = p.method1();
		System.out.println(x1);
		
		int x2 = p.method1(5);
		System.out.println(x2);
		
		System.out.println(p.method1() + p.method1(10));
		
		boolean b1 = p.method2();
		System.out.println(b1);
	
		boolean b2 = p.method2(10);
		System.out.println(b2);
		
		boolean b3 = p.method2(11);
		System.out.println(b3);
		
		int[] arr1 = p.method3(5);
		System.out.println(arr1 + " | " + Arrays.toString(arr1));
		
		int[] arr2 = p.method3(5, 3);
		System.out.println(arr2 + " | " + Arrays.toString(arr2));
		
		MyData2 data1 = p.method4();
		System.out.println(data1.name + " | " + data1.num);
		
		MyData2 data2 = p.method4("박찬호");
		System.out.println(data2.name + " | " + data2.num);
		
	}

	public static void main(String[] args) {
		//ex1();
		ex2();
 }
}
