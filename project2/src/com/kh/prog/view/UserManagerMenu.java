package com.kh.prog.view;

import java.util.*;
import com.kh.prog.controller.UserController;
import com.kh.prog.model.vo.Email;
import com.kh.prog.model.vo.User;

public class UserManagerMenu {
	
	private UserController uc = new UserController();
	private List<String> menuList = new ArrayList<String>();
	private Scanner sc = new Scanner(System.in);
	
	{
		menuList.add("목록");
		menuList.add("가입");
		menuList.add("수정");
		menuList.add("탈퇴");
		menuList.add("종료");
	}
	
	public void mainMenu() {
		String strMenu = "---------- 회원 관리 프로그램 ----------\n";
		for(int i = 0; i < menuList.size(); i++) {
			strMenu += String.format("[%d] %s\n", i + 1, menuList.get(i));
		}
		strMenu += "번호: ";
		System.out.print(strMenu);
		
		int numMenu = 0;
		while(true) {
			if(sc.hasNextInt()) {
				numMenu = sc.nextInt();	sc.nextLine();
				if(numMenu > 0 && numMenu <= menuList.size()) {
					switch(numMenu) {
						case 1:
							this.userList();	break;
						case 2:
							this.userCreate();	break;
						case 3:
							this.userUpdate();	break;
						case 4:
							this.userDelete();	break;
						case 5:
							System.exit(0);
					}
				}
			} else {
				sc.nextLine();
			}
			System.out.print(strMenu);
		}
	}
	
	public void userList() {
		System.out.println(uc.select());
		
		System.out.print("검색(이름) : ");
		String search = sc.nextLine();
		
		System.out.println(uc.select(search));
	}
	
	public void userCreate() {
		String name, email;
		int age;
		char gender;
		
		System.out.println("회원 가입을 진행합니다. 아래에 요구하는 데이터를 적절히 작성해 주세요.");
		while(true) {
			System.out.print("이름: ");
			name = sc.nextLine();
			if(!uc.isUsedName(name)) {
				break;
			}
			System.out.println("가입 이력이 있습니다.");
			System.out.println(uc.select(name));
			System.out.print("계속 가입을 진행하겠습니까?(Y/N): ");
			if(sc.nextLine().charAt(0) == 'Y'
					|| sc.nextLine().charAt(0) == 'y') {
				break;
			} else {
				return;
			}
		}
		
		while(true) {
			System.out.print("이메일: ");
			email = sc.nextLine();
			if(Email.isValid(email)) {
				break;
			}
			System.out.println("이메일 주소 형식이 올바르지 않습니다.");
		}
		
		while(true) {
			System.out.print("나이(1 ~ 100): ");
			age = sc.nextInt();	sc.nextLine();
			if(age > 0 && age <= 100) {
				break;
			}
			System.out.println("나이가 올바르지 않습니다.");
		}
		
		while(true) {
			System.out.print("성별(남/여): ");
			gender = sc.nextLine().charAt(0);
			if(gender == '남' || gender == '여') {
				break;
			}
			System.out.println("성별 입력을 잘못하였습니다.");
		}
		
		int res = uc.insert(new User(name, age, gender, email));
		if(res == 1) {
			System.out.println("회원 가입이 완료 되었습니다.");
		} else {
			System.out.println("회원 가입이 실패 했습니다.");
		}
		
	}
	
	public void userUpdate() {
		
	}
	
	public void userDelete() {
		
	}
}
