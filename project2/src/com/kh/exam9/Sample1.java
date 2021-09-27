package com.kh.exam9;

import java.util.Scanner;

public class Sample1 {
	
	static Scanner sc = new Scanner(System.in);

	public void ex1() {
		Subject[] subjects = new Subject[3];
		subjects[0] = new Subject("국어", 70);
		subjects[1] = new Subject("영어", 80);
		subjects[2] = new Subject("수학", 90);
		
		// 과목명, 점수에 대해 사용자 입력을 받아서 배열의 마지막 인덱스에 추가
		// 단 점수의 경우 0 ~ 100 사이의 입력이 아니면 계속 입력하게 한다.
		
		// 과목명에서 종료라는 문자열이 입력되기 전까지 계속 정보를 입력받아 Subject 클래스의
		// 인스턴스가 Subject 객체 배열에 추가될 수 있게 한다.(동적 배열)
		
		// 새로운 과목을 추가 할 때 기존에 저장된 과목이 이미 존재하는 경우 다시 과목명을 입력
		// 하도록 한다.(과목배열에 저장된 객체를 전체 탐색(반복)하여 확인한다.)
		while(true) {
			System.out.print("과목명 입력 : ");
			String name = sc.nextLine();
			
			if(name.equals("종료")) {
				break;
			}
			
			boolean existed = false;
			// for each 문
			for(Subject s: subjects) {
				if(name.equals(s.getName())) {
					existed = true;
					break;
				}
			}
//			for(int i = 0; i < subjects.length; i++) {
//				if(name.equals(subjects[i].getName())) {
//					existed = true;
//					break;
//				}
//			}
			
			if(!existed) {
				Subject[] copy = new Subject[subjects.length + 1];
				System.arraycopy(subjects, 0, copy, 0, subjects.length);
				
				copy[copy.length - 1] = new Subject(name, -1);
				while(true) {
					System.out.print(name + " 점수 입력 : ");
					int num = sc.nextInt();	sc.nextLine();
					copy[copy.length - 1].setJumsu(num);
					if(copy[copy.length - 1].isValid()) {
						break;
					}
				}
				subjects = copy;
			}
		}
		
		for(int i = 0; i < subjects.length; i++) {
			System.out.println(subjects[i].getName() + " | " + subjects[i].getJumsu());
		}
	}

	public static void main(String[] args) {
		Student s = new Student("홍길동", 16);
		s.addSubject("국어", 80);
		s.addSubject("영어", 80);
		s.addSubject("수학", 65);
		
		System.out.println(s.getName() + " | " + s.getAge());
		System.out.println(s.getJumsu("국어"));
		System.out.println(s.getJumsu("영어"));
		System.out.println(s.getJumsu("수학"));
		System.out.println(s.getTotal() + " | " + s.getAvg());
	}
}
