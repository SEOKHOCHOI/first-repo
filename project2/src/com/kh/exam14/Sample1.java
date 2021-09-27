package com.kh.exam14;

import java.util.*;

class Student1 {
	private int score;
	private String name;
	
	public Student1(String name, int score) {
		this.score = score;
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [score=" + score + ", name=" + name + "]";
	}
	
}

public class Sample1 {

	public static void main(String[] args) {
		// int[] : 정수 데이터를 저장할 배열 공간 지정 하는 방식과 유사.
		// List<Integer> iList = new ArrayList<Integer>();
		// List<Integer> iList = new Vector<Integer>();
		List<Integer> iList = new LinkedList<Integer>();
		// <Object Type> : 제네릭(Generic)으로 컬렉션에 저장할 객체 타입을 지정하기 위해 사용.
		
		// 추가
		System.out.println(iList);
		iList.add(10);
		System.out.println(iList);
		iList.add(20);
		System.out.println(iList);
		iList.add(30);
		System.out.println(iList);
		
		iList.add(1, 15);
		System.out.println(iList);
		iList.add(3, 25);
		System.out.println(iList);
		
		List<Integer> addList = new ArrayList<Integer>();
		addList.addAll(iList);
		System.out.println(addList);
		
		// 수정
		iList.set(1, 16);
		System.out.println(iList);
		iList.set(3, 26);
		System.out.println(iList);
		
		// 검색
		boolean resBool = iList.contains(20);
		System.out.println(resBool);
		resBool = iList.contains(25);
		System.out.println(resBool);
		
		int resInt = iList.indexOf(20);
		System.out.println(resInt);
		resInt = iList.indexOf(25);
		System.out.println(resInt);
		
		// int resInt = arr[0];
		resInt = iList.get(0);	// 인덱스 범위를 초과하면 -> IndexOutOfBoundsException
		System.out.println(resInt);
		
		// 전체 탐색 방법
		for(int i = 0; i < iList.size(); i++) {
			System.out.println("반복문으로 전체 탐색 -> " + iList.get(i));
		}
		
		Iterator<Integer> iter = iList.iterator();
		while(iter.hasNext()) {
			System.out.println("반복자를 사용한 전체 탐색 -> " + iter.next());
		}
		
		for(Integer i: iList) {
			System.out.println("for each 문을 사용한 전체 탐색 -> " + i);
		}
		
		// 삭제
		resInt = iList.remove(0);
		System.out.println(iList + " | " + resInt);
		
		resBool = iList.remove(new Integer(20));
		System.out.println(iList + " | " + resBool);
		
		resBool = iList.isEmpty();
		System.out.println(resBool);
		
		iList.clear();	// 전체 삭제
		System.out.println(iList);
		
		resBool = iList.isEmpty();
		System.out.println(resBool);
				
		// 정렬
		iList.add(13);	iList.add(15);	iList.add(12);	iList.add(11);
		System.out.println(iList);
		
		// 순서 뒤집기
		// Collections.reverse(iList);
		// System.out.println(iList);
		
		// 오름차순 정렬
		// Collections.sort(iList);
		// System.out.println(iList);
		
		// 오름차순 정렬 후 reverse 하면 내림차순 정렬이 됨
		// Collections.reverse(iList);
		// System.out.println(iList);
		
		// 내림차순 정렬
		Collections.sort(iList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) {
					return -1;
				} else if(o1 < o2) {
					return 1;
				}
				return 0;
			}
		});
		System.out.println(iList);
		
		List<Student1> sList = new ArrayList<Student1>();
		
		sList.add(new Student1("홍길동", 86));
		sList.add(new Student1("박수연", 76));
		sList.add(new Student1("금장현", 86));
		sList.add(new Student1("이정태", 76));
		sList.add(new Student1("김라현", 92));
		sList.add(new Student1("장지원", 82));
		
		Collections.sort(sList, new Comparator<Student1>() {
			@Override
			public int compare(Student1 s1, Student1 s2) {
				// 내림차순 정렬
				if(s1.getScore() > s2.getScore()) {
					return -1;
				} else if(s1.getScore() < s2.getScore()) {
					return 1;
				}
				return 0;
			}
		});
		
		Collections.sort(sList, new Comparator<Student1>() {
			@Override
			public int compare(Student1 s1, Student1 s2) {
				// 오름차순 정렬
				if(s1.getName().compareTo(s2.getName()) < 0) {
					return -1;
				} else if(s1.getName().compareTo(s2.getName()) > 0) {
					return 1;
				}
				return 0;
			}
		});
		
		Collections.sort(sList, new Comparator<Student1>() {
			@Override
			public int compare(Student1 s1, Student1 s2) {
				// 점수에 대해서는 내림차순
				// 만약 점수가 같으면 이름으로 오름차순
				int v1 = s1.getScore() - s2.getScore();
				int v2 = s1.getName().compareTo(s2.getName());
				if(v1 > 0) {
					return -1;
				} else if(v1 < 0) {
					return 1;
				}
				if (v2 < 0) {
					return -1;
				} else if (v2 > 0) {
					return 1;
				}
				return 0;
			}
		});
		
		for(Student1 s: sList) {
			System.out.println(s);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
