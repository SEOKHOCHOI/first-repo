package com.kh.exam12;

import java.util.Arrays;

public class Sample1 {

	public static void main(String[] args) {
		// 문자열 관련 메서드
		String str = "동일한 문자열인지 비교";
		boolean resBool = str.equals("동일한 문자열인지 비교");
		System.out.println(resBool);
		
		str = "문자열에서 문자를 추출하기 위한 메서드";
		char resChar = str.charAt(2);
		System.out.println(resChar);
		
		str = "문자열의 길이를 구하는 메서드";
		int resInt = str.length();
		System.out.println(resInt);
		
		str = "문자열에 특정 문자열이 포함되어 있는지 확인하는 메서드";
		resBool = str.contains("포함");
		System.out.println(resBool);
		
		str = "문자열에서 특정 문자열을 찾아서 변경하는 메서드";
		String resStr = str.replace("특정", "일부");
		System.out.println(resStr);
		
		str = "문자열에서 특정 구분자를 기준으로 문자열 분리";
		String[] resStrArr = str.split(" ");
		System.out.println(Arrays.toString(resStrArr));
		str = "010-1234-5678";
		resStrArr = str.split("-");
		System.out.println(Arrays.toString(resStrArr));
		str = "username@domain.com";
		resStrArr = str.split("@");
		System.out.println(Arrays.toString(resStrArr));
		
		str = "분리된 문자열을 특정 구분자를 기준으로 재결합";
		resStrArr = str.split(" ");
		resStr = String.join("\t", resStrArr);
		System.out.println(resStr);
		str = "010-1234-5678";
		resStrArr = str.split("-");
		resStr = String.join("-", resStrArr);
		System.out.println(resStr);
		
		str = "    불필요한 앞/뒤 공백을 제거    ";
		resStr = str.trim();
		System.out.println(resStr);
		
		str = "문자열에서 일부 문자열만 분리";
		resStr = str.substring(6);
		System.out.println(resStr);
		resStr = str.substring(6, 8);
		System.out.println(resStr);
		
		str = "문자열에서 지정한 문자열의 위치 찾기";
		resInt = str.indexOf("지정");
		System.out.println(resInt);
		resInt = str.indexOf("지정");
		resStr = str.substring(resInt, resInt + 2);
		System.out.println(resStr);
		
		resInt = str.indexOf("문자열", 0);
		System.out.println(resInt);
		resInt = str.indexOf("문자열", resInt + 1);
		System.out.println(resInt);
		resInt = str.indexOf("문자열", resInt + 1);
		System.out.println(resInt);
		
		str = "이 문자열에는 다양한 문자들이 포함되어 있는 문자열입니다.";
		// 위 문자열에서 "문자" 라는 단어가 몇개 있는지, 그리고 어느 위치에 있는지를
		// 구하는 코드를 작성하시오. (찾은 문자열의 위치는 정수 배열에 저장하시오.)
		int[] resIntArr = new int[0];
		int idx = -1;
		String find = "문자";
		while(true) {
			if(str.indexOf(find, idx + 1) != -1) {
				int[] temp = new int[resIntArr.length + 1];
				System.arraycopy(resIntArr, 0, temp, 0, resIntArr.length);
				idx = str.indexOf(find, idx + 1);
				temp[temp.length - 1] = idx;
				resIntArr = temp;
			} else {
				break;
			}
		}
		System.out.println(find + "라는 단어는 총 " + resIntArr.length + "개 있습니다.");
		System.out.println(Arrays.toString(resIntArr));
		
		str = "영문자를 대문자/소문자로 변경. AbCdEf";
		resStr = str.toUpperCase();
		System.out.println(resStr);
		
		str = "영문자를 대문자/소문자로 변경. AbCdEf";
		resStr = str.toLowerCase();
		System.out.println(resStr);
		
		str = "정수 포멧 : %d";
		resStr = String.format(str, 10);
		System.out.println(resStr);
		
		str = "실수 포멧 : %.2f";
		resStr = String.format(str, 12.345);
		System.out.println(resStr);
		
		str = "문자열 포멧 : %s";
		resStr = String.format(str, "가나다라");
		System.out.println(resStr);
		
		str = "문자 포멧 : %c";
		resStr = String.format(str, 65);
		System.out.println(resStr);
		
		str = "천단위구분 포멧 : %,d";
		resStr = String.format(str, 123456789);
		System.out.println(resStr);
		
		str = "천단위구분 포멧 : %,.2f";
		resStr = String.format(str, 123456.789);
		System.out.println(resStr);
		
		str = "일정한 영역에서 오른쪽 정렬 포멧 : %10d";
		resStr = String.format(str, 12);
		System.out.println(resStr);
		
		str = "일정한 영역에서 왼쪽 정렬 포멧 : %-10d";
		resStr = String.format(str, 12);
		System.out.println(resStr);
		
		str = "일정한 영역에서 오른쪽 정렬 포멧 : %10s";
		resStr = String.format(str, "가나다라");
		System.out.println(resStr);
		
		str = "일정한 영역에서 왼쪽 정렬 포멧 : %-10s";
		resStr = String.format(str, "가나다라");
		System.out.println(resStr);
		
		// 표 형태의 출력물
		String sep = "----------";
		str =  "+%10s+%10s+%10s+\n";
		str += "|%10s|%10s|%10s|\n";
		str += "+%10s+%10s+%10s+";
		resStr = String.format(str, sep, sep, sep, "Col 1", "Col 2", "Col 3"
				, sep, sep, sep);
		System.out.println(resStr);
		
		str = "%s 님의 나이는 %d세 입니다.";
		resStr = String.format(str, "홍길동", 25);
		System.out.println(resStr);
		
		str = "%2$s 님의 나이는 %1$d세 입니다.";
		resStr = String.format(str, 25, "홍길동");
		System.out.println(resStr);
		
		str = "아스키 코드 %1$d 는 아스키 문자 %1$c 입니다.";
		resStr = String.format(str, 65);
		System.out.println(resStr);
	}

	
	
	
	
	
	
	
	
}
