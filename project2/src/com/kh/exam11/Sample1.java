package com.kh.exam11;

public class Sample1 {

	public static void main(String[] args) {
		Person[] pArr = new Person[5];
		pArr[0] = new Student("김정훈", 16, '남');
		pArr[1] = new Student("홍길동", 18, '남');
		pArr[2] = new Worker("최금록", 34, '남');
		pArr[3] = new Student("강지은", 17, '여');
		pArr[4] = new Worker("박하연", 34, '여');
		
		for(Person p: pArr) {
			if(p instanceof Art) {
				((Art) p).draw();
			} else if(p instanceof Sport) {
				((Sport) p).run();
			}
			
			if(p instanceof Soldier) {
				((Soldier) p).shooting();
			}
		}
		
		Student s1 = new Student("홍길동", 18, '남');
		Worker w1 = new Worker("박찬호", 38, '남');
		
		((Art)s1).draw();
		((Art)s1).sculp();
		((Art)s1).sketch();
		
		((Soldier)w1).battle();
		((Soldier)w1).shooting();
		((Soldier)w1).training();
	}

}