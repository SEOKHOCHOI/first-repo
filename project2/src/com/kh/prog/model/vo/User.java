package com.kh.prog.model.vo;

import java.util.Objects;

public class User extends Person {
	private static int CURRENT_ID = 0;
	private int userId = 0;
	private Email email;
	
	public User(String name) {
		this.userId = User.CURRENT_ID + 1;
		User.CURRENT_ID = this.userId;
		this.setName(name);
	}
	
	public User(int id, String name) {
		this.userId = id;
		this.setName(name);
	}
	
	public User(String name, int age) {
		this(name);
		this.setAge(age);
	}
	
	public User(String name, int age, char gender) {
		this(name, age);
		this.setGender(gender);
	}
	
	public User(String name, int age, char gender, String email) {
		this(name, age, gender);
		this.setEmail(email);
	}
	
	public User(String name, int age, char gender, Email email) {
		this(name, age, gender);
		this.setEmail(email);
	}
	
	public int getUserId() {
		return userId;
	}
	
	public Email getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = new Email(email);
	}
	
	public void setEmail(Email email) {
		this.email = email;
	}
	
	public boolean contains(String name) {
		return this.getName().contains(name);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + getName()
				+ ", age=" + getAge() + ", gender=" + getGender()
				+ ", email=" + email + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(userId, super.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return userId == other.userId
				&& super.equals(obj);
	}

	public static void main(String[] args) {
		User user = new User("홍길동");
		user.setEmail("hong@naver.com");
		System.out.println(user);
	}
	
}
