package com.kh.exam14;

import java.util.*;

class Student implements Comparable<Student> {
	private String name;
	private int age;
	private char gender;
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	// 아래에 구현된 사항으로 작성된 것이 기본 정렬이다. 
	@Override
	public int compareTo(Student o) {
		// 나이를 기준으로 오름차순 정렬 -> Integer.compare(this.age, o.age)
		// 나이를 기준으로 내림차순 정렬 -> Integer.compare(o.age, this.age)
		if(Integer.compare(this.age, o.age) == 0) {
			return o.name.compareTo(this.name);
		}
		return Integer.compare(this.age, o.age);
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
		Student other = (Student) obj;
		return Objects.equals(name, other.name);
	}
	
}

class Subject implements Comparable<Subject> {
	private String name;
	private double score;
	
	public Subject(String name, double score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Subject o) {
		return Double.compare(this.score, o.score);
	}

	@Override
	public int hashCode() {
		// HashSet, HashMap 에서 동일한 객체인지 비교하기 위해 활용됨.
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
		Subject other = (Subject) obj;
		return Objects.equals(name, other.name);
	}
	
	
}

public class Sample6 {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("홍길동", 23, '남'));
		students.add(new Student("김주완", 21, '남'));
		students.add(new Student("박지연", 25, '여'));
		students.add(new Student("최은주", 24, '여'));
		students.add(new Student("이정태", 24, '남'));
		
		Collections.sort(students);
		
		for(Student s: students) {
			System.out.println(s);
		}
		
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(Integer.compare(s1.getGender(), s2.getGender()) == 0) {
					return Integer.compare(s1.getAge(), s2.getAge());
				}
				return Integer.compare(s1.getGender(), s2.getGender());
			}
		});
		
		for(Student s: students) {
			System.out.println(s);
		}
		
		System.out.println("========== 여기부터는 Set ==========");
		Set<Subject> subjects = new HashSet<Subject>();
		subjects.add(new Subject("국어", 83));
		subjects.add(new Subject("영어", 74));
		subjects.add(new Subject("수학", 91));
		subjects.add(new Subject("과학", 89));
		subjects.add(new Subject("수학", 78));
		
		for(Subject s: subjects) {
			System.out.println(s);
		}
		
		// TreeSet을 사용하여 정렬
		System.out.println("========== TreeSet ==========");
		TreeSet<Subject> treeSubjects = new TreeSet<Subject>(subjects);
		
		for(Subject s: treeSubjects) {
			System.out.println(s);
		}
		
//		Iterator<Subject> itor = treeSubjects.iterator();
//		while(itor.hasNext()) {
//			System.out.println(itor.next());
//		}
		
		// 오름차순은 Iterator 사용해야 함.
		Iterator<Subject> desc = treeSubjects.descendingIterator();
		while(desc.hasNext()) {
			System.out.println(desc.next());
		}
		
		Map<Student, Set<Subject>> grades = new HashMap<Student, Set<Subject>>();
		Student s = new Student("홍길동", 23, '남');
		Student find = new Student("홍길동");
		grades.put(s, new HashSet<Subject>());
		grades.get(find).add(new Subject("국어", 87));
		grades.get(find).add(new Subject("영어", 92));
		grades.get(find).add(new Subject("수학", 76));
		
		for(Map.Entry<Student, Set<Subject>> entry: grades.entrySet()) {
			System.out.println(entry.getKey().getName() + " 학생의 성적");
			TreeSet<Subject> tm = new TreeSet<Subject>(entry.getValue());
			ListIterator<Subject> it =  (new ArrayList<Subject>(tm)).listIterator();
			while(it.hasNext()) {
				Subject st = it.next();
				System.out.println("\t" + st.getName() + ":" + st.getScore());
			}
			
			System.out.println("===== 이전 데이터가 있으면 반복=====");
			while(it.hasPrevious()) {
				Subject st = it.previous();
				System.out.println("\t" + st.getName() + ":" + st.getScore());
			}
		}
	}

}