package com.kh.exam8;

class Subject {
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

public class Sample3 {

	public static void main(String[] args) {
		// 과목 클래스
		// 아래와 같은 다양한 방식으로 과목 클래스의 인스턴스 생성 가능
		Subject sub1 = new Subject();
		Subject sub2 = new Subject("국어");		// 과목명을 전달하여 인스턴스 생성
		Subject sub3 = new Subject("수학", 80);	// 과목명과 점수를 전달하여 인스턴스 생성
		
		sub1.setName("영어");		// 과목명을 별도의 Setter 이용하여 저장 가능
		
		/*
		 * 점수는 0 ~ 100 사이의 정수만 입력받아 저장할 수 있다.
		 * 범위를 벗어난 값의 입력이 있는 경우 -1 이 저장되도록 한다.
		 */
		sub1.setJumsu(70);		// 점수를 별도의 Setter 이용하여 저장 가능
		
		/*
		 * 저장된 점수가 올바른 범위의 점수인지 확인하는 메서드이다.
		 * 올바른 점수인 경우 true, 올바르지 않은 경우 false 를 반환한다.
		 */
		if(sub1.isValid()) {
			System.out.println("점수가 유효합니다.");
		} else {
			System.out.println("점수가 유효하지 않습니다.");
		}
		
		/*
		 * 저장된 점수를 기반으로 등급 반환, 등급은 A ~ D 그리고 F
		 * A 등급은 100 ~ 90 이상
		 * B 등급은 90 미만 ~ 80 이상
		 * C 등급은 80 미만 ~ 70 이상
		 * D 등급은 70 미만 ~ 60 이상
		 * F 등급은 60 미만
		 */
		System.out.println(sub1.getGrade());
		
		/* 
		 * 점수의 입력 범위를 한정하기 위한 메서드이다. 기본값으로 0 ~ 100 의 범위가 설정되어 있지만
		 * 아래의 메서드를 통해 입력 범위를 제한 할 수 있다.
		 * 이미 점수가 입력되어 있는 상태에서 범위가 변경되면 기존 점수도 범위에 맞추어 재설정 되어야 한다.
		 */
		sub1.setJumsu(94);
		System.out.println(sub1.getJumsu());
		sub1.setRangeJumsu(0, 10);	// 점수의 입력 범위를 0 ~ 10 으로 한정한다.
		System.out.println(sub1.getJumsu());
		
		// 점수의 입력 범위를 확인 할 수 있게 만들어 주는 메서드이다.
		int[] rg = sub1.getRangeJumsu();
		
		// 점수의 범위가 변경이 되면 등급 또한 변경된 범위에 맞추어 계산이 이루어져야 한다.
		System.out.println(sub1.getGrade());
		
		// 동일한 과목인지 비교하는 메서드이다.
		if(sub1.equalSubject(sub2)) {
			System.out.println("동일한 과목 입니다.");
		} else {
			System.out.println("동일한 과목이 아닙니다.");
		}
		
		/* 
		 * 점수를 비교하는 메서드이다.
		 * 이 메서드는 gt, lt, ge, le, eq, nq 의 추가 메서드도 만들어서 동작하게 한다.
		 * gt : 큰값인지 비교하기 위해 사용
		 * ge : 크거나 같은 값인지 비교하기 위해 사용
		 * lt : 작은값인지 비교하기 위해 사용
		 * le : 작거나 같은값인지 비교하기 위해 사용
		 * eq : 같은 값인지 비교하기 위해 사용
		 * nq : 다른 값인지 비교하기 위해 사용
		 */
		if(sub1.gt(sub2)) {
			System.out.println(sub1.getName() + "의 점수가 더 높습니다.");
		}
	}

}
