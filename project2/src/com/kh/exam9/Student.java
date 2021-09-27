package com.kh.exam9;

/*
 * 학생 클래스
 * 		학생의 정보를 담아서 관리하기 위한 클래스
 * 
 * 		속성(멤버 변수)
 * 			이름, 성별, 나이, 과목정보(Subject 클래스의 인스턴스가 담겨있는 객체배열)
 * 
 * 		기능(메서드)
 * 			getter/setter, 과목추가/수정/삭제, 점수확인(과목별 점수, 총점, 평균)
 */
public class Student {
	private String name;
	private String gender;
	private int age;
	private Subject[] subjects;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		this.subjects = new Subject[0];
	}
	
	// 동일한 이름의 과목이 이미 저장된 경우 false, 과목 점수의 범위가 벗어난 경우 false
	public boolean addSubject(String name, int num) {
		Subject temp = new Subject(name, num);
		if(!temp.isValid()) {
			return false;
		}
		for(Subject s: this.subjects) {
			if(name.equals(s.getName())) {
				return false;
			}
		}
		
		Subject[] copy = new Subject[this.subjects.length + 1];
		System.arraycopy(this.subjects, 0, copy, 0, this.subjects.length);
		copy[copy.length - 1] = temp;
		this.subjects = copy;
		return true;
	}
	
	// subjects 객체 배열에 Subject 클래스로 생성한 인스턴스 객체를 저장시키는 메서드
	public boolean addSubject(Subject subject) {
		return false;
	}
	
	public int getJumsu(String subjectName) {
		for(Subject s: this.subjects) {
			if(subjectName.equals(s.getName())) {
				return s.getJumsu();
			}
		}
		return -1;
	}
	
	public int getTotal() {
		int total = 0;
		for(Subject s: this.subjects) {
			total += s.getJumsu();
		}
		return total;
	}
	
	public double getAvg() {
		return (double)this.getTotal() / this.subjects.length;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}