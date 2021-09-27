package com.kh.exam15;

import java.io.*;

public class Sample3 {

	public static void main(String[] args) {
		// 문자 기반 파일 입출력
		// 문자가 저장된 텍스트 파일에 대한 읽기 쓰기 작업에 적합
		
		try {
			FileWriter fw = new FileWriter("./filewriter.txt");
			fw.write("파일 쓰기 작업을 진행합니다.");
			fw.close();
		} catch (IOException e) {
			System.out.println("파일 출력 스트림 생성에 문제가 발생하였습니다.");
		}
		
		try {
			FileReader fr = new FileReader("./filewriter.txt");
			
			char[] cArr = new char[8];
			StringBuffer sb = new StringBuffer();
			while(true) {
				int res = fr.read(cArr);
				if(res == -1) {
					break;
				}
				sb.append(cArr, 0, res);
			}
			System.out.println(sb);
			fr.close();
		} catch(FileNotFoundException e) {
			System.out.println("읽기 작업을 수행할 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("읽기 작업중 문제가 발생하였습니다.");
		}
	}

}
