package com.kh.practice.poly.controller;

import java.util.*;

import com.kh.practice.poly.model.vo.*;

public class LibraryController {

	private List<Member> members = new ArrayList<Member>();
	private RentBook[] bList = new RentBook[5];
	
	{
		members.add(new Member("홍길동", 16, '남', new Date()));
		members.add(new Member("박찬우", 19, '남', new Date()));
		
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}
	
	public void insertMember(Member mem) {
		members.add(mem);
	}
	
	public Member myInfo(String name) {
		int index = members.indexOf(new Member(name));
		return index == -1 ? null : members.get(index);
	}
	
	public void deleteMember(Member member) {
		members.remove(member);
	}
	
	public Book[] selectAll() {
		return bList;
	}
	
	public Book[] searchBook(String keyword) {
		RentBook[] searchBook = null;
		int findCount = 0;
		
		for(RentBook b: bList) {
			if(b.getTitle().contains(keyword)) {
				findCount++;
			}
		}
		
		searchBook = new RentBook[findCount];
		findCount = 0;
		for(RentBook b: bList) {
			if(b.getTitle().contains(keyword)) {
				searchBook[findCount++] = b;
			}
		}
		
		return searchBook;
	}
	
	public int rentBook(int index, String name) {
		Member m = this.myInfo(name);
		int result = RentBook.FAILE;
		if(m != null) {
			result = bList[index].rentBook(m.getAge())[0];
			if(result == RentBook.SUCCESS_COUPON) {
				m.setCouponCount(m.getCouponCount() + 1);
			}
			if(!(result == RentBook.AGE_LIMIT)) {
				m.setRentBook(bList[index]);
			}
		}
		return result;
	}
	
	public int rentBookDays(int index) {
//		int result = bList[index].rentBook(this.mem.getAge())[1];
//		return result;
		return 0;
	}

}
