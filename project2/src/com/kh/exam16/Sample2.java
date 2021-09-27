package com.kh.exam16;

import java.lang.Thread.State;

// extends 하나의 클래스만 상속할 수 있다.
// implements 여러 인터페이스를 상속할 수 있다.
class TimeCounter2 implements Runnable {
	private int count = 0;
	private String name;
	
	public TimeCounter2(int count, String name) {
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


public class Sample2 {
	
	public static void main(String[] args) {
		System.out.println("메인 쓰레드의 메인 메서드 실행");
		
		TimeCounter2 t1 = new TimeCounter2(5, "t1");
		TimeCounter2 t2 = new TimeCounter2(2, "t2");
		TimeCounter2 t3 = new TimeCounter2(4, "t3");
		
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		Thread thread3 = new Thread(t3);
		
		System.out.println(thread1.getState());
		thread1.start();
		System.out.println(thread1.getState());
		
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println(thread1.getState());
				if(thread1.getState() == State.TERMINATED) {
					System.out.println(thread1.getState());
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		thread2.start();
		thread3.start();
		
		System.out.println("메인 쓰레드의 메인 메서드 종료");
	}
}