package com.kh.exam17.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		/*
		 * 1. 연결할 서버의 IP / Port 를 설정
		 * 2. 설정된 주소 정보로 소켓 객체 생성(연결 요청)
		 * 3. 서버와의 입출력 스트립 생성(보조스트림까지 생성)
		 * 4. 연결된 스트림으로 통신 진행
		 * 5. 통신 완료 후 종료
		 */
		Scanner sc = new Scanner(System.in);
		int serverPort = 30000;	// 연결할 서버의 Port
		String serverIP;	// 연결할 서버의 IP
		
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			Socket sock = new Socket(serverIP, serverPort);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			String send = "";
			char[] buff = new char[128];
			StringBuffer sb = new StringBuffer();
			while(true) {
				System.out.print("클라이언트가 전송 한 메시지> ");
				send = sc.nextLine();
				bw.write(send);	bw.flush();
				
				while(br.ready()) {
					int len = br.read(buff);
					sb.append(buff, 0, len);
				}
				System.out.print(sb.toString());
				sb = new StringBuffer();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
