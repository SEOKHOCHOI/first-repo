package com.kh.exam12;

import java.util.Arrays;
import java.util.Scanner;

public class Sample3 {

	public static void ex3() {
		/*
		 * 다음의 문자열을 만들고 해당 문자열 안에서 사용자가 입력한 단어가
		 * 포함되어 있는 경우 찾은 문자열의 위치를 정수 배열에 저장한다.
		 * 단, 대소문자의 구분없이 찾아야 한다.
		 * 예시) replace 문자열을 찾는 경우 대소문자 구분 없이 찾아야 한다.
		 */
		String text = "Replaces each substring of this string that matches the "
				+ "literal target sequence with the specified literal "
				+ "replacement sequence. The replacement proceeds from the "
				+ "beginning of the string to the end, for example, replacing "
				+ "\"aa\" with \"b\" in the string \"aaa\" will result in "
				+ "\"ba\" rather than \"ab\".";
		Scanner sc = new Scanner(System.in);
		System.out.print("찾을 단어 입력 : ");
		String find = sc.nextLine().toLowerCase();
		text = text.toLowerCase();
		
		int[] resIntArr = new int[0];
		int idx = -1;
		while(true) {
			if(text.indexOf(find, idx + 1) != -1) {
				int[] temp = new int[resIntArr.length + 1];
				System.arraycopy(resIntArr, 0, temp, 0, resIntArr.length);
				idx = text.indexOf(find, idx + 1);
				temp[temp.length - 1] = idx;
				resIntArr = temp;
			} else {
				break;
			}
		}
		System.out.println(Arrays.toString(resIntArr));
		
	}
	
	public static void ex2() {
		/*
		 * 한 번의 사용자 입력을 통해서 정수값 5개를 입력 받아
		 * 정수 배열에 저장하기
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 5개 입력하세요 : ");
		int[] inputs = new int[5];
		String[] temp = sc.nextLine().split(" ");
		for(int i = 0; i < 5; i++) {
			if(i >= temp.length) {
				inputs[i] = 1;
			} else {
				inputs[i] = Integer.parseInt(temp[i]);
			}
		}
		System.out.println(Arrays.toString(inputs));
		
//		String temp = sc.nextLine();
//		for(int i = 0; i < 5; i++) {
//			inputs[i] = Integer.parseInt(Character.valueOf(temp.charAt(i)).toString());
//		}
	}
	
	public static void ex1() {
		/*
		 * 한 번의 사용자 입력을 통해서 단어 3개를 입력 받아
		 * 문자열 배열에 저장하기 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("단어를 3개 입력하세요 : ");
		String[] inputs = new String[3];
		String[] temp = sc.nextLine().split(",");
		for(int i = 0; i < 3; i++) {
			if(i >= temp.length) {
				inputs[i] = "기본값";
			} else {
				inputs[i] = temp[i];
			}
		}
		System.out.println(Arrays.toString(inputs));
		
	}
	
	public static void main(String[] args) {
		ex3();
		// ex2();
		// ex1();
	}

}