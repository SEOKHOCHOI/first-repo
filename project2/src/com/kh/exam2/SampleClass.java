package com.kh.exam2;

//import com.kh.exam1.Person;
//다른 패키지의 default 접근제한자를 사용하는클래스에 접근 안됨.

public class SampleClass {

	public static void main(String[] args) {
		//Person p = new Person(); //다른 패키지라 오류남
	}
//public을 Person쪽에 넣으면 에러가 사라질거임.
}

//같은 패키지 안에 있으면 import 안쓰고 Person이라고 지정하면
//JVM이 알아서 쳐리해서 판단해줌.
//다른 패키지에 있을때에는 public은 당연히 써줘야하고
//import도 무조건 써줘야함.

//import 안해주면 com.kh.exam1.Person p = new com.kh.exam1.Person();
//이렇게 다 적어줘야함.  이름이 같은 클래스가 속한 두 패키지를 import 할대는 클래스앞에 패키지명을
//붙여서 구분해주긴함.  아닌경우는 그냥 import위에 해주고
//밑에는 com.kh~~다 안쓰고 Person p = new Person(); 해주면됨.
//import java.util.*; 해주면 java.util이라는 패키지안에 존재하는 모든클래스 다 import 가능
//그니까 import java.util.Scanner; 이런거 여러개 해줄필요 없이 * 한방이면 다 된다는거임.
//지정된 패키지에 포함된 클래스는 import 가능하지만 다른 하위클래스들까지는 불가능.


//클래스안에 정의가된 변수,메서드는 다 멤버변수 
// 메서드 안에 정의된건 지역변수.