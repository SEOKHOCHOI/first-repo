package com.kh.exam6;

import java.util.Scanner;

public class PracFOR {
	
	static Scanner sc = new Scanner(System.in);
	
     public static void ex1() {
    	 int num;
    	 System.out.println("정수 입력 : ");
    	 num = sc.nextInt(); sc.nextLine();
    	 
    	 for(int i = 1; i <= num; i++) {
    		 System.out.println(i);
    	 }
     }
     public static void ex2() {
    	 int num;
    	 
    	 for(int i = 1; i <=3; i++) {
    		 System.out.print("정수 입력(1 ~ 99) : ");
    		 num=sc.nextInt(); sc.nextLine();
    	 
    		 if(num >= 1 && num <= 99) {
    			 System.out.println("입력값 " + num + " 확인하였습니다.");
    			 break;
    		 }
    	 }
     }
     public static void ex4() {
    	 int num;
    	 String text = "";
    	 System.out.print("정수 입력 : ");
    	 num = sc.nextInt(); sc.nextLine();
    	 for(int i = 1; i <= num; i++) {
    		 text = text + i + " ";
    	 }
    	 System.out.println(text);
     
     }
         public static void ex6() {
    	 int num;
    	 String text = "";
    	 
    	 System.out.print("정수 입력 : ");
    	 num = sc.nextInt(); sc.nextLine();
    	 
    	 for(int i = 1; i<=num;i++) {
    		 if(i % 3 == 0) {
    			 text = text + i + " ";
    		 }
    	 }
    	 System.out.println(text);
    	 
     }
         
         public static void ex7() {
        	 int num;
        	 String text = "";
        	 
        	 System.out.print("정수 입력 : ");
        	 num = sc.nextInt(); sc.nextLine();
        	 
        	 if(num % 2 == 1) {
        		 num = num -1;
        	 }
        	 // num = num % 2 == 1 ? num -1 : num; 3항연산자 사용시!
        	 for(int i = num; i>= 1; i-=2) {
        		 
        			 text = text + i + " ";
        		 
        	 }
        	 System.out.println(text);
         }
     public static void ex8() {
    	 int num;
    	 int tot = 0; //누적합 저장되는 변수.
    	 
    	 System.out.print("정수 입력 : ");
    	 num = sc.nextInt(); sc.nextLine();
    	 
    	 for(int i = 1; i<=num; i++) {
    		 tot += i;//tot = tot + i; //누적합 구하는 식, 기존tot값 + i값
    	 }
    	 
    	 System.out.println("누적합 : " + tot);
    	 
     }
     
     public static void ex9() {
    	 int num;
    	 int tot = 0;
    	 
    	 System.out.print("정수 입력 : ");
    	 num = sc.nextInt(); sc.nextLine();
    	 
    	 for(int i = 1; i <= num; i++) {
    		 System.out.print(i);
    		 if(i == num) { 
    			 System.out.print(" = ");
    		 }else {
    			 System.out.print(" + ");
    		 }
    		 tot += i; 
    		 
    	 }
    	 System.out.println(tot);
     }
     
     public static void ex10() {
    	 String fileName;
    	 int count;
    	 
    	 System.out.print("파일명 입력 : ");
    	 fileName = sc.nextLine();
    	 
    	 System.out.print("생성 파일수 : ");
    	 count = sc.nextInt(); sc.nextLine();
    	 
    	 if(count == 1) {
   		 System.out.println(fileName + " 생성 완료!");
    	 }else if(count > 1){
    		 System.out.println(fileName + " 생성 완료!");
    		 for(int i = 2; i <= count; i++) {
    			 System.out.println(fileName + "[" + i + "]" + "생성 완료!" );
   			 
    		 }
    	 }
    	 
  }
     
     public static void ex11() {
    	 int num1, num2, res;
    	 double res1;
    	 char op;
    	 
    	 
    	 for(;;) {
    		 for(;;) {
    		 System.out.print("숫자 입력 1 : ");
    		 if(sc.hasNextInt()) {
    			 num1 = sc.nextInt(); sc.nextLine();
    			 break;
    		 } 	else {
    		 		System.out.println("숫자만 입력하세요.");
    		 		sc.nextLine(); //입력 버퍼에 저장된 값을 지우기위해 사용.
    		 	}
    		 }
    		 System.out.print("연산자 입력 : ");
    		 op = sc.nextLine().charAt(0);
    		 
    		 if(op == 'z') {
    			 break;
    		 }
    		 System.out.print("숫자 입력 2 : ");
    		 num2 = sc.nextInt(); sc.nextLine();
    		 
    		 switch(op) {
    		 case '+':
    		 	res = num1 + num2;
    		 	System.out.printf("%d + %d = %d\n", num1, num2, res);
    		 case '-': 
    		 	res = num1 - num2;
    		 	System.out.printf("%d - %d = %d\n", num1, num2, res);
    		 case '*': 
    		 	res = num1 * num2;
    		 	System.out.printf("%d * %d = %d\n", num1, num2, res);
     		 case '/': 
     		 	res1 = (double)num1 / num2; //실수와 정수에 대한 계산.
     		 	System.out.printf("%d / %d = %.1f\n", num1, num2, res1);
    		 }
    	 }
     }
     
     public static void main(String[] args) {
    	 //ex1();
    	 //ex2();
    	 //ex4();
    	 //ex6();
    	 //ex7();
    	 //ex8();
    	 //ex9();
    	 //ex10();
    	 ex11();
     }
     

}
