package com.kh.exam11;

public class Student extends Person implements Art {

	public Student(String name, int age, char gender) {
		super(name, age, gender);
	}
	
	@Override
	public void addAge() {
		this.setAge(getAge() + 1);
	}

	@Override
	public void draw() {
		System.out.println(this.getName() + "이(가)그림 그리기 수업중 입니다.");
	}

	@Override
	public void sculp() {
		System.out.println(this.getName() + "이(가)조각을 민드는 수업중 입니다.");
	}

	@Override
	public void sketch() {
		System.out.println(this.getName() + "이(가)스케치를 그리는 수업을 하고있습니다.");
	}

	@Override
	public void painting() {
		System.out.println(this.getName() + "이(가)그림에 페이팅을 하는 수업을 하고있습니다.");
	}

}
