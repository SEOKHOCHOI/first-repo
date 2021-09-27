package com.kh.exam16;

class TimeCounter extends Thread {
	private int count = 0;
	private String name;
	
	public TimeCounter(int count, String name) {
		this.count = count;
		this.name = name;
	}
	
	public void countStart() {
		while(count > 0) {
			System.out.println(this.name + " 카운터 - " + this.count);
			this.pause(1000);
			this.count--;
		}
	}
	
	@Override
	public void run() {
		// 쓰레드로 작업할 코드 작성
		this.countStart();
	}
	
	private void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Sample1 {

	public static void main(String[] args) {
		TimeCounter t1 = new TimeCounter(5, "t1");
		TimeCounter t2 = new TimeCounter(2, "t2");
		TimeCounter t3 = new TimeCounter(4, "t3");
		
		/*
		t1.countStart();  // 5 초 대기
		t2.countStart();  // 2 초 대기
		t3.countStart();  // 4 초 대기
		*/
		
		// 5 초면 모든 동작 완료
		t1.start();
		t2.start();
		t3.start();
	}

}