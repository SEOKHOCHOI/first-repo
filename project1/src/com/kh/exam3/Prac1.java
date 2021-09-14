package com.kh.exam3;

import java.util.Scanner;

public class Prac1 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/*
		 * Scanner 로 사용자 입력을 받아 다음의 결과가 출력될 수 있도록 한다.
		 * 
		 * 이름을 입력하세요. : 홍길동
		 * 성별을 입력하세요.(남/여) :
		 * 나이를 입력하세요. : 32
		 * 키를 입력하세요.(cm) : 175.4
		 * 
		 * 홍길동님의 나이는 32세 입니다.
		 * 키는 약 175 cm 이고 성별은 남자 입니다.
		 * */
		
		//Scanner in = new Scanner(System.in);
		//int A = in.nextInt();
		//double B = in.nextDouble();
		
		//System.out.println("홍길동님의 나이는 "+A+"세 입니다.");
		//System.out.printf("키는 약 %.1fcm 이고 성별은 남자 입니다.\n",B);
		
		//System.out.printf("안녕 %d야\n",A);
		//System.out.printf("죽어 %f야",B);
		
		// \n : 한 줄 생성( \r후에 \n해도 글자 냅두고 커서만 )
		// \r : 해당 줄의 처음으로 이동(글자 냅두고 커서만)

		String name;
		char gender;
		int age;  double tall;
		
		System.out.print("이름을 입력하세요. : ");
		name = sc.next(); sc.nextLine();
		
		System.out.print("성별을 입력하세요.(남/여) : ");
		gender = sc.next().charAt(0); sc.nextLine();
		
		System.out.print("나이를 입력하세요. : ");
		age = sc.nextInt(); sc.nextLine();
		
		System.out.print("키를 입력하세요.(cm) : ");
		tall = sc.nextDouble(); 
		
		System.out.printf("%s님의 나이는 %d세 입니다.\n", name, age);
		System.out.printf("키는 약 %.0f cm 이고 성별은 %c자 입니다.\n", tall, gender);
	
		//String msg = "%s님의 나이는 %d세 입니다.\n키는 약 %.0f cm 이고 성별은 %c자 입니다.\n";
		//System.out.printf(msg, name, age,tall,gender); 이런식으로 해도 돼.
	
	}

}
