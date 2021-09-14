package com.kh.exam8;

import java.util.Random;

public class Sample11 {

	public static void main(String[] args) {
		/*
		 * 다음은 시리얼 번호를 생성하기 위한 클래스이다.
		 */
		GenSerial gen = new GenSerial();
		
		// 10 자리의 시리얼 코드를 생성하는 메서드로 숫자 및 A ~ Z 까지의 문자 조합으로
		// 생성하게 한다.(반환하는 시리얼 코드는 문자열이다.)
		gen.createCode(10);
		
		// 10 자리의 시리얼 코드를 생성하는 메서드로 숫자 및 A ~ Z 까지의 문자 조합으로
		// 총 5개의 시리얼 코드를 생성하게 한다.
		gen.createCodes(10, 5);
		
		// 시리얼 코드를 생성할 숫자의 범위를 0 ~ 5 로 제한한다.
		gen.setRangeNumber(0, 5);
		
		// 시리얼 코드의 숫자 범위가 제한되었기 때문에 여기부터는 코드 숫자가 0 ~ 5 만 나온다.
		gen.createCode(10);
		
		// 시리얼 코드를 생성할 문자의 범위를 A ~ F 로 제한한다.
		gen.setRangeChar('A', 'F');
		
		// 시리얼 코드의 문자 범위가 제한되었기 때문에 여기부터는 코드 문자가 A ~ F 만 나온다.
		gen.createCode(10, 5);
	}

}
