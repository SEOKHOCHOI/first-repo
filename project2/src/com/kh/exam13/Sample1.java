package com.kh.exam13;

public class Sample1 {

	public static void main(String[] args) {
		/*
		 * StringBuilder/StringBuffer
		 * 		- 두 클래스의 기능은 동일하나 멀티쓰레드의 안정성을 제공하는지 제공하지 않는지에 대한
		 * 		  차이만을 가진다.(StringBuffer가 멀티쓰레드에서의 안정성을 제공한다.)
		 */
		StringBuilder sb = new StringBuilder("문자열을 다루기 위한 객체\n");
		System.out.println(sb);
		
		// 마지막 인덱스에 문자열 추가
		sb.append("StringBuilder 클래스\n");
		System.out.println(sb);
		
		// 인덱스 번호로 삽입할 위치를 작성하여 문자열 추가
		sb.insert(0, "Java 객체 - ");
		System.out.println(sb);
		
		sb.insert(sb.indexOf("문자열") + 3, "(String)");
		System.out.println(sb);
		
		// 인덱스 번호로 수정할 문자열의 시작, 종료 위치를 작성하여 수정
//		int stIdx = sb.indexOf("객체");
//		sb.replace(stIdx, stIdx + 2, "Object");
//		System.out.println(sb);
		
		// 수정 처리를 할 때 동일한 문자열에 대해 전부 수정이 되도록 한다
		// (수정 할 문자열 -> 객체, 변경문자열 -> Object)
		int idx = -1;
		String find = "객체";
		String change = "Object";
		while(true) {
			if(sb.indexOf(find, idx + 1) != -1) {
				idx = sb.indexOf(find, idx + 1);
				sb.replace(idx, idx + find.length(), change);
			} else {
				break;
			}
		}
		System.out.println(sb);
		
		// 인덱스 번호로 삭제할 문자열의 시작, 종료 위치를 작성하여 삭제
//		stIdx = sb.indexOf("(String)");
//		sb.delete(stIdx, stIdx + 8);
//		System.out.println(sb);
		
		// 삭제 처리를 할 때 동일한 문자열에 대해 전부 삭제가 되도록 한다.
		// (삭제 할 문자열 -> Object)
		idx = -1;
		find = "Object";
		while(true) {
			if(sb.indexOf(find, idx + 1) != -1) {
				idx = sb.indexOf(find, idx + 1);
				sb.delete(idx, idx + find.length());
			} else {
				break;
			}
		}
		System.out.println(sb);
	}

}
