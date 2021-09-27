package com.kh.exam14;

import java.util.*;

public class Sample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> hSet = new HashSet<Integer>();
		
		// 추가
		hSet.add(10);	hSet.add(20);	hSet.add(30);
		System.out.println(hSet);
		
		// 중복 안됨
		hSet.add(20);
		System.out.println(hSet);
		
		// 검색
		boolean resBool = hSet.contains(10);
		System.out.println(resBool);
		
		resBool = hSet.contains(40);
		System.out.println(resBool);
		
		// 갯수 확인
		int resInt = hSet.size();
		System.out.println(resInt);
		
		// 삭제(객체로 삭제)
		// resBool = hSet.remove(10);
		// System.out.println(hSet + " | " + resBool);
		
		// 삭제(전체 삭제)
		// hSet.clear();
		
		// 비어 있는지 확인
		resBool = hSet.isEmpty();
		System.out.println(hSet + " | " + resBool);
		
		// for each 로 전체 탐색
		for(Integer i: hSet) {
			System.out.println("for each로 전체 탐색 -> " + i);
		}
		
		// 배열로 변환하여 탐색
		Object[] oArr = hSet.toArray();
		System.out.println((Integer) oArr[1]);
		
		Integer[] iArr = hSet.toArray(new Integer[hSet.size()]);
		System.out.println(iArr[2]);
		
		// 리스트 계열의 컬렉션으로 변환
		List<Integer> aList = new ArrayList<Integer>(hSet);
		// List<Integer> aList = Arrays.asList(
		// 		hSet.toArray(new Integer[hSet.size()]));
		System.out.println(aList.get(0));
		
		// 리스트 계열의 컬렉션을 Set 계열의 컬렉션으로 변환
		hSet = new HashSet<Integer>(aList);
		System.out.println(hSet);
		
		// 추가하는 데이터의 순서를 유지해준다. 
		Set<Integer> lSet = new LinkedHashSet<Integer>(aList);
		System.out.println(lSet);
		
		// 객체 추가와 동시에 정렬이 이루어 진다.(속도 느림)
		Set<Integer> tSet = new TreeSet<Integer>(aList);
		System.out.println(tSet);
	}

	
	
	
	
	
	
	
	
	
	
	
}

