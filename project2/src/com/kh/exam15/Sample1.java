package com.kh.exam15;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class Sample1 {

	public static void main(String[] args) {
		/*
		 * 상대 경로 : ./ -> 현재 위치(프로그램이 동작하는 위치)를 의미한다.
		 *          ../ -> 현재 위치의 상위 디렉터리를 의미
		 *          ./, ../ 사용하지 않고 바로 디렉터리명/파일명을 사용하는 경우 -> ./ 생략한것
		 * 절대 경로 : Windows -> C:\ 부터 모든 경로를 작성하는 것
		 *          MacOS/Linux -> / 부터 모든 경로를 작성하는 것
		 */
		File f = new File("config/");
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		f = new File("config/conf.cnf");
		
		try {
			f.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		f = new File("./");
		String[] fList = f.list();
		System.out.println(Arrays.toString(fList));
		
		String[] sList = f.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.contains(".");
			}
		});
		System.out.println(Arrays.toString(sList));
		
	}
	
}
