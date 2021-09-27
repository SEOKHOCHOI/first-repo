package com.kh.exam13;

import java.util.StringTokenizer;

public class Sample2 {

	public static void main(String[] args) {
		String str = "StringTokenizer로 문자열을 분리하는 예제";
		StringTokenizer st = new StringTokenizer(str, " ");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
