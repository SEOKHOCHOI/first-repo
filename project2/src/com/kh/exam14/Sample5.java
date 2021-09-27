package com.kh.exam14;

import java.util.*;
import java.util.Map.Entry;

public class Sample5 {
	
	public static String printUF(String name, int age) {
		return String.format("이름 : %s, 나이 : %d", name, age);
	}

	public static Map<String, Integer> ex1() {
		/*
		 * 다음의 요구 조건에 맞추어 Map 컬렉션을 만들어 보세요.
		 * 	- Map 에 사용할 키로 사용자명이 저장되게 한다.
		 * 	- Map 에 사용할 값으로 사용자의 나이가 저장되게 한다.
		 *  - 사용자 명과 나이는 다음의 정보를 이용하여 저장한다.
		 *  	키: "홍길동"	값: 24
		 *  	키: "김정희"	값: 26
		 *  	키: "박종훈"	값: 31
		 *  	키: "최강우"	값: 19
		 *  	키: "이여진"	값: 27
		 */
		Map<String, Integer> user = new HashMap<String, Integer>();
		user.put("홍길동", 24);
		user.put("김정희", 26);
		user.put("박종훈", 31);
		user.put("최강우", 19);
		user.put("이여진", 27);
		
		System.out.println(user);
		
		for(Map.Entry<String, Integer> e: user.entrySet()) {
			// System.out.println("이름 : " + e.getKey() + ", 나이 : " + e.getValue());
			System.out.println(printUF(e.getKey(), e.getValue()));
		}
		
		return user;
	}
	
