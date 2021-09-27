package com.kh.exam15;

import java.io.*;
import java.util.*;

class Student {
	private String name;
	private List<Subject> subjects;
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(String name, List<Subject> subjects) {
		this.name = name;
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public void setSubjet(String subjectName, int subjectScore) {
		if(subjects == null) {
			subjects = new ArrayList<Subject>();
		}
		this.subjects.add(new Subject(subjectName, subjectScore));
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", subjects=" + subjects + "]";
	}
}

class Subject {
	private String name;
	private int score;
	
	public Subject(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + ", score=" + score + "]";
	}
	
}

public class Sample5 {
	
	public static String readFile(String filename) {
		StringBuffer sb = new StringBuffer();
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			char[] cArr = new char[8];
			while(true) {
				int res = br.read(cArr);
				if(res == -1) {
					break;
				}
				sb.append(cArr, 0, res);
			}
			
			br.close();
			fr.close();
		} catch(FileNotFoundException e) {
			System.out.println("읽기 작업을 수행할 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("읽기 작업중 문제가 발생하였습니다.");
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String newLine = osName.contains("Win") ? "\r\n" : "\n";
		
		// 문자 기반 스트림을 사용하여 파일읽기
		// file1.txt 파일을 읽고 문자열 배열에 저장하도록 한다.
		String[] strSubjects = readFile("./file1.txt").split(",");
		strSubjects[strSubjects.length - 1] =
				strSubjects[strSubjects.length - 1].replace(newLine, "");
		System.out.println(Arrays.toString(strSubjects));
		
		// file2.txt 파일을 읽고 Subject 객체 또는 객체배열을 만들어 저장하도록 한다.
		String[] strTemp = readFile("./file2.txt").split(newLine);
		List<Subject> subjects = new ArrayList<Subject>();
		for(String s: strTemp) {
			String[] strData = s.split(",");
			subjects.add(new Subject(strData[0], Integer.parseInt(strData[1])));
		}
		System.out.println(subjects);
		
		
		// file3.txt 파일을 읽고 Student 객체를 만들어 저장하도록 한다.
		// Student 객체 안에는 Subject 객체 배열이 있다.
		strTemp = readFile("./file3.txt").split(newLine);
		String[] strColumn = strTemp[0].split(",");
		List<Student> students = new ArrayList<Student>();
		for(int i = 1; i < strTemp.length; i++) {
			String[] data = strTemp[i].split(",");
			Student std = new Student(data[0]);
			for(int j = 1; j < data.length; j++) {
				std.setSubjet(strColumn[j], Integer.parseInt(data[j]));
			}

			students.add(std);
		}
		System.out.println(students);
	}

}
