package com.kh.exam3;

public class Variable {

	public static void main(String[] args) {
		boolean bool = true;
		byte b   = 127;
		char c1  = 'a';
		char c2  = 97;
		short s1 = 256;
		int i    = 1024;
		long l   = 4096;
		float f  = 3.14f;
		double d = 3.14;
		//노란색 주의 메시지는 에러가 아니라 그냥 주의일뿐.실행해도 괜찮.
		//불필요한 코드가 작성이 되었다던가 java버전 업데이트되며 예전엔
		//사용했지만 최근 버전에선 사용되지 않는경우에 알려주는 용도. 조심해라! 라는뜻.
		//현재 여기서 뜬 이유는 사용을 안할건데 왜 쓴거냐?라는뜻.bool은 썼으니 노란줄 사라짐.
		
		char c3 = 'b';
		c3 = 'c'; //이러면 최종인 c로 나오는데
		final char c4 = 'b'; 
		//c4 = 'd';
		//final을 붙이면 상수선언됨. 그래서 변경불가
		
		System.out.println(c3);
		
		
		System.out.println(bool);
		System.out.println(b);
		System.out.println(c1);
		System.out.println(c2);
		//97ASCII Code의 데이터값으로 인식을 하는것.a도마찬가지.
		
	    
		String str1 = "Hello";
		String str2 = new String("Java");
		String str3 = "Hello" + "Java";
		String str4 = new String("Hello" + "Java");
		String str5 = "Hello" + 123 + 45 +"Java";
		String str6 = 123 + 45 + "Hello" + "Java";
		String str7 ="" + 123 + 45 + "Hello" + "Java";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str5);
		System.out.println(str6);
		System.out.println(str7);
		

	}

}
