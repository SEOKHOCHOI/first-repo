package com.kh.practice.poly.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Member {
	private String name;
	private int age;
	private char gender;
	private int couponCount;
	private Date joinDate;
	private RentBook[] rentBooks;
	
	public Member() {}
	public Member(String name) {
		this.name = name;
	}
	public Member(String name, int age, char gender, Date joinDate) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.joinDate = joinDate;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public void setCouponCount(int count) {
		this.couponCount = count;
	}
	
	public int getCouponCount() {
		return this.couponCount;
	}
	
	public String getJoinDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this.joinDate);
	}
	
	public void setRentBook(RentBook book) {
		if(rentBooks == null) {
			rentBooks = new RentBook[1];
			rentBooks[0] = book;
		} else {
			RentBook[] temp = new RentBook[rentBooks.length + 1];
			System.arraycopy(rentBooks, 0, temp, 0, rentBooks.length);
			temp[temp.length - 1] = book;
			rentBooks = temp;
		}
	}
	
	public RentBook[] getRentBook() {
		return this.rentBooks;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", gender=" + gender
				+ ", couponCount=" + couponCount
				+ ", joinDate=" + getJoinDate() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(name, other.name);
	}
	
	

}