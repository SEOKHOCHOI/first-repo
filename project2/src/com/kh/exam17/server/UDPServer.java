package com.kh.exam17.server;

import java.io.*;
import java.net.*;

public class UDPServer {

	public static void main(String[] args) {
		/*
		 * 1. 사용할 포트 지정
		 * 2. DatagramSocket 객체 생성
		 * 3. 연결할 장치의 IP 주소를 가지는 InetAddress 객체 생성
		 * 4. 전송할 메시지를 byte[] 배열로 변환
		 * 5. DatagramPacket에 전송할 메시지를 담아 전송
		 * 6. 모든 데이터 전송 완료 후 소켓 닫음
		 */
		int port = 30000;
		try{
			DatagramSocket dSock = new DatagramSocket(port);
			
			byte[] buff = new byte[128];
			while(true) {
				DatagramPacket dPacket = new DatagramPacket(buff, buff.length);
				dSock.receive(dPacket); // 수신대기
				
				String recv = new String(dPacket.getData(), 0, dPacket.getData().length);
				System.out.println(recv); System.out.flush();
			}
		
		}catch(SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
