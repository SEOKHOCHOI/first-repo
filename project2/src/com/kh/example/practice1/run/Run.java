package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {

	public static void main(String[] args) {
		Member m = new Member();
		m.changeName("홍길동");//Member쪽 메서드에 전달됨 홍길동이.
		m.printName();
	}

}
