package com.kh.exam17;

import java.net.*;
import java.util.Arrays;

public class Sample1 {

	public static void main(String[] args) throws UnknownHostException{
			
			byte[] addr = new byte[] {127, 0, 0, 1};
			InetAddress inet1 = InetAddress.getByAddress(addr);
			System.out.println(Arrays.toString(inet1.getAddress()));

			//LocalHost 장치의 주소(Loopback) 정보 가져오기
			InetAddress inet2 = InetAddress.getByName("localhost");
			System.out.println(Arrays.toString(inet2.getAddress()));
			
			//도메인 주소의 IP 주소 정보 가져오기
			//byte : 부호가 있는 자료형 0~127,범위 넘어가면 -1~-128 으로 표현.
			//그래서 밑에처럼 변환 시킨거.
			InetAddress inet3 = InetAddress.getByName("naver.com");
			String naverIP = "";
			for(byte b : inet3.getAddress()) {
				naverIP += ((int)b & 255) + ".";
			}
			
			naverIP = naverIP.substring(0, naverIP.length() - 1);
			System.out.println(naverIP);
			/*
			 * 125.209.222.141
			 * 223.130.195.95
			 * 223.130.195.200
			 * 125.209.222.142
			 * 네이버 IP들임.
			 */
			
			//getHostAddress() 써주면 귀찮게 변환할필요없음
			//이거 자체가 IP주소로 반환해줌.
			//주의할건 문자열로 반환함.
			System.out.println(inet3.getHostAddress());
	
			//LocalHost 장치의 주소 정보 가져오기
			InetAddress inet4 = InetAddress.getLocalHost();
			System.out.println(inet4.getHostAddress());
	}

}
