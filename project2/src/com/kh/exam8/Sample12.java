package com.kh.exam8;

import java.util.Random;
import java.util.Scanner;

class CRPGame {
	// 속성 -> 멤버 변수
	
	// 생성자
	
	// 기능 -> 메서드(반환 타입, 매개변수)
}

public class Sample12 {

	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	
	public static void main(String[] args) {
		// 가위바위보 게임 -> 사용자 입력으로 사용자가 가위 또는 바위 또는 보를 입력하는 것만으로 동작.
		
		/*
		 * 1. 사용자 / 컴퓨터가 임의의 가위, 바위, 보를 입력
		 *     - 사용자는 Scanner 를 사용하여 입력 (직접 가위, 바위, 보 중 하나 입력)
		 *     - 컴퓨터는 Random 를 사용하여 입력 (0, 1, 2 중 하나를 임의로 생성)
		 *     - Random 을 통해 생성된 0, 1, 2 의 값은 각각 가위, 바위, 보로 치환하여 동작하게 한다.
		 *
		 * 2. 승부 비교를 위한 조건문 작성
		 *     - 가위 : 바위 -> 바위 승, 가위 : 보 -> 가위 승, 가위 : 가위 -> 무승부
		 *     - 바위 : 바위 -> 무승부,  바위 : 보 -> 보 승,  바위 : 가위 -> 바위 승
		 *     - 보 : 바위 -> 보 승,    보 : 보 -> 무승부,   보 : 가위 -> 가위 승
		 *  
		 * 3. 2번 비교 결과에 따른 승, 패, 무 저장해두어 승률을 출력
		 */
		
		String player;
		String computer = "";
		int[] score = new int[3];	// 0: 승, 1: 패, 2: 무
		String[] sArr = {"가위", "바위", "보"};
		boolean exitFlag = false;
		
		while(true) {
			
			while(true) {
				System.out.print("가위, 바위, 보 중 하나 입력(게임 종료를 원하면 종료 입력) : ");
				player = sc.nextLine();
				if(player.equals("가위") || player.equals("바위") || player.equals("보")
						|| player.equals("종료")) {
					if(player.equals("종료")) {
						exitFlag = true;
					}
					break;
				}
			}
			
			if(exitFlag) {
				break;
			}
			
			computer = sArr[rd.nextInt(3)];
			
			if(player.equals("가위")) {
				if(computer.equals("바위")) {
					System.out.println("컴퓨터 승");
					score[1] += 1;
				} else if(computer.equals("보")) {
					System.out.println("플레이어 승");
					score[0] += 1;
				} else if(computer.equals("가위")) {
					System.out.println("무승부");
					score[2] += 1;
				}
				
			} else if(player.equals("바위")) {
				if(computer.equals("바위")) {
					System.out.println("무승부");
					score[2] += 1;
				} else if(computer.equals("보")) {
					System.out.println("컴퓨터 승");
					score[1] += 1;
				} else if(computer.equals("가위")) {
					System.out.println("플레이어 승");
					score[0] += 1;
				}
				
			} else if(player.equals("보")) {
				if(computer.equals("바위")) {
					System.out.println("플레이어 승");
					score[0] += 1;
				} else if(computer.equals("보")) {
					System.out.println("무승부");
					score[2] += 1;
				} else if(computer.equals("가위")) {
					System.out.println("컴퓨터 승");
					score[1] += 1;
				}
				
			}
			
			System.out.println("현재 플레이어의 스코어는 : " + score[0] + " 승 "
			+ score[1] + " 패 " + score[2] + " 무 입니다.");
		}
	}

}
