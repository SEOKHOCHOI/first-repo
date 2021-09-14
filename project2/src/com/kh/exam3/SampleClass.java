package com.kh.exam3;
// 여따가 int x = 0; 하는 전역변수 자바에선 불가능.
class Other {
	int x;
	int y;
	public Other() {} //밑에 oht2용임
	public Other(int x) {
		this.x = x; //x를 초기화 했으니 밑에 뜨는거
//y는 안했으니 안뜸 할려면
		//public Other(int x, int y) {
		// this x = x;
		// this y = y; 해줘야함
	
	// }
	}
}

public class SampleClass {

	public static void main(String[] args) {
		Other oth1 = new Other(10);
		
		System.out.println(oth1.x);
		System.out.println(oth1.y);
		
		Other oth2 = new Other();
		System.out.println(oth2.x);
		System.out.println(oth2.y);
	}

}
