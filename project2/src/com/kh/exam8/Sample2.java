package com.kh.exam8;

class Student {
	
	private String name;
	private int age;
	private char gender;
	private int rank;
	
	public Student() {}
	
	public Student(String name) {
		this.name = name;
	}
	
	public String info() {
		String text = "";
		text += "이름 : " + this.name + "(" + this.age + " 세)\n";
		text += "성별 : " + this.gender + "\n";
		text += "성적 순위 : " + this.rank + " 등";
		return text;
	}
	
	public void rankUp(int rank) {
		this.rank -= rank;
	}
	
	public void rankDown(int rank) {
		this.rank += rank;
	}
	
	public boolean isHigh(Student student) {
		if(this.rank < student.rank) {
			return true;
		}
		return false;
	}
	
	public boolean isLow(Student student) {
		if(this.rank > student.rank) {
			return true;
		}
		return false;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}

public class Sample2 {

	public static void main(String[] args) {
		/*
		 * 클래스를 사용하여 인스턴스를 만들고 만들어진 인스턴스를 사용하는 코드를
		 * 보고 해당 코드에 적합한 클래스를 작성해보도록 한다.
		 * (단, 이 클래스는 캡슐화를 적용한다.)
		 */
		Student s1 = new Student();
		s1.setName("홍길동");
		s1.setAge(21);
		s1.setGender('남');
		s1.setRank(100);

		/*
		 * 이름 : 홍길동(21 세)
		 * 성별 : 남
		 * 성적 순위 : 100 등
		 */
		System.out.println(s1.info());

		s1.rankUp(5);

		/*
		 * 이름 : 홍길동(21 세)
		 * 성별 : 남
		 * 성적 순위 : 95 등
		 */
		System.out.println(s1.info());

		s1.rankDown(3);
		
		/*
		 * 이름 : 홍길동(21 세)
		 * 성별 : 남
		 * 성적 순위 : 98 등
		 */
		System.out.println(s1.info());


		Student s2 = new Student("박지은");
		s2.setAge(20);
		s2.setGender('여');
		s2.setRank(90);

		/*
		 * 이름 : 박지은(20 세)
		 * 성별 : 여
		 * 성적 순위 : 90 등
		 */
		System.out.println(s2.info());

		if(s2.isHigh(s1)) {
			System.out.println(s2.getName() + "님의 등수가 " + s1.getName() + " 님의"
					+ " 등수보다 높습니다.");
		} else {
			System.out.println(s2.getName() + "님의 등수가 " + s1.getName() + " 님의"
					+ " 등수보다 높진 않습니다.");
		}

		if(s2.isLow(s1)) {
			System.out.println(s2.getName() + "님의 등수가 " + s1.getName() + " 님의"
					+ " 등수보다 낮습니다.");
		} else {
			System.out.println(s2.getName() + "님의 등수가 " + s1.getName() + " 님의"
					+ " 등수보다 낮진 않습니다.");
		}
		
	}

}