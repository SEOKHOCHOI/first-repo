package com.kh.exam3;

public class Formatting {

	public static void main(String[] args) {
		String name = "홍길동";
		int age = 34;
		
		System.out.printf("당신의 이름은  %s 입니다.\n", name);
		System.out.printf("당신의 나이는  %d 입니다.\n", age);
		
		System.out.printf("당신의 이름은  %s 이고 나이는 %d 입니다.\n", name, age);
		System.out.printf("당신의 나이는  %d 이고 이름은 %s 입니다.\n", age, name);
	
	
	    double pi = 3.1415926535;
	    System.out.printf("파이는 %.1f 입니다.\n", pi);
	    System.out.printf("파이는 %.2f 입니다.\n", pi);
	    System.out.printf("파이는 %f 입니다.\n", pi);
	    System.out.printf("파이는 %.8f 입니다.\n", pi);
	}
	

}
