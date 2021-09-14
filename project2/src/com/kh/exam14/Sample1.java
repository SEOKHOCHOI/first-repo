package com.kh.exam14;

import java.util.*;

//class Student {
//	private int score;
//	private String name;
//	
//	public Student(String name, int score) {
//		this.score = score;
//		this.name = name;
//	}
//	public int getScore() {
//		return
//	}
//}

public class Sample1 {

	public static void main(String[] args) {
		//int[] : 정수 데이터를 저장할 배열 공간 지정
		List<Integer> iList = new ArrayList<Integer>();//정수데이터를저장할 리스트공간을만들겠다는뜻
		//<Integer> : 제네릭(Generic)으로 컬렉션에 저장할 객체 타입을 지정하기 위해 사용.
		
		//추가
		//iList.add(10); iList.add(30); iList.add(20);//먼저넣은 순서유지가능
		//System.out.println(iList);
		System.out.println(iList);
		iList.add(10);
		System.out.println(iList);
		iList.add(20);
		System.out.println(iList);
		iList.add(30);
		System.out.println(iList);
		
		iList.add(1, 15);//1은 추가할 인덱스 위치, 15는 추가할 값 으로 지정된거임.
		System.out.println(iList);
		iList.add(3, 25);
		System.out.println(iList);
		
		List<Integer> addList = new ArrayList<Integer>();
		addList.addAll(iList);
		System.out.println(addList);
		
		//set은 수정하는거임!
		iList.set(1, 16);
		System.out.println(iList);
		iList.set(3, 26);
		System.out.println(iList);
		
		//contains는 검색! 이 값이 있냐없냐 판단해줌.
		boolean resBool = iList.contains(20);
		System.out.println(resBool);
		resBool = iList.contains(25);
		System.out.println(resBool);
		
		int resInt = iList.indexOf(20);
		System.out.println(resInt);
		resInt = iList.indexOf(25);
		System.out.println(resInt);
		
		//get은 추출해오는거임.  arr[0]; 와 같은 형태. ,인덱스범위 벗어나면 에러남.
		resInt = iList.get(0);
		System.out.println(resInt);
		
		// 전체 탐색 방법! 배열에 있는 데이터를 0부터 마지막인덱스까지 전체탐색하고나 한다라고 하면
		//반복문을 쓰면 됨! 이것과 같아. 얘는 length가 아니라 size로 써야돼.
		for(int i = 0; i < iList.size(); i++) {
			System.out.println("반복문으로 전체 탐색 ->" + iList.get(i));
		}
		Iterator<Integer> iter = iList.iterator(); //반복자 라고함
		while(iter.hasNext()) {
			System.out.println("반복자를 사용한 전체 탐색->" + iter.next());
		}
		
		for(Integer i : iList) { //iList에 있는 데이터 하나씩하나씩 빼 오는거임. Integer말고 int라고 해도 됨.
			System.out.println("for each 문을 사용한 전체 탐색->" + i);
		}
		//삭제인데 반환이있음. 인덱스가 사용된 리무브임. 
		resInt = iList.remove(0);//젤앞 10이란 데이터가 삭제됨. 근데 이게 반환됨그래서 resInt에 있음.List안에서만 삭제된거임.
		System.out.println(iList + "|" + resInt);
		
		resBool = iList.remove(new Integer(20));//20이라는 정수를 Integer객체로만든거임
		System.out.println(iList + "|" + resBool); //찾아서 지워주는거고 지워지면 true라는 값으로나옴.
		
		resBool = iList.isEmpty();//비어있냐 보는건데 안비어잇으니 false임.
		System.out.println(resBool);
		
		iList.clear(); //반환타입없음 그냥 클리어 하면 됨.
		System.out.println(iList); //걍 싹지우는거. 전체삭제!
	
		resBool = iList.isEmpty();//비어있냐 보는건데 비어잇으니 true임.
		System.out.println(resBool);
		
		//정렬
		iList.add(13); iList.add(15); iList.add(12); iList.add(11);
		System.out.println(iList);
		
		// 순서 뒤집기
		//Collections.reverse(iList);
		//System.out.println(iList);
		
		//오름차순 정렬
		//Collections.sort(iList);
		//System.out.println(iList);

		// (순서 뒤집기) 오름차순 정렬 후 reverse 하면 내림차순 정렬이 됨.
		//Collections.reverse(iList);
		//System.out.println(iList);

		//내림차순 정렬
		Collections.sort(iList, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) {
					return -1;
				}else if(o1 < o2) {
					return 1;
				}
				return 0;
			}
			});
		System.out.println(iList);
		}
  }
