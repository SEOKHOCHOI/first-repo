package com.kh.exam8;

import java.util.Random;
import java.util.Scanner;

class CRPGame2 {
	// 플레이어가 입력한 값을 처리하기 위한 메서드
	public void player() {}

	// 컴퓨터가 임의로 값을 생성하기 위한 메서드
	public void computer() {}

	// 플레이어와 컴퓨터간의 대결을 통해 승패무를 구하는 메서드
	public void vs() {}

	// 게임을 종료할지 말지 구분하기 위한 메서드
	public void isExist() {}

	// 게임의 결과를 확인하기 위한 메서드
	public void score() {}
}

public class Sample13 {

	static Random rd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 가위바위보 게임을 클래스로 구현하여 동작시키기.
		 */
		CRPGame2 g = new CRPGame2();
		
		while(g.isExist()) {
			g.player(sc.nextLine());
			g.computer();
			g.vs();
			g.score();
		}
	}

}
