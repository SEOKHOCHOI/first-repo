package com.kh.exam7;

public class ArrayData {

	public static void sample1() {
		int[] iArr = new int[5];//배열 생성 힙(값),스택(주소)저장됨.
		
		System.out.println(iArr[0]);//0번 위치에 접근(출력해라)
		System.out.println(iArr[1]);
		System.out.println(iArr[2]);
		System.out.println(iArr[3]);
		System.out.println(iArr[4]);
		
	}
	public static void sample2() {
		int[] iArr = new int[5];
		//배열은 length에 소괄호 금지! 
		for(int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
	}
	//.length() <<메서드 라고함.  문자열 길이 구할때 사용함.
	//.length   <<속성 이라고함.  얘는 배열.
	
	public static void sample3() {
		//선언과 동시에 초기화
		//<첫번째> int[] iArr = {1, 2, 3, 4, 5};   얘는 타이핑 수가 적음
		int[] iArr = new int[] {1, 2, 3, 4, 5};//두번째! 얘는직관적
	
		for(int i = 0; i < iArr.length; i++) {
		System.out.println(iArr[i]);
		}
	}
	public static void sample4() {
		//선언 후 초기화
		int[] iArr = new int[5];
		//반복문을 사용하여 초기화함.
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = i + 1;
		}
		//결과 출력
		for(int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
	}
	public static void sample5() {
		boolean[] boolArr = new boolean[] {true, false, true, true};
		byte[] bArr = {1, 2, 3, 4};
		char[] cArr = {'a', 'b', 'c', 'd'};
		double[] dArr = {1.0, 2.0, 3.0, 4.0};
		String[] sArr = {"hello", "hi", "안녕", "하세요"};
		
		System.out.println(boolArr);
		//결과 출력
		for(int i = 0; i < boolArr.length; i++) {
			System.out.print(i + ":" + boolArr[i] + " ");
			
		}
		for(int i = 0; i < bArr.length; i++) {
			System.out.print(i + ":" + bArr[i] + " ");
			
			System.out.println();
		}
		for(int i = 0; i < cArr.length; i++) {
			System.out.print(i + ":" + cArr[i] + " ");
			
		}
		for(int i = 0; i < dArr.length; i++) {
			System.out.print(i + ":" + dArr[i] + " ");
			
		}
		for(int i = 0; i < sArr.length; i++) {
			System.out.print(i + ":" + sArr[i] + " ");
			
		}
	}
	public static void sample6() {
		int x1 = 10;
		int x2 = x1;
		
		System.out.println("x1:" + x1 + "|x2:" + x2);
		
		x2 = 15; 
		System.out.println("x1:" + x1 + "|x2:" + x2);
		
		//배열 복사
		int[] iArr1 = new int[] {1, 2, 3, 4};
		int[] iArr2 = iArr1; //1이 가진 주소를 2에 저장하는것.(배열의 값 자체를 저장한게 아님)
		//그래서 나중에 2번값을 변경하면 1도 변경한것처럼 보이는것
		
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		iArr2[2] = 45;
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1dd[" + i + "]:" + iArr1[i] + "|iArr2[" + i+ "]:" + iArr2[i]);
		}
	}
	public static void sample7() {
		// 깊은 배열 복사 : 배열의 실제 데이터를 복사
		int[] iArr1 = new int[] {1, 2, 3, 4};
		int[] iArr2 = new int[iArr1.length];
		
		for(int i = 0; i < iArr1.length; i++) {
			iArr2[i] = iArr1[i]; //주소복사가 아니라 값들을 다 복사한것.
		}
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1dd[" + i + "]:" + iArr1[i] + "|iArr2[" + i+ "]:" + iArr2[i]);
		}
		iArr2[2] = 45;
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1dd[" + i + "]:" + iArr1[i] + "|iArr2[" + i+ "]:" + iArr2[i]);
		}
		
		
	}
		public static void sample8() {
			int[] iArr1 = new int[] {1, 2, 3, 4};
			int[] iArr2 = new int[iArr1.length + 1];
			
			for(int i = 0; i < iArr1.length; i++) {
				iArr2[i] = iArr1[i];
				System.out.println("늘리기전 "+"iArr1[" + i+ "]:" + iArr1[i]);
			}
			iArr1 = iArr2; //이미 늘어난걸 2가 참조 이걸 1도 참조
			
			iArr1[iArr1.length - 1] = 5; //마지막 번호에 값을 새롭게 추가로 넣어줌
			for(int i = 0; i < iArr1.length; i++) {
				System.out.println("늘린후 "+"iArr1[" + i+ "]:" + iArr1[i]);
			}
		}
		public static void sample9() {
			int[] iArr1 = new int[] {1, 2, 3, 4};
			int[] iArr2 = new int[iArr1.length + 1];
			
			System.out.println("----배열의 크기를 늘리기 전----");
			for(int i = 0; i < iArr1.length; i++) {
				System.out.println("iArr1[" + i + "]:" + iArr1[i]);
			}
			//                원본,  원본시작위치,복사본, 복사본시작위치, 복사할데이터길이-1 //0번부터 iArr1길이만큼 복사하겠다는뜻.
			System.arraycopy(iArr1, 0,       iArr2, 0,        iArr1.length);
			//for(int i = 0; i < iArr1.length; i++){
			//    iArr2[i] = iArr1[i];
			//}
			
			iArr1 = iArr2;
			
			iArr1[iArr1.length - 1] = 5;
			
			System.out.println("----배열의 크기를 늘린 후----");
			for(int i = 0; i < iArr1.length; i++) {
				System.out.println("iArr1[" + i + "]:" + iArr1[i]);
			}
		}
	
	public static void main(String[] args) {
//		sample1();
//		sample2();
		//sample3();
		//sample4();
		//sample5();
		//sample6();
//		sample7();
		//sample8();
		sample9();
		
	}
}
