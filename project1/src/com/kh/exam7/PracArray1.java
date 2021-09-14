package com.kh.exam7;

import java.util.Arrays;

public class PracArray1 {

	public static void ex1() {
		/*
		 * 다음의 정수 배열이 있다.(고정된)
		 * 37,92,58,46,94,29,25,58
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도로 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.(정적배열, 동적배열)
		 */
		int[] arr = new int[] {37,92,58,46,94,29,25,58};
		int[] arrEven = new int[0];
		int[] arrOdd = new int[0];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				//짝수 -> 짝수를 저장하기 위한 배열의 동적배열 작업
				int[] arrEvencopy = new int[arrEven.length + 1];
				System.arraycopy(arrEven, 0, arrEvencopy, 0, arrEven.length);
				arrEven = arrEvencopy;//배열의 크기가 하나늘어난 배열이 arrEven에 저장하게 됨.그럼하나늘어난배열로 사용가능.
				arrEven[arrEven.length - 1] = arr[i];//배열에 마지막 인덱스에 짝수라고 판정된 값을 저장해줌.
			}else {
				//홀수 -> 홀수를 저장하기 위한 배열의 동적배열 작업
				int[] arrOddCopy = new int[arrOdd.length + 1];
				System.arraycopy(arrOdd, 0, arrOddCopy, 0, arrOdd.length);
				arrOdd = arrOddCopy;
				arrOdd[arrOdd.length - 1] = arr[i];
			}
		}
		System.out.println(Arrays.toString(arrEven));
		System.out.println(Arrays.toString(arrOdd));
	}
	public static void ex2() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 37,92,58,46,94,29,25,58
		 * 위 배열에서 가장 큰값과 가장 작은 값만을 분리하여 별도의 배열에 저장하도록 한다.
		 */
		int[] arr = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		int[] minMax = new int[2];//minMax 작  큰   (0번과 1번에)
		minMax[0] = arr[0];
		minMax[1] = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			//작은 값만 찾아서 저장
			if(arr[i] < minMax[0]) {
				minMax[0] = arr[i];
			}
			//큰 값만 찾아서 저장
			if(arr[i] > minMax[1]) {
				minMax[1] = arr[i];
			}
		}
		System.out.println(Arrays.toString(minMax));
	}
	public static void ex3() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 37,92,58,46,94,29,25,58
		 * 위 배열에서 중복된 값을 찾아 중복이 없는 새로운 배열을 만든다.
		 */
		int[] arr = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		int[] arr2 = new int[0];
		boolean isDuplicate = false;
		
		for(int i = 0; i < arr.length; i++) {
			//중복된 데이터가 있는지 검사.
			for(int j = 0; j < arr2.length; j++) {
				if(arr[i] == arr2[j]) {
					isDuplicate = true;
					break;
				}
			}
			if(!isDuplicate) {
				
			//중복된 데이터가 저장되어 있지 않은 경우.
			//배열의 크기를 늘리고 늘어난 배열에 데이터 자장.
				int[] arr2Copy = new int[arr2.length + 1];
				System.arraycopy(arr2, 0, arr2Copy, 0, arr2.length);
				arr2 = arr2Copy;
				arr2[arr2.length - 1] = arr[i];
			}
			isDuplicate = false;
		}
		System.out.println(Arrays.toString(arr2));
	}
	
	public static void ex4() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 	37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.(정적배열, 동적배열)
		 */
		int[] arr = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		int[][] arrEvenOdd = new int[2][8];
		
		// arrEvenOdd[0] : 짝수 저장
		// arrEvenOdd[1] : 홀수 저장
		int idx1 = 0;
		int idx2 = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				//짝수
				arrEvenOdd[0][idx1] = arr[i];
				idx1++;
			}else {
				//홀수
				arrEvenOdd[1][idx2] = arr[i];
				idx2++;
			}
		}
		System.out.println(Arrays.deepToString(arrEvenOdd));
	}
	
	public static void ex5() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.(정적배열, 동적배열)
		 */
		int[] arr = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		int[][] arrEvenOdd = new int[2][];
		
		int[] arrEven = new int[0];
		int[] arrOdd = new int[0];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				//짝수 -> 짝수를 저장하기 위한 배열의 동적배열 작업
				int[] arrEvencopy = new int[arrEven.length + 1];
				System.arraycopy(arrEven, 0, arrEvencopy, 0, arrEven.length);
				arrEven = arrEvencopy;//배열의 크기가 하나늘어난 배열이 arrEven에 저장하게 됨.그럼하나늘어난배열로 사용가능.
				arrEven[arrEven.length - 1] = arr[i];//배열에 마지막 인덱스에 짝수라고 판정된 값을 저장해줌.
			}else {
				//홀수 -> 홀수를 저장하기 위한 배열의 동적배열 작업
				int[] arrOddCopy = new int[arrOdd.length + 1];
				System.arraycopy(arrOdd, 0, arrOddCopy, 0, arrOdd.length);
				arrOdd = arrOddCopy;
				arrOdd[arrOdd.length - 1] = arr[i];
			}
		}
	
			arrEvenOdd[0] = arrEven;
			arrEvenOdd[1] = arrOdd;
		
		System.out.println(Arrays.deepToString(arrEvenOdd));
	
	}
	
	public static void ex6() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.(정적배열, 동적배열)
		 */
		int[] arr = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		int[][] arrEvenOdd = new int[2][0];
		System.out.println(arrEvenOdd[0]);
		
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				//짝수 -> 짝수를 저장하기 위한 배열의 동적배열 작업
				int[] arrEvencopy = new int[arrEvenOdd[0].length + 1];
				System.arraycopy(arrEvenOdd[0], 0, arrEvencopy, 0, arrEvenOdd[0].length);
				arrEvenOdd[0] = arrEvencopy;//배열의 크기가 하나늘어난 배열이 arrEven에 저장하게 됨.그럼하나늘어난배열로 사용가능.
				arrEvenOdd[0][arrEvenOdd[0].length - 1] = arr[i];//배열에 마지막 인덱스에 짝수라고 판정된 값을 저장해줌.
			}else {
				System.out.println(arrEvenOdd[1].length);
				//홀수 -> 홀수를 저장하기 위한 배열의 동적배열 작업
				int[] arrOddcopy = new int[arrEvenOdd[1].length + 1];
				System.arraycopy(arrEvenOdd[1], 0, arrOddcopy, 0, arrEvenOdd[1].length);
				arrEvenOdd[1] = arrOddcopy;//배열의 크기가 하나늘어난 배열이 arrEven에 저장하게 됨.그럼하나늘어난배열로 사용가능.
				arrEvenOdd[1][arrEvenOdd[1].length - 1] = arr[i];
			}
		}
	
			
		
		System.out.println(Arrays.deepToString(arrEvenOdd));
	
	}
	public static void ex7() {
		//아침, 점심, 저녁, 야식, 안주 메뉴를 랜덤으로 선택하여 제공하는 프로그램.
	    /*
	     * 1. 아침 메뉴 선택
	     * 2. 점심 메뉴 선택
	     * 3. 저녁 메뉴 선택
	     * 4. 야식 메뉴 선택
	     * 5. 안주 메뉴 선택
	     * 6. 메뉴 추가
	     * 입력 : 2
	     * 오늘의 점심 메뉴는 "돈까스" 입니다.
	     */
	
	}
	
	
	
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
		//ex4();
//		ex5();
		//ex6();
		ex7();
	}

}
