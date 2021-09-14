package com.kh.exam14;

import java.util.*;

public class Sample2 {

	public static void ex1() {
		/*
		 * 사용자 입력으로 정수 데이터를 받아 ArrayList에 저장 후
		 * ArrayList에 저장된 모든 정수들의 합을 구하여 출력한다.
		 * (단 사용자 입력은 한 번만 사용한다.)
		 */
		Scanner sc = new Scanner(System.in);
		List<Integer> aList = new ArrayList<Integer>();
		
		System.out.print("공백을 구분자로 사용하여 정수 입력 : ");
		String[] inputs = sc.nextLine().split(" ");//공백기준으로 분리. 분리된 내용은 inputs라는 문자열 배열에 저장될것. 이걸 ArrayList에 옮겨담으며 정수 데이터로 변환만 시켜주면 됨.
		
		for(String s : inputs) {
			aList.add(Integer.parseInt(s));
			
		}
		int total = 0;
		for(int i = 0; i < aList.size(); i++) {
			total += aList.get(i);
		}
		System.out.println(aList);
		System.out.println("총합 : " + total);
	}
	public static void ex2() {
		/*
		 * 사용자 입력으로 정수 데이터를 받아 ArrayList에 저장 후
		 * ArrayList에 저장된 모든 정수들의 합과 평균을  구하여 출력한다.
		 * (단 사용자 입력은 한 번만 사용한다.)
		 */
		Scanner sc = new Scanner(System.in);
		List<Double> aList = new ArrayList<Double>();
		
		System.out.print("공백을 구분자로 사용하여 실수 입력 : ");
		String[] inputs = sc.nextLine().split(" ");//공백기준으로 분리. 분리된 내용은 inputs라는 문자열 배열에 저장될것. 이걸 ArrayList에 옮겨담으며 정수 데이터로 변환만 시켜주면 됨.
		
		for(String s : inputs) {
			aList.add(Double.parseDouble(s));
			
		}
		double total = 0;
		for(int i = 0; i < aList.size(); i++) {
			total += aList.get(i);
		}
		System.out.println(aList);
		System.out.println("총합 : " + total);
		System.out.println("평균 : " + total / aList.size());
	}
	public static void ex3() {
		/*
		 * 다음의 요구사항을 잘 보고 요구사항에 맞도록 구현한다.
		 * - 사용자 입력으로 정수 데이터를 받아 ArrayList에 저장을 해야한다.
		 * - 사용자 입력으로 하나의 정수 데이터를 입력 할 수 있지만 2개 이상의 정수를 입력하기도 한다.
		 * - 동일한 정수 데이터는 ArrayList에 저장되지 않도록 한다.
		 */
		Scanner sc = new Scanner(System.in);
		List<Integer> aList = new ArrayList<Integer>();
		
		System.out.print("공백을 구분자로 사용하여 정수 입력 : ");
		String[] inputs = sc.nextLine().split(" ");//공백기준으로 분리. 분리된 내용은 inputs라는 문자열 배열에 저장될것. 이걸 ArrayList에 옮겨담으며 정수 데이터로 변환만 시켜주면 됨.
		
		for(String s : inputs) {
			int num = Integer.parseInt(s);
			if(!(aList.indexOf(num) >= 0)) {
				aList.add(num);
			}
			
			//if(!aList.contains(num)) {
			//aList.add(num);
			//}
		}
		int total = 0;
		for(int i = 0; i < aList.size(); i++) {
			total += aList.get(i);
		}
		System.out.println(aList);
		
	}
	public static void ex4() {
		/*
		 * 사용자 입력을 최소값, 최대값, 갯수를 읿력받아 다음 요구사항에 맞도록 구현한다.
		 * -최소값, 최대값은 랜덤을 통해 생성할 값의 범위이다.
		 * -갯수는 랜덤을 통해 생성할 값의 수량 이다.
		 * -생성된 랜덤값은 ArrayList에 저장한다.
		 * -ArrayList에 저장한 정수는 중복이 없어야 한다.
		 */
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		List<Integer> aList = new ArrayList<Integer>();
		System.out.print("최소값 최대값 입력(공백을 구분자로 사용하세요) : ");
		String[] minMax = sc.nextLine().split(" ");
		int min = Integer.parseInt(minMax[0]);
		int max = Integer.parseInt(minMax[1]);
		
		System.out.print("갯수를 입력하세요  : ");
		int count = sc.nextInt(); sc.nextLine();
		
		for(int i = 0; i < count; ) {
			int randNum = rd.nextInt(max - min + 1) + min;
			if(!aList.contains(randNum)) {
				aList.add(randNum);
				i++;
			}
		}
		System.out.println(aList);
	}
	public static void ex5() {
		/*
		 * 현재 날짜를 구한 후 ArrayList에 년, 월, 일, 시간, 분, 초 데이터가
		 * 저장되도록 한다.
		 */
		GregorianCalendar gc = new GregorianCalendar();
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(gc.get(Calendar.YEAR));
		aList.add(gc.get(Calendar.MONTH)+1);//0~11로 반환되니 Calendar이용할땐 +1 꼭 해줘.
		aList.add(gc.get(Calendar.DATE));
		aList.add(gc.get(Calendar.HOUR));
		aList.add(gc.get(Calendar.MINUTE));
		aList.add(gc.get(Calendar.SECOND));
		
		System.out.println(aList);
		
	}
	public static void ex6() {
		/*
		 * 3초에 한번씩 정기적으로 1~99 사이의 랜덤값을 ArrayList에 저장을 하도록 한다
		 * ArrayList에 저장하는 데이터는 10개로 제한한다.
		 *///GregorianCalendar 날짜객체 이용해! 
		GregorianCalendar gcStart = null;
		GregorianCalendar gcEnd = null;
		Random rd = new Random();
		List<Integer> aList = new ArrayList<Integer>();
		
		gcStart = new GregorianCalendar();
		while(aList.size() < 10) {
			gcEnd = new GregorianCalendar();
			if((gcStart.get(Calendar.SECOND) + 3) % 60 == gcEnd.get(Calendar.SECOND)) {
				aList.add(rd.nextInt(99) + 1);
				gcStart = gcEnd;
				System.out.println(aList);
			}
		}
		//여기다 System~ 해주면 30초 지난 후 생성되기 시작함. 너무 오래걸리니 위에한거임.
	}
	public static void ex7() {
		/*
		 * 3초에 한번씩 정기적으로 1 ~ 99 사이의 랜덤값을 ArrayList 에 저장을 할 때 저장 시간도
		 * 같이 ArrayList에 저장하도록 하며 저장하는 데이터는 10개로 제한한다.
		 * (단, 중복 데이터는 저장이 안되도록 하며, ArrayList를 2개 이용하도록 한다. 시간은 년월일
		 * 시분초까지만 저장하도록 한다.)
		 */
	}
	public static void ex8() {
		/*
		 * ArrayList 에 다음의 단어를 미리 초기화 한 후 다음 요구사항에 마즌ㄴ 프로그램을 작성한다.
		 * -abstract, continue, for, new, switch, default, package,
		 *  synchronized, boolean, do, if, private, this, break,
		 *  double, implements, protected, throw, byte, else, import,
		 *   public, throws, case, instanceof, return, catch, extends,
		 * 	  int, short, try, char, final, interface, static, void,
		 * 	  class, finally, long, float, super, while
		 * 	- ArrayList에 저장된 문자열을 랜덤으로 출력하게 만든다.
		 * 	- 랜덤으로 출력된 문자열을 사용자 입력으로 사용자가 입력하게 만든다.
		 * 	- 사용자가 입력한 데이터가 출력된 문자열과 동일하면 다음 문자열이 다시 랜덤으로 출력되게 한다.
		 * 	- 위 과정을 10번 반복하여 모든 문자열을 입력한 총 시간과 정확하게 입력한 문자열의 수, 잘못
		 * 	  입력한 문자열의 수를 테이블 형태로 출력하게 한다.
		 */
	}
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		//ex5();
		//ex6();
		ex7();
	}

}
