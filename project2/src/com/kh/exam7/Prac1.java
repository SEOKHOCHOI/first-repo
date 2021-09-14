package com.kh.exam7;

public class Prac1 {
	public void isEven(int number) {
		if(number % 2 == 0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
	
	public void isOdd(int number) {
		if(number % 2 == 1) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
	
	public void isMulti(int number) {
		this.isEven(number);
	}
	
	public void isMulti(int number, int multi) {
		if(number % multi == 0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
	
	public void max(int num1, int num2) {
		if(num1 > num2) {
			System.out.println(num1);
		} else {
			System.out.println(num2);
		}
	}
	
	public void max(int[] numbers) {
		int m = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			if(m < numbers[i]) {
				m = numbers[i];
			}
		}
		System.out.println(m);
	}
	
	public void min(int num1, int num2) {
		if(num1 < num2) {
			System.out.println(num1);
		} else {
			System.out.println(num2);
		}
	}
	
	public void min(int[] numbers) {
		int m = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			if(m > numbers[i]) {
				m = numbers[i];
			}
		}
		System.out.println(m);
	}
}
