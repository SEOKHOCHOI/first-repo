package com.kh.exam6;

public class LoopStatement {
	
	public static void sample1() {
		for(int i = 1; i <= 3; i++) {
			System.out.println(i + " 번째 반복");
		}
	}
	
	public static void sample2( ) {
		for(int i = 3; i >= 1; i--) {
			System.out.println(i + " 번째 반복");
		}
	}
	//초기식의 위치를 for문 밖에 배치
	public static void sample3( ) {
		int i = 1;
		for(; i <= 3;) {
			//for문 안에서 초기식 int =i;해주면 지역변수가됨. 밖으로빼주면
			// 바깥에 System~~(i)를 출력가능한거임.
			System.out.println(i + " 번째 반복");
			i++;
		}
		System.out.println(i);
	}
	//조건식 생략
	public static void sample4() {
		for(int i = 1;; i++) {
			if(i >= 5) {
				break; //for 반복을 중단하는 역할.
			}
			System.out.println(i + " 번째 반복");
		}
	}
	//전부생략! 의도된 무한반복.
	public static void sample5() {
		for(;;) {
			System.out.println("무한 번째 반복");
		}
	}
	
	public static void sample6() {
		for(int i = 1; i <= 20; i += 2) {
			System.out.println(i + " 입니다.");
		}
	}
	
	public static void main(String[] args) {
		//sample1();
		//sample2();
		//sample3();
		//sample4();
		//sample5();
		sample6();
	}

}
