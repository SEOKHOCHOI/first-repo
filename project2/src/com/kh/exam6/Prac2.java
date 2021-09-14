package com.kh.exam6;

class MyData2 {
	public int num;
	public String name;
}

public class Prac2 {
	public int method1() {
		return 10;
	}
	public int method1(int x) {
		return x + 10;
	}
	
	public boolean method2() {
		return true;
	}
	public boolean method2(int x ) {
		if(x % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int[] method3(int x) {
		int[] arr = new int[x];
		return arr;
	}
	public int[] method3(int x, int y) {
		int[] arr = new int[x];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = y;
		}
		return arr;
	}
	public MyData2 method4() {
		MyData2 d = new MyData2();
		d.name = "홍길동";
		d.num = 30;
		return d;
	}
	public MyData2 method4(String name) {
		MyData2 d = new MyData2();
		d.name = "홍길동";
		d.num = 30;
		return d;
	}
}
