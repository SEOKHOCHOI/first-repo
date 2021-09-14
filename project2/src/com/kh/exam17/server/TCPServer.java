package com.kh.exam17.server;

import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) {
		/*
		 * 1. 서버 포트 선정
		 * 2. 서버용 소켓 생성
		 * 3. 클라이언트 접속 요청 대기
		 * 4. 접속 요청이 오면 클라이언트 소켓 생성
		 * 5. 연결된 클라이언트와의 입출력 스트립 생성(보조스트림까지 생성)
		 * 6. 연결된 스트림으로 통신 진행
		 * 7. 통신 완료 후 종료
		 */
		int port = 30000;
		try {
			System.out.println("서버 소켓을 오픈합니다.");
			ServerSocket sSock = new ServerSocket(port);
			System.out.println("서버 소켓이 열렸습니다. - " + port + " OPEN");
			
			System.out.println("클라이언트 연결 요청을 대기합니다.");
			Socket sock = sSock.accept();
			System.out.println("클라이언트 연결 요청을 승낙합니다. - "
					+ sock.getInetAddress() + ":" + sock.getPort());
			
			System.out.println("통신용 입출력 스트림을 생성합니다.");
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			System.out.println("통신용 입출력 스트림이 생성되었습니다.");
			
			char[] buff = new char[128];
			StringBuffer sb = new StringBuffer();
			boolean isRead = false;
			while(true) {
				while(br.ready()) {
					int len = br.read(buff);
					sb.append(buff, 0, len);
					isRead = true;
				}
				if(isRead) {
					System.out.println(sb.toString());
					sb = new StringBuffer();
					bw.write("데이터 수신을 완료 했습니다.\r\n");	bw.flush();
					isRead = false;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

