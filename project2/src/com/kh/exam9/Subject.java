package com.kh.exam9;

public class Subject {
	private String name;
	private int jumsu;
	private int min;
	private int max;
	
	public Subject() {
		this.max = 100;
	}
	
	public Subject(String name) {
		this();
		this.name = name;
	}
	
	public Subject(String name, int num) {
		this();
		this.name = name;
		this.setJumsu(num);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setJumsu(int num) {
		if(num >= this.min && num <= this.max) {
			this.jumsu = num;
		} else {
			this.jumsu = -1;
		}
	}
	
	public int getJumsu() {
		return this.jumsu;
	}
	
	public void setRangeJumsu(int min, int max) {
		this.min = min;
		this.max = max;
		if(this.jumsu > 0) {
			this.jumsu = (int)(this.jumsu / 100.0 * this.max);
		}
	}
	
	public int[] getRangeJumsu() {
		return new int[] {this.min, this.max};
	}
	
	public boolean isValid() {
		if(this.jumsu == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public String getGrade() {
		double p = this.max / 100.0;
		String res = "F";
		if(this.jumsu <= this.max && this.jumsu >= (p * 90)) {
			res = "A";
		} else if(this.jumsu < (p * 90) && this.jumsu >= (p * 80)) {
			res = "B";
		} else if(this.jumsu < (p * 80) && this.jumsu >= (p * 70)) {
			res = "C";
		} else if(this.jumsu < (p * 70) && this.jumsu >= (p * 60)) {
			res = "D";
		}
		return res;
	}
	
	public boolean equalSubject(Subject s) {
		return this.name.equals(s.name);
	}
	
	public boolean gt(Subject s) {
		return this.jumsu > s.jumsu;
	}
	
	public boolean ge(Subject s) {
		return this.jumsu >= s.jumsu;
	}
	
	public boolean lt(Subject s) {
		return this.jumsu < s.jumsu;
	}
	
	public boolean le(Subject s) {
		return this.jumsu <= s.jumsu;
	}
	
	public boolean eq(Subject s) {
		return this.jumsu == s.jumsu;
	}
	
	public boolean nq(Subject s) {
		return this.jumsu != s.jumsu;
	}
}
