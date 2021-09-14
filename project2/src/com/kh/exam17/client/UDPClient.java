package com.kh.exam17.client;

import java.io.*;
import java.net.*;
import java.util.*;

public class UDPClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 연결할 서버의 주소 정보
		byte[] serverIP = new byte[] {127, 0, 0, 1};
		
		// 연결할 서버의 포트 정보
		int serverPort = 30000;
		try {
			//UDP소켓 생성
			DatagramSocket dSock = new DatagramSocket();
			
			while(true) {
				System.out.print("클라이언트> ");
				String send = sc.nextLine();
				
				// UDP 패킷 생성(서버에 전송할 데이터를 담아서 생성)
				DatagramPacket dPacket = new DatagramPacket(send.getBytes(), send.getBytes().length,
						InetAddress.getByAddress(serverIP), serverPort);
				dSock.send(dPacket);
			}
		} catch (SocketException e) {
			
			e.printStackTrace();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
