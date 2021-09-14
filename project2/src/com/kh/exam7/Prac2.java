package com.kh.exam7;

public class Prac2 {
	public boolean isEven(int number) {
		if(number % 2 == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isOdd(int number) {
		return !this.isEven(number);
	}
	
	public boolean isMulti(int number) {
		return this.isEven(number);
	}
	
	public boolean isMulti(int number, int multi) {
		if(number % multi == 0) {
			return true;
		}
		return false;
	}
	
	public int max(int num1, int num2) {
		return num1 > num2 ? num1 : num2;
	}
	
	public int max(int[] numbers) {
		int m = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			if(m < numbers[i]) {
				m = numbers[i];
			}
		}
		return m;
	}
	
	public int min(int num1, int num2) {
		/*
		 * if(num1 < num2) {
		 * 	return num1;
		 * }
		 * return num2;
		 */
		return num1 < num2 ? num1 : num2;
	}
	
	public int min(int[] numbers) {
		int m = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			if(m > numbers[i]) {
				m = numbers[i];
			}
		}
		return m;
	}
}
