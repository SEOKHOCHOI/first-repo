package com.kh.prog.controller;

import java.io.*;
import java.util.*;
import com.kh.prog.model.vo.*;

public class UserController implements DataControlInterface {
	
	private final File FILE = new File("user.info");
	private static final String OS_NAME;
	private static final String NEW_LINE;
	private Map<Integer, User> userMap = new HashMap<Integer, User>();
	
	static {
		OS_NAME = System.getProperty("os.name");
		if(OS_NAME.contains("Win")) {
			NEW_LINE = "\r\n";
		} else {			
			NEW_LINE = "\n";
		}
	}
	
//	{
//		userMap.put(1, new User("김재훈", 23, 'm', "kimjaehoon@sample.com"));
//		userMap.put(2, new User("박정우", 21, 'm', "packjungwoo@sample.com"));
//		userMap.put(3, new User("이수정", 22, 'w', "leesujung@sample.com"));
//		userMap.put(4, new User("박준호", 25, 'm', "packjunho@sample.com"));
//	}
	
	public UserController() {
		this.loadUserData();
	}
	
	private void loadUserData() {
		StringBuffer sb = new StringBuffer();
		FileReader fr;
		try {
			fr = new FileReader(FILE);
			BufferedReader br = new BufferedReader(fr);
			char[] buf = new char[1024];
			while(true) {
				int r = br.read(buf);
				if(r == -1) {
					break;
				}
				sb.append(buf, 0, r);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.convertFileToMap(sb.toString());
		
	}

	private void convertFileToMap(String fileContext) {
		/*
		 * 식별번호|회원명|나이|성별|이메일
		 * 1|김재훈|23|m|kimjaehoon@sample.com
		 * 2|박정우|21|m|packjungwoo@sample.com
		 * 3|이수정|22|w|leesujung@sample.
		 */
		String[] sLine = null;
		sLine = fileContext.split(NEW_LINE);
		
		List<String> Cols = new ArrayList<String>(Arrays.asList(sLine[0].split("\\|")));
		int id = 0;		int age = 0;	char gender = 0;
		String name = "";	String email = "";
		for(int i = 1; i < sLine.length; i++) {
			String[] sArr = sLine[i].split("\\|");
			id = Integer.parseInt(sArr[0]);
			name = sArr[1];	age = Integer.parseInt(sArr[2]);
			gender = sArr[3].charAt(0);	email = sArr[4];
			this.userMap.put(id, new User(name, age, gender, email));
		}
	}
	
	private void saveUserData(User data) {
		FileWriter fw;
		try {
			fw = new FileWriter(FILE, true);
			BufferedWriter bw = new BufferedWriter(fw);
			fw.write(String.format("%d|%s|%d|%c|%s" + NEW_LINE
					, data.getUserId(), data.getName()
					, data.getAge(), data.getGender()
					, data.getEmail().toString()));
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isUsedId(int id) {
		return this.selectOne(id) == null ? false : true;
	}
	
	public boolean isUsedName(String name) {
		if(this.select(name) == null) {
			return false;
		}
		return true;
	}
	
	// 동일한 회원 정보가 있는지 검사하는 메서드
	public boolean isExisted(User user) {
		// 회원 ID로 Map 컬렉션에 동일한 Key 를 가지는 객체가 있는지 확인
		User src = userMap.get(user.getUserId());
		if(src == null) {	// 없음
			return false;
		}
		// 회원 ID도 동일하고 회원 이름도 동일한 객체인지 확인
		if(!src.equals(user)) {
			return false;
		}
		return true;
	}

	@Override
	public List<User> select() {
		return new ArrayList<User>(userMap.values());
	}

	@Override
	public List<User> select(String search) {
		List<User> temp = new ArrayList<User>();
		for(Map.Entry<Integer, User> m: userMap.entrySet()) {
			if(m.getValue().contains(search)) {
				temp.add(m.getValue());
			}
		}
		return temp.isEmpty() ? null : temp;
	}

	@Override
	public User selectOne(int id) {
		return userMap.get(id);
	}

	@Override
	public int insert(User user) {
		if(!this.isUsedId(user.getUserId())) {
			userMap.put(user.getUserId(), user);
			this.saveUserData(userMap.get(user.getUserId()));
			return 1;
		}
		return 0;
	}

	@Override
	public int update(User user) {
		if(!this.isExisted(user)) {
			return 0;
		}
		User src = userMap.get(user.getUserId());
		if(src.getAge() != user.getAge()) {
			src.setAge(user.getAge());
		}
		if(src.getGender() != user.getGender()) {
			src.setGender(user.getGender());
		}
		if(!src.getEmail().equals(user.getEmail())) {
			src.setEmail(user.getEmail());
		}
		return 1;
	}
	
	public int changeName(int id, String name, String change) {
		User user = new User(id, name);
		if(!this.isExisted(user)) {
			return 0;
		}
		User src = userMap.get(user.getUserId());
		src.setName(change);
		return 1;
	}

	@Override
	public int delete(User user) {
		if(!this.isExisted(user)) {
			return 0;
		}
		userMap.remove(user.getUserId());
		return 1;
	}

	@Override
	public int delete(int id) {
		if(userMap.remove(id) == null) {
			return 0;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		UserController uc = new UserController();
		System.out.println(uc.select());
		uc.changeName(2, "박정우", "김정우");
		System.out.println(uc.select());
	}
	
}
