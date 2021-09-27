package com.kh.exam16;

import java.util.Random;

class Downloading implements Runnable {
	
	private String name;
	private double persecnt = 0;
	private Random rand = new Random();
	private int row;
	
	public Downloading(String name, int row) {
		this.name = name;
		this.row = row;
	}
	
	public void down() {
		String s = name + " - ";
	}

	@Override
	public void run() {
		// byte[] code = (27 + "[" + row + ";1H").getBytes();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 15; i++) {
			sb.append("■");
			System.out.print(this.name + sb.toString() + "\r");
			System.out.flush();
			try {
				Thread.sleep((rand.nextInt(5) + 1) * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.name + sb.toString() + "완료!!");
	}
	
}

public class Sample3 {

	public static void main(String[] args) throws InterruptedException {
		
		Downloading d1 = new Downloading("파일명1", 1);
		Downloading d2 = new Downloading("파일명2", 2);
		Downloading d3 = new Downloading("파일명3", 3);
		Downloading d4 = new Downloading("파일명4", 4);
		Downloading d5 = new Downloading("파일명5", 5);
		
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		Thread t3 = new Thread(d3);
		Thread t4 = new Thread(d4);
		Thread t5 = new Thread(d5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
//		StringBuffer sb = new StringBuffer();
//		for(int i = 0; i < 50; i++) {
//			sb.append("■");
//			System.out.print(sb.toString() + "\r");
//			System.out.flush();
//			Thread.sleep(200);
//		}
	}

}