	public static void ex2() {
		/*
		 * ex1() 문제에서 생성한 데이터를 이용하여 다음의 조건을 만족하도록 출력하시오.
		 * 	- 나이가 25세 이상인 사용자를 출력하시오.
		 * 	- 나이가 가장 어린 사용자와 나이가 가장 많은 사용자를 나이와 함께 출력하시오.
		 * 	- 평균 나이를 구하고 출력하시오.
		 */
		Map<String, Integer> user = ex1();
		
		System.out.println("나이가 25세 이상인 사용자는 다음과 같습니다.");
		for(Map.Entry<String, Integer> e: user.entrySet()) {
			if(e.getValue() >= 25) {
				System.out.println(printUF(e.getKey(), e.getValue()));
			}
		}
		
		Set<Map.Entry<String, Integer>> sEntry = user.entrySet();
		Map.Entry<String, Integer>[] mArr = sEntry.toArray(new Map.Entry[sEntry.size()]);
		List<Map.Entry<String, Integer>> lEntry = Arrays.asList(mArr);
		Collections.sort(lEntry, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue() < o2.getValue()) {
					return -1;
				} else if(o1.getValue() > o2.getValue()) {
					return 1;
				}
				return 0;
			}
		});
		System.out.println(lEntry.get(0) + "|" + lEntry.get(lEntry.size() - 1));
		
		System.out.println("나이가 가장 어린 사용자와 나이가 가장 많은 사용자는 다음과 같습니다.");
		Integer min = null, max = null;
		String minName = "", maxName = "";
		boolean isFirst = true;
		for(Map.Entry<String, Integer> e: user.entrySet()) {
			if(isFirst) {
				min = e.getValue();	max = e.getValue();
				minName = e.getKey();	minName = e.getKey();
				isFirst = false;
			} else {
				if(min > e.getValue()) {
					min = e.getValue();
					minName = e.getKey();
				}
				if(max < e.getValue()) {
					max = e.getValue();
					maxName = e.getKey();
				}
			}
		}
		System.out.println("연장자 이름 : " + maxName + ", 나이 : " + max);
		System.out.println("최연소 이름 : " + minName + ", 나이 : " + min);
		
		System.out.println("평균나이는 다음과 같습니다.");
		double tot = 0;
		for(Map.Entry<String, Integer> e: user.entrySet()) {
			tot += e.getValue();
		}
		System.out.println("평균나이는 " + tot / user.size() + "세 입니다.");
	}
	
	public static void ex3() {
		/*
		 * ex1() 문제에서 생성한 데이터를 이용하여 다음의 조건을 만족하도록 데이터를
		 * 수정하고 수정 결과를 출력하시오.
		 * 	- 모든 사용자의 나이를 +1 하시오.
		 * 	- "이여진" 사용자의 나이를 "김정희" 사용자의 나이로 수정하시오.
		 * 	- "홍길동" 사용자의 이름을 "홍주원" 으로 새로 만드시오.(기존의 사용자명은 없어야 함)
		 */
		
		Map<String, Integer> user = ex1();
		
		System.out.println("모든 사용자의 나이를 +1 한 결과는 다음과 같습니다.");
		for(String name: user.keySet()) {
			user.put(name, user.get(name) + 1);
		}
		
		System.out.println(user);
		
		System.out.println("'이여진' 사용자의 나이를 '김정희' 사용자의 나이로 수정한 결과 입니다.");
		user.put("이여진", user.get("김정희"));
		System.out.println(user);
		
		System.out.println("'홍길동' 사용자의 이름을 '홍주원'으로 새로 만든 결과입니다.");
		user.put("홍주원", user.remove("홍길동"));
		System.out.println(user);
		
	}
	
	public static Map<String, int[]> ex4() {
		/*
		 * 배열과 Map 을 혼합하여 다음의 조건을 만족하는 Map 컬렉션을 생성하시오.
		 * 	- Map 에 사용할 키로 사용자명이 저장되게 한다.
		 * 	- Map 에 사용할 값으로 정수 배열이 저장되게 한다.
		 *  - 사용자 명과 정수 배열에는 다음의 정보를 이용하여 저장한다.
		 *  	키: "홍길동"	값: new int[] {78, 89, 73, 86, 92}
		 *  	키: "김정희"	값: new int[] {82, 76, 93, 78, 79}
		 *  	키: "박종훈"	값: new int[] {85, 92, 79, 74, 77}
		 *  	키: "최강우"	값: new int[] {72, 84, 97, 70, 85}
		 *  	키: "이여진"	값: new int[] {96, 88, 91, 72, 80}
		 */
		Map<String, int[]> user = new HashMap<String, int[]>();
		user.put("홍길동", new int[] {78, 89, 73, 86, 92});
		user.put("김정희", new int[] {82, 76, 93, 78, 79});
		user.put("박종훈", new int[] {85, 92, 79, 74, 77});
		user.put("최강우", new int[] {72, 84, 97, 70, 85});
		user.put("이여진", new int[] {96, 88, 91, 72, 80});
		
		for(Map.Entry<String, int[]> e: user.entrySet()) {
			System.out.println(e.getKey() + "=" + Arrays.toString(e.getValue()));
		}
		
		return user;
		
	}
	
	public static void ex5() {
		/*
		 * ex4() 문제에서 생성한 데이터를 이용하여 다음의 조건을 만족하도록 출력하시오.
		 * 	- 사용자별 정수 배열의 합을 구하여 사용자 명과 총합을 출력하시오.
		 * 	- 사용자별 정수 배열의 정수값이 가장 큰값과 작은값을 출력하시오.
		 */
		Map<String, int[]> user = ex4();
		
		for(Map.Entry<String, int[]> e: user.entrySet()) {
			int tot = 0;
			for(int i = 0; i < e.getValue().length; i++) {
				tot += e.getValue()[i];
			}
			System.out.println(e.getKey() + "님의 점수 총합은 " + tot + "점 입니다.");
		}
		
		for(Map.Entry<String, int[]> e: user.entrySet()) {
			int min, max;
			min = max = e.getValue()[0];
			for(int i = 1; i < e.getValue().length; i++) {
				if(min > e.getValue()[i]) {
					min = e.getValue()[i];
				}
				if(max < e.getValue()[i]) {
					max = e.getValue()[i];
				}
			}
			System.out.println(e.getKey() + "님의 최고점은 " + max + "점, 최저점은 "
					+ min + "점 입니다.");
		}
	}
	
	public static void ex6() {
		/*
		 * ex4() 문제에서 생성한 데이터를 이용하여 다음의 조건을 만족하도록 데이터를
		 * 수정하고 수정 결과를 출력하시오.
		 * 	- 사용자별 정수 배열의 값을 모두 +5 하시오.(단 100이 넘는 경우 100으로 합니다)
		 * 	- 사용자별 정수 배열의 합과 평균을 구한 후 정수 배열에 추가 후 출력하시오.
		 */
		Map<String, int[]> user = ex4();
		
		System.out.println("기존 점수에 +5점을 수행한 결과입니다.");
		for(Map.Entry<String, int[]> e: user.entrySet()) {
			for(int i = 0; i < e.getValue().length; i++) {
				e.getValue()[i] += 5;
				if(e.getValue()[i] > 100) {
					e.getValue()[i] = 100;
				}
			}
		}
		
		// 별도의 출력
		for(Map.Entry<String, int[]> e: user.entrySet()) {
			System.out.println(e.getKey() + "=" + Arrays.toString(e.getValue()));
		}
		
		System.out.println("합과 평균을 구한 후 배열에 저장한 결과입니다.");
		for(Map.Entry<String, int[]> e: user.entrySet()) {
			int tot = 0;
			for(int i = 0; i < e.getValue().length; i++) {
				tot += e.getValue()[i];
			}
			int avg = tot / e.getValue().length;
			int[] temp = new int[e.getValue().length + 2];
			System.arraycopy(e.getValue(), 0, temp, 0, e.getValue().length);
			temp[temp.length - 2] = tot;
			temp[temp.length - 1] = avg;
			user.put(e.getKey(), temp);
		}
		
		for(Map.Entry<String, int[]> e: user.entrySet()) {
			System.out.println(e.getKey() + "=" + Arrays.toString(e.getValue()));
		}
		
	}
	
	public static void main(String[] args) {
		// ex6();
		// ex5();
		// ex4();
		// ex3();
		ex2();
		// ex1();
	}

}
