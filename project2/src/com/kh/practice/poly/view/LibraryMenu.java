package com.kh.practice.poly.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.kh.practice.poly.controller.LibraryController;
import com.kh.practice.poly.model.vo.Book;
import com.kh.practice.poly.model.vo.Member;
import com.kh.practice.poly.model.vo.RentBook;

public class LibraryMenu {

	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		String txtMenu = "==== 메뉴 ====\n";
		txtMenu += "1. 회원 메뉴\n";
		txtMenu += "2. 도서 전체 조회\n";
		txtMenu += "3. 도서 검색\n";
		txtMenu += "4. 도서 대여하기\n";
		txtMenu += "9. 프로그램 종료하기\n";
		txtMenu += "메뉴 번호 : ";
		
		while(true) {
			System.out.print(txtMenu);
			int numMenu = sc.nextInt();	sc.nextLine();
			if(numMenu == 9) {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			switch(numMenu) {
				case 1:
					this.memberMenu();	break;
				case 2:
					this.selectAll();	break;
				case 3:
					this.searchBook();	break;
				case 4:
					this.rentBook();	break;
			}
		}
		
	}
	
	public void memberMenu() {
		String txtMenu = "==== 회원 메뉴 ====\n";
		txtMenu += "1. 회원 가입\n";
		txtMenu += "2. 회원 검색\n";
		txtMenu += "3. 회원 수정\n";
		txtMenu += "4. 회원 삭제\n";
		txtMenu += "5. 대여 도서 확인\n";
		txtMenu += "6. 미반납 도서 확인\n";  // 대여기간이 종료 되었음에도 아직 반납이 안된 도서에 대한 목록 출력
		txtMenu += "9. 메인 메뉴로 돌아가기\n";
		txtMenu += "메뉴 번호 : ";
		System.out.print(txtMenu);
		
		int numMenu = sc.nextInt();	sc.nextLine();
		
		if(numMenu == 9) {
			System.out.println("메인 메뉴로 돌아갑니다.");
			return;
		}
		
		switch(numMenu) {
			case 1:
				this.joinMember();	break;
			case 2:
				this.searchMember();	break;
			case 3:
				this.updateMember();	break;
			case 4:
				this.deleteMember();	break;
			case 5:
				this.rentBookList();	break;
		}
	}
	
	public void rentBookList() {
		System.out.println("대여 도서 정보를 확인합니다. 메시지에 맞추어 정보를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		Member m = lc.myInfo(name);
		if(m != null) {
			System.out.println(name + "님의 대여 목록 입니다.");
			if(m.getRentBook() != null) {
				for(RentBook b: m.getRentBook()) {
					System.out.println("도서명 : " + b.getTitle());
					System.out.println("작가 : " + b.getAuthor());
					System.out.println("출판사 : " + b.getPublisher());
				}
			}
		} else {
			System.out.println(name + "회원 정보가 존재하지 않습니다.");
		}
	}
	
	public void joinMember() {
		System.out.println("회원 가입을 진행합니다. 메시지에 맞추어 정보를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();	sc.nextLine();
		
		System.out.print("성별 : ");
		char gender = sc.nextLine().charAt(0);
		
		Member mem = new Member(name, age, gender, new Date());
		lc.insertMember(mem);
		
		System.out.println("가입이 완료되었습니다.");
	}
	
	public void searchMember() {
		System.out.println("회원 정보를 검색합니다. 메시지에 맞추어 정보를 입력하세요.");
		System.out.print("회원 이름 : ");
		String name = sc.nextLine();
		
		Member m = lc.myInfo(name);
		if(m != null) {
			System.out.println("회원 이름 : " + m.getName());
			System.out.println("회원 나이 : " + m.getAge());
			System.out.println("가입일자 : " + m.getJoinDate());
			System.out.println("쿠폰 수 : " + m.getCouponCount());
		} else {
			System.out.println("해당 회원 정보를 찾을 수 없습니다.");
		}
	}
	
	public void updateMember() {
		System.out.println("회원 정보를 수정합니다. 메시지에 맞추어 정보를 입력하세요.");
		System.out.print("회원 입력 : ");
		String name = sc.nextLine();
		
		Member m = lc.myInfo(name);
		if(m != null) {
			System.out.print("나이 : ");
			int age = sc.nextInt();	sc.nextLine();
			
			System.out.print("성별 : ");
			char gender = sc.nextLine().charAt(0);
			
			m.setAge(age);	m.setGender(gender);
			
			System.out.println("회원 정보 수정이 완료되었습니다.");
		} else {
			System.out.println("수정할 회원 정보가 없습니다.");
		}
	}
	
	public void deleteMember() {
		System.out.println("회원 정보를 삭제합니다. 메시지에 맞추어 정보를 입력하세요.");
		System.out.print("회원 입력 : ");
		String name = sc.nextLine();
		
		Member m = lc.myInfo(name);
		if(m != null) {
			lc.deleteMember(m);
			System.out.println("회원정보가 삭제되었습니다.");
		} else {
			System.out.println("삭제할 회원 정보가 없습니다.");
		}
	}
	
	public void selectAll() {
		Book[] bList = lc.selectAll();
		int idx = 0;
		for(Book b: bList) {
			System.out.println(idx + "번 도서 : " + b);
			idx++;
		}
	}
	
	public void searchBook() {
		System.out.print("검색할 제목 키워드 : ");
		String keyword = sc.nextLine();
		Book[] searchList = lc.searchBook(keyword);
		
		for(Book b: searchList) {
			System.out.println(b);
		}
	}
	
	public void rentBook() {
		this.selectAll();
		System.out.print("대여할 도서 번호, 회원명 입력(번호, 회원명) : ");
		String inputs[] = sc.nextLine().split(",");
		int bookNumber = Integer.parseInt(inputs[0]);
		String name = inputs[1].trim();
		
		int result = lc.rentBook(bookNumber, name);
		
		GregorianCalendar rentDate = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		switch(result) {
			case RentBook.SUCCESS:
				System.out.println("성공적으로 대여되었습니다.");
				System.out.println("대여일자 : " + df.format(rentDate.getTime()));
				rentDate.add(Calendar.DATE, lc.rentBookDays(bookNumber));
				System.out.println("반납일자 : " + df.format(rentDate.getTime()));
				break;
			case RentBook.AGE_LIMIT:
				System.out.println("나이 제한으로 대여 불가능입니다.");
				break;
			case RentBook.SUCCESS_COUPON:
				System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니"
						+ " 마이페이지에서 확인하세요");
				System.out.println("대여일자 : " + df.format(rentDate.getTime()));
				rentDate.add(Calendar.DATE, lc.rentBookDays(bookNumber));
				System.out.println("반납일자 : " + df.format(rentDate.getTime()));
				break;
		}
	}
	
	public static void main(String[] args) {
		LibraryMenu lm = new LibraryMenu();
		lm.mainMenu();
	}

}
