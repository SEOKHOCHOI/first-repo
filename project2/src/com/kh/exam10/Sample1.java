package com.kh.exam10;

class Person {
	protected String name;
	protected int age;
	
	{
		name = "홍길동";
		age = 16;
	}
	
	public Person() {}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

class Student extends Person {
	private int level;
	
	public Student() {}
	
	public Student(String name, int age) {
		super(name, age);
	}
	
	public Student(String name, int age, int level) {
		super(name, age);
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + this.name + ", age=" + this.age + ", level="
				+ this.level + "]";
	}
}

public class Sample1 {

	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p);
		
		Student s = new Student();
		System.out.println(s);
		
//		Student s = new Student("홍길동", 30, 2);
//		System.out.println(s);
		
		// System.out.println(p1.equals(p2));
		
//		Student s = new Student();
//		s.setName("홍길동");	s.setAge(30);
//		System.out.println(s.getName() + " | " + s.getAge());
	}

}
