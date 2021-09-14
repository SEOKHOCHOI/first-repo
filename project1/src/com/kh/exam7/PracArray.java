package com.kh.exam7;

import java.util.Random;//난수값,임의의 정수,실수 요러한값을 생성시켜주는 거임.
import java.util.Scanner;

public class PracArray {//클래이 이름과 파일명 같아야하고
	//반드시 대문자로 시작해야함.
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	
	public static void ex1() {
		/*
		 * 길이가 10인 정수 배열을 선언하고 1~10 까지의 값을 배열에
		 * 초기화하는 코드를 작성
		 *  */
		int[] iArr = new int[10];
		
		//1.초기화
		int n = 1;
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = n;
			n++;
		}
		//2. 초기화 두번째 방법  (인덱스 번호 활용할수 있는 형태면)
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = i + 1;
		}
		//3. 초기화
		int i = 0;
		while(i < iArr.length) {
			iArr[i] = i + 1;
			i++;
		}
		//결과 확인용 출력 //while에 int i 선언때문에 for에 int지움.
		for( i = 0; i < iArr.length; i++) {
			System.out.println("iArr[" + i + "] -> "+ iArr[i]);
		}
	}
	public static void ex2() {
		/*
		 * 길이가 10인 정수 배열을 선언하고 짝수에 해당하는 값을 배열에 순차적으로
		 * 초기화 하는 코드를 작성
		 */
		int[] iArr = new int[10];
		//1. 초기화(별도의 변수 활용)
		int n = 1;
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = n;
			n +=2;
		}
		//2. 초기화(인덱스 활용)
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = (i + 1) * 2;
		}
		//3.초기화(while 문 사용)
		int i = 0;
		while(i < iArr.length) {
			iArr[i] = (i + 1) * 2;
			i++;
		}
		
		//결과 확인용 출력 (while 아니면 int i = 0;으로 넣어야함)
		for( i = 0; i < iArr.length; i++) {
			System.out.println("iArr[" + i + "] -> "+ iArr[i]);
		}
	}
	public static void ex3() {
		/*
		 * 길이가 20인 정수 배열을 선언하고 홀수에 해당하는 값을 배열에 순차적으로
		 * 초기화하는 코드를 작성
		 * 단, 99 부터 역순으로 초기화값을 저장한다.
		 */
		int[] iArr = new int[20];
		
		//1. 초기화(별도의 변수를 활용)
		int n = 99;
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = n;
			n -= 2;
		}
		//2. 초기화(기존 인덱스 활용)
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = 99 - i*2;
		}
		//3.초기화(배열의 끝 인덱스 부터 역순으로 접근해서 초기화)
		for(int i = iArr.length - 1; i >=0; i--) {
			iArr[i] = 99 - i*2;
		}
		//결과 확인용 출력
		for(int i = 0; i < iArr.length; i++) {
			System.out.println("iArr[" + i + "] -> "+ iArr[i]);
		}
	}
	public static void ex4() {
		/*
		 * 길이가 26인 정수 배열을 선언하고 아스키 문자 영문자(대문자)를 순차적으로
		 * 초기화하는 코드를 작성
		 */
		int[] iArr = new int[26];
		
		//1. 초기화
		for(int i = 0; i <iArr.length; i++) {
			iArr[i] = 65 + i;
		}
		//2. 초기화
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = 'A' + i; //A=65인걸 모를때사용
		}
		//3. 초기화
		for(int i = 0; i < iArr.length / 2; i++) {
			iArr[i * 2] = 'A' + i * 2;
			iArr[i * 2+1] = 'A' + i * 2+1;
		}
		//결과 확인용
		for(int i = 0; i < iArr.length; i++) {
			System.out.println("iArr[" + i + "] -> "+ (char)iArr[i]);
		}
	}
	public static void ex5() {
		/*
		 *  생성할 배열의 크기를 사용자 입력을 이용하여 생성한 후 100 부터 배열의 크기만큼
		 *  초기화를 진행한다
		 */
		int arrSize;
		
		System.out.print("배열의 크기 입력 : ");
		arrSize = sc.nextInt(); sc.nextLine();
		
		int[] iArr = new int[arrSize];
		
		//1.초기화
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = 100 + i;
		}
		
		// 결과 확인용 출력
		for(int i = 0; i < iArr.length; i++) {
			System.out.println("iArr[" + i + "] -> "+ iArr[i]);
		}
	}
	public static void ex6() {
		/*
		 * 생성할 배열의 크기를 사용자 입력을 이용하여 생성한 후 다시 사용자 입력을 이용하여
		 * 사용자가 직접 배열의 크기 만큼 초기화 할 수 있도록 한다.
		 * (생성 할 배열 타입은 문자열로 한다.)
		 */
		int arrSize;
		
		System.out.print("배열의 크기 입력 : ");
		arrSize = sc.nextInt(); sc.nextLine();
		
	    String[] sArr = new String[arrSize];
		
		//1.초기화
		for(int i = 0; i < sArr.length; i++) {
			System.out.print("문자열 : ");
			sArr[i] = sc.nextLine();
		}
		
		// 결과 확인용 출력
		for(int i = 0; i < sArr.length; i++) {
			System.out.println("sArr[" + i + "] -> "+ sArr[i]);
		}
	}
	
	public static void ex7() {
		/*
		 * 2021년 7월에 한정하여 사용자 입력을 통해 일자 데이터를 입력 받고 해당하는 일자가
		 * 어떤 요일인지 알려주는 코드를 배열을 활용하여 작성한다.
		 */
		int day;
		String[] dayArr = new String[] {"수", "목", "금", "토", "일", "월", "화"};
		
		System.out.print("일자 입력 : ");
		day = sc.nextInt(); sc.nextLine();
		
		if(day >= 1 && day <= 31) {
			System.out.println(dayArr[day % 7] + "요일 입니다.");
		}else {
			System.out.println("입력 범위를 벗어났습니다. 1~31 까지만 입력하세요.");
		}
		
		
	}
	public static void ex8() {}
	public static void ex9() {
		/*
		 * 사용자로 부터 교과목 점수를 관리하기 위한 과목 수와 관리 할 과목명 그리고 해당 과목의
		 * 점수 정보를 입력받아 다음과 같은 형식으로 성적 정보가 출력 될 수 있게 프로그램을 작성한다.
		 * 
		 * 예)
		 * 		교과목 수 : 3
		 * 		과목명 1 : 국어
		 * 		과목명 2 : 영어
		 * 		과목명 3 : 수학
		 * 		국어 점수 : 80.5
		 * 		영어 점수 : 75
		 * 		수학 점수 : 90
		 * 
		 * 		성적 정보
		 * 		----------------------------------------
		 * 		국어		영어		수학		총점		평균
		 * 		----------------------------------------
		 * 		80.5	75.0	90.0	245.5	81.83
		 * 		----------------------------------------
		 */
		String[] subjects;
		double[] jumsu;
		int subjectCount;
		
		
		System.out.print("교과목 수 : ");
		subjectCount = sc.nextInt(); sc.nextLine();
		
		subjects = new String[subjectCount];
		jumsu = new double[subjectCount];
		
		for(int i = 0; i < subjects.length; i++) {
			System.out.print("과목명 " + (i + 1) + ": ");
			subjects[i] = sc.nextLine();
		}
		
		for(int i = 0; i < jumsu.length; i++) {
			System.out.print(subjects[i] + "점수 : ");
			jumsu[i] = sc.nextDouble(); sc.nextLine();
		}
		System.out.println("-----------------");
		for(int i = 0; i < subjects.length; i++) {
			System.out.print(subjects[i] + "\t");
		}
		System.out.print("총점\t평균\t\n");
			 System.out.println("-----------------");
			double tot = 0;
			 for(int i = 0; i < jumsu.length; i++) {
				
				System.out.printf("%.1f\t", jumsu[i]);
				tot = tot + jumsu[i];
			}
			 System.out.printf("%.1f\t", tot);
			 System.out.printf("%.1f\t", tot/jumsu.length);
			 System.out.println("---------------");
	}
		public static void ex10() {
			/*
			 * 사용자 입력을 통해 과목명을 입력 받는다.
			 * 과목명을 입력 받을 때 "종료" 라는 문자열이 입력되면 더이상 입력을 받지 않는다.
			 * 모든 입력 데이터는 배열에 저정하며, 새로운 입력이 있을 때마다 배열의 크기를 게속 늘려가며 저장한다.
			 * "종료" 로 더이상 입력 받지 않게 되면, 배열에 저장된 데이터를 모두 출력한다.
			 */
			String[] sArr = new String[0];
			String subject = "";
			
			while(true) {
				System.out.print("과목명 : ");
				subject = sc.nextLine();
			
				if(!subject.equals("종료")) {
				//동적 배열 처리 
					String[] copyArr = new String[sArr.length + 1];
				
					for(int i = 0; i < sArr.length; i++) {
						copyArr[i] = sArr[i];
					}
					sArr = copyArr;
					
					sArr[sArr.length - 1] = subject;
				}else {
					break; //더이상 입력 안받을거고 이 과정들은 계속 무한반복처리
			}
		}
			for(int i = 0; i < sArr.length; i++) {
				System.out.println("sArr[" + i + "]:" + sArr[i]);
			}
	}
		public static void ex11() {
			/*
			 * 1~49 사이의 정수 값을 사용자 입력을 통해 입력 받고 이를 정수 배열에 저장을 한다.
			 * -1이 입력될 때까지 배열의 크기를 +1씩 증가시키면서 계속 사용자 입력 값을 배열에 저장.
			 * -1이 입력되면 사용자 입력을 중지하고 배열에 저장된 모든 값의 합을 출력한다. 
			 */
			int[] iArr = new int[0];
			int num;
			
			while(true) {
				System.out.print("정수 입력(1 ~ 49) : ");
				num = sc.nextInt(); sc.nextLine();
				
				if(num == -1) {
					break;
				} else {
					int[] copyArr = new int[iArr.length + 1];
					
					//기존 배열에 저장되어 있는 데이터를 배열의 길이가 1 늘어난 배열에 복사
					for(int i = 0; i < iArr.length; i++) {
						copyArr[i] = iArr[i];
					}
					
					iArr = copyArr;
					
					iArr[iArr.length - 1] = num;
				}
			}
			int tot = 0;
			for(int i = 0; i < iArr.length; i++) {
				tot += iArr[i];
			}
			System.out.println("사용자가 입력한 정수의 총합 : " + tot);
		}
		public static void ex12() {
			/*
			 * 사용자로 부터 임의의 문자열을 입력 받은 후
			 * a, e, i, o, u 문자가 포함되어 있을 때마다 문자 배열에 저장을 한 후 배열의 길이를
			 * 출력하여 얼마나 포함되어 있는지 확인하게 한다.
			 * 
			 * Tip 1.) 사용자가 입력한 문자열의 문자를 탐색하기 위해 .charAt(index) 메서드를 활용한다.
			 * 
			 * 			String text = "hello";
			 * 			text.charAt(0); // 'h'
			 * 			text.charAt(1); // 'e'
			 * 			text.charAt(2); // 'l'
			 * 
			 * Tip 2.) 문자열의 길이를 알기 위해 .length() 메서드를 사용한다.
			 * 			String text = "hello";
			 * 			text.length(); //5
			 */
			String text;
			char[] cArr = new char[0];
			
			System.out.print("문자열 입력 : ");
			text = sc.nextLine();
			
			for(int i = 0; i < text.length(); i++) {
				switch(text.charAt(i)) {
				case 'a':  case 'e':  case 'i':  case 'o':  case 'u':
						char[] copyCArr = new char[cArr.length + 1];
						System.arraycopy(cArr, 0, copyCArr, 0, cArr.length);
						cArr = copyCArr;
						cArr[cArr.length - 1] = text.charAt(i);
				}
			}
			System.out.println("a, e, i, o, u 문자가 " + cArr.length + "개 있습니다.");
		}
	public static void main(String[] args) {
		//가위바위보 게임 : 사용자 입력으로 사용자가 가위,바위,보 중하나를 입력하는 것만으로 동작.
		//             컴퓨터는 랜덤을 사용하여 저중 하나로 인식할 수 있는 값을 생성. 그담비교해서 이겼따졋따나타냄.
		// 업앤 다운 : 임의의 값을 하나 생성하고 사용자가 일정 범위의 정수값 안에서 정수를 입력하면
		//          미리 생성한 값과 비교를 통해 업 또는 다운으로 힌트를 주어 최정 생성값을 맞추는 게임
		//          (승, 패에 대한 기록을 통해 승률 결과를 알려줄 수 있게도 한다.)
		// 바쁜 직장인들을 위해 미리 선정된 점심 메뉴를 임의로 선택하여 제공하는 프로그램.
		//          1. 미리 선정된 메뉴를 사용하여 임의로 제공.
		//          2. 사용자가 직접 메뉴를 입력하여 입력된 범위 안에서 임의의 메뉴가 선택될 수 있도록 제공.
		
				
		int r = rd.nextInt(46);//이것만을 이용해서도 임의의 값이 생성되고
		//생성된 임의의 값은 r이라는 변수에 저장이 됨! 5넣으면 0부터 4까지 생성해줌.

		
		System.out.println(r);
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		//ex5();
		//ex6();
		//ex7();
		//ex8();
		//ex9();
//		ex10();
		//ex11();
		ex12();
	}

}
