package com.kh.exam6;

import java.util.Arrays;

//클래스 사용. 이걸 매개변수로 전달 할거임!
class MyData{
	public int num;
	public String name;
}

public class Prac1 {
	public void method1() {
		System.out.println("매개변수 없는 매서드 동작!");
	}
	
	public void method1(boolean b) {
		System.out.println("매개변수 있는 메서드 동작 -> " + b);
	}
	
	public void method1(int i) {
		System.out.println("매개변수가 있는 메서드 동작 -> " + i);
	}
	
	public void method1(double d) {
		System.out.println("매개변수가 있는 메서드 동작 - > " + d);
	}
	
	public void method1(String s) {
		System.out.println("매개변수가 있는 메서드 동작 -> " + s);
	
	}
	public void method1(int x, int y, int z) {
		System.out.println("매개변수가 있는 메서드 동작 -> " + x + ", " + y + ", " + z);
	}
	public void method1(int[] arr) {
		System.out.println("매개변수가 있는 메서드 동작 -> " + arr);
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] + 5;
		}
	}
	public void method1(double ... arr) {
		System.out.println("매개변수가 있는 메서드 동작 -> " + arr);
		System.out.println("매개변수가 있는 메서드 동작 -> " + Arrays.toString(arr));
	}
	//클래스사용
	public void method1(MyData data) {
		System.out.println(data.num + " | " + data.name);
		data.num = data.num + 10;
	}
}
