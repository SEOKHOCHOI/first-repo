package com.kh.exam14;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Sample4 {

	public static void main(String[] args) {
		/*
		 *  Map : 키와 값의 쌍으로 데이터를 관리하는 구조
		 *        키의 경우 중복을 허용하지 않음(동일한 키가 있으면 덮어씀)
		 *        값은 중복을 허용함
		 *        키와 값의 쌍을 Entry 라고 한다.
		 */
		//  키의 자료형(객체), 값의 자료형(객체)
		Map<String, Integer> hMap = new HashMap<String, Integer>();
		
		// 추가
		hMap.put("a", 10);	hMap.put("b", 20);	hMap.put("c", 30);
		System.out.println(hMap);
		
		// 값 수정
		hMap.put("a", 40);	hMap.put("c", 50);
		System.out.println(hMap);
		
		// contains 로 키와 값의 유무 확인
		boolean resBool = hMap.containsKey("b");
		System.out.println("키 \"b\" 가 존재합니까? " + resBool);
		
		resBool = hMap.containsKey("h");
		System.out.println("키 \"h\" 가 존재합니까? " + resBool);
		
		resBool = hMap.containsValue(20);
		System.out.println("값 20 이 존재합니까? " + resBool);
		
		resBool = hMap.containsValue(60);
		System.out.println("값 60 이 존재합니까? " + resBool);
		
		// 키/값 쌍 추출
		Set<Map.Entry<String, Integer>> entry = hMap.entrySet();
		System.out.println(entry);
		
		for(Map.Entry<String, Integer> e: entry) {
			System.out.println(e);
		}
		
		for(Map.Entry<String, Integer> e: entry) {
			System.out.println("Key:" + e.getKey() + ", Value:" + e.getValue());
		}
		
		// 키(Set) 또는 값(List)만 추출
		Set<String> keys = hMap.keySet();
		System.out.println(keys);
		
		List<Integer> values = new ArrayList<Integer>(hMap.values());
		System.out.println(values);
		
		// 크기(갯수) 확인
		int resInt = hMap.size();
		System.out.println(resInt);
		
		// 키로 값 추출
		resInt = hMap.get("a");
		System.out.println(resInt);
		
		// resInt = hMap.get("f");
		resInt = hMap.getOrDefault("f", -1);
		System.out.println(resInt);
		
		// 삭제
		// resInt = hMap.remove("a");
		// System.out.println(hMap + " | " + resInt);
		
		// if(hMap.remove("a") == null) {
		// 	System.out.println("이미 삭제된 데이터 입니다.");
		// }
		
		// resBool = hMap.remove("b", 10);
		// System.out.println(hMap + " | " + resBool);
		
		// resBool = hMap.remove("b", 20);
		// System.out.println(hMap + " | " + resBool);
		
		// HashTable : 멀티쓰레드에 대한 쓰레드 safe 기능을 제공
		Map<String, Integer> hTable = new Hashtable<String, Integer>(hMap);
		System.out.println(hTable);
		
		// TreeMap : 트리 계층 구조를 활용하여 검색 기능을 강화한 컬렉션
		//           정렬을 할 수 있다.(java.lang.Compareable 을 구현한 객체가 필요)
		//           Integer, Double 은 정수/실수 값으로 정렬
		//           String 은 유니코드 값으로 정렬
		Map<String, Integer> hTree = new TreeMap<String, Integer>(hMap);
		System.out.println(hTree);
		
		// 키와 값을 문자열 타입으로 제란한 Map 컬렉션
		// 속성파일을 읽거나 쓰기위한 목적으로 주로 사용(파일입출력이 필요)
		Properties prop = new Properties();
		
		prop.setProperty("속성명1", "속성값1");
		prop.setProperty("속성명2", "속성값2");
		prop.setProperty("속성명3", "속성값3");
		
		System.out.println(prop);
		System.out.println(prop.getProperty("속성명1"));
		
		try {
			// prop.store(new FileWriter(new File("/Users/사용자계정명/properties.prop")), "속성파일");
			// 상대 경로 : ./ -> 현재 실행 위치
			prop.store(new FileWriter(new File("D:\\properties.prop")), "File");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Properties loadProp = new Properties();
		try {
			// loadProp.load(new FileReader(new File("D:\\properties.prop")));
			String f = "C:\\Users\\user2\\eclipse\\jee-2021-06\\eclipse\\configuration\\config.ini";
			loadProp.load(new FileReader(new File(f)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(loadProp);
		
		// 키를 Set 컬렉션에 담아서 반환
		Set<Object> s = loadProp.keySet();
		for(Object o: s) {
			String k = o.toString();
			System.out.println(k + "=" + loadProp.getProperty(k));
		}
		
	}
	
}
