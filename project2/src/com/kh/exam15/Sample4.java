package com.kh.exam15;

import java.io.*;

public class Sample4 {

	public static void main(String[] args) {
		// 문자 기반 입출력 + 버퍼 보조 스트림
		try {
			FileWriter fw = new FileWriter("./filewriter.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("파일 쓰기 작업을 진행합니다.");
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("파일 출력 스트림 생성에 문제가 발생하였습니다.");
		}
		
		try {
			FileReader fr = new FileReader("./filewriter.txt");
			BufferedReader br = new BufferedReader(fr);
			
			char[] cArr = new char[8];
			StringBuffer sb = new StringBuffer();
			while(true) {
				int res = br.read(cArr);
				if(res == -1) {
					break;
				}
				sb.append(cArr, 0, res);
			}
			System.out.println(sb);
			br.close();
			fr.close();
		} catch(FileNotFoundException e) {
			System.out.println("읽기 작업을 수행할 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("읽기 작업중 문제가 발생하였습니다.");
		}
		
		
		
		// 바이트 기반 스트림 + 버퍼 보조 스트림
		try {
			File f = new File("./fileoutput.txt");
			FileOutputStream fos = new FileOutputStream(f);
			BufferedOutputStream bos = new BufferedOutputStream(fos); 
			
			byte[] bArr = new byte[] {65, 66, 67, 68, 69};
			
			bos.write(bArr);
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일 출력 스트림에 문제가 발생하였습니다.");
		} catch (IOException e) {
			System.out.println("파일 쓰기 작업에 문제가 발생하였습니다.");
		}
		
		try {
			File f = new File("./fileoutput.txt");
			FileInputStream fis = new FileInputStream(f);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			char[] text = new char[0];
			while(true) {
				int r = bis.read();
				if(r == -1) {
					break;
				}
				char[] temp = new char[text.length + 1];
				System.arraycopy(text, 0, temp, 0, text.length);
				temp[temp.length - 1] = (char)r;
				text = temp;
			}
			System.out.println(text);
			bis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일 입력 스트림에 문제가 발생하였습니다.");
		} catch (IOException e) {
			System.out.println("파일 읽기 작업에 문제가 발생하였습니다.");
		}
	}

}
