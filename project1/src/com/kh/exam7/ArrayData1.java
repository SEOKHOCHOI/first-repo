package com.kh.exam7;

import java.util.Arrays;

public class ArrayData1 {

	public static void sample1() {
		
	/*
	 * 2차 배열
	 * 	배열안에 요소가 배열로 구성되어 있는것을 말한다. (표, 테이블과 같은 구조)
	 */
		int[][] arr = new int[3][4];//3이랑4로 정해진 크기일떄 세로 가로임.
		
		for(int i = 0; i < arr.length; i++) {
			//2배열쓰면 반복문 2번 사용됨
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = i + j;
			}
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[0][0]);
		System.out.println(arr[0][1]);
		System.out.println(arr[0][2]);
		System.out.println(arr[0][3]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}
	
	public static void sample2() {
		//int[][] arr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] arr = {{1,2},{4,5,6,12},{7,8,9}}; //new int 안써도 됨
	                   //그리고 가변길이.
		
		//System.out.println(Arrays.toString(arr)); 이러면 주소,참조값뿐이 안나옴 값을 보고싶으면 바꿔야함 밑처럼
		System.out.println(Arrays.deepToString(arr));//deepToString 적어주면돼.2차배열 출력!
		//물론반복문으로 써줘도 됨.for(int i = 0; i < arr.length; i++) {
		//System.out.println(Arrays.toString(arr));}
		
	}
	public static void sample3() {
		//2차 배열에 대한 복사.
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		//int[][] arrCopy = arr;//참조주소만 복사하는거라 똑같은 값나옴.깊은복사 써야함. 
		int[][] arrCopy = new int[arr.length][];
		
		for(int i = 0; i < arr.length; i++) {
			arrCopy[i] = arr[i].clone();
		}
		
		arr[0][0] = 10;
		
		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepToString(arrCopy));
	}
	public static void sample4() {
		//2차 배열 안의 배열 크기를 늘리기.
		int[][] arr =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		int[] arrCopy = new int[arr[1].length + 1];//{4,5,6}쪽의 크기를 더 늘리고 싶은거임.
		System.arraycopy(arr[1], 0, arrCopy, 0, arr[1].length);
		arr[1] = arrCopy;
		arr[1][arr[1].length - 1] = 66;
		
		System.out.println(Arrays.deepToString(arr));
	}
	public static void sample5() {
		//2차 배열의 크기를 늘리기.{{},{}}에서 안쪽 {}를 늘린단말.
		int[][] arr =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		int[][] arrCopy = new int[arr.length + 1][];//2차배열 전체 크기에대해 크기를 더 늘리고 싶은거임.
		for(int i = 0; i < arr.length; i++) {
			
			arrCopy[i] = arr[i].clone();
		}
		arr = arrCopy;
		arr[arr.length - 1] = new int[3];
		
	
		System.out.println(Arrays.deepToString(arr));
	}
	public static void main(String[] args) {
	
//		sample1();
//		sample2();
//		sample3();
//		sample4();
//		sample5();
	}
}
	
