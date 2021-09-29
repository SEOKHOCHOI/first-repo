package com.kh.exam1;

import java.io.*;
import java.sql.ResultSet;
import java.util.*;

import com.db.conn.OracleConnect;

class CountriesInfo {
	private String name;
	private int count;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "CountiresInfo [name=" + name + ", count=" + count + "]";
	}
	
}

class EmpInfo {
	private int id;
	private String name;
	private String dept;
	private String job;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "EmpInfo [id=" + id + ", name=" + name + ", dept=" + dept
				+ ", job=" + job + "]";
	}
	
	
}

public class Sample4 {

	public static void main(String[] args) {
		/*
		 * 나라별로 소속된 직원들의 정보를 CSV 파일로 출력하는 프로그램 작성
		 * 	1. 현재 회사의 지사들이 어떤 나라에 있는지 국가 목록을 출력
		 * 	2. 국가 목록에는 해당 국가에 소속된 직원의 총원이 몇명인지도 같이 출력
		 * 		출력 예)
		 *  		1. United States of America [총원 10명]
		 *  		2. Canada [총원 2명]
		 *  		...
		 *  3. 출력된 국가 목록의 번호를 입력하면 해당 국가에 소속된 모든 사원정보를 출력
		 *  	(사원정보 -> 사번, 이름, 소속부서, 직무)
		 *  4. 필요한 경우 파일로 저장할 수 있게 한다.(파일명은 xxx에 소속된 사원 목록.csv)
		 *  	파일명 예)
		 *  		Canada에 소속된 사원 목록.csv
		 *  		United States of America에 소속된 사원 목록.csv
		 */
		Scanner sc = new Scanner(System.in);
		
		String query = "SELECT D.COUNTRY_NAME"
				+ "     , COUNT(*)"
				+ "  FROM EMPLOYEES A JOIN DEPARTMENTS B"
				+ "    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID"
				+ "  JOIN LOCATIONS C"
				+ "    ON B.LOCATION_ID = C.LOCATION_ID"
				+ "  JOIN COUNTRIES D"
				+ "    ON C.COUNTRY_ID = D.COUNTRY_ID"
				+ " GROUP BY D.COUNTRY_NAME";
		
		OracleConnect oc = null;
		try {
			oc = new OracleConnect(true);
			oc.setQuery(query);
			ResultSet rs = oc.execute();
			
			List<CountriesInfo> countryList = new ArrayList<CountriesInfo>();
			
			while(rs.next()) {
				CountriesInfo c = new CountriesInfo();
				c.setName(rs.getString(1));
				c.setCount(rs.getInt(2));
				countryList.add(c);
			}
			
			
			for(CountriesInfo c: countryList) {
				System.out.println((countryList.indexOf(c) + 1) + ". "
						+ c.getName() + " [총원 " + c.getCount() + "명]");
			}
			
			int countryNum;
			
			while(true) {
				System.out.print("번호 입력 : ");
				if(sc.hasNextInt()) {
					countryNum = sc.nextInt();
					if(countryNum > countryList.size()) {
						System.out.println("1 ~ " + countryList.size() + " 까지만"
								+ " 입력하세요.");
						continue;
					}
					sc.nextLine();
					break;
				} else {
					System.out.println("다시 입력 하세요.");
				}
				sc.nextLine();
			}
			
			query = "SELECT A.EMPLOYEE_ID"
					+ "     , A.FIRST_NAME || ' ' || A.LAST_NAME AS NAME"
					+ "     , B.DEPARTMENT_NAME\n"
					+ "     , (SELECT JOB_TITLE FROM JOBS E WHERE A.JOB_ID = E.JOB_ID) AS JOB_TITLE"
					+ "  FROM EMPLOYEES A JOIN DEPARTMENTS B"
					+ "    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID"
					+ "  JOIN LOCATIONS C"
					+ "    ON B.LOCATION_ID = C.LOCATION_ID"
					+ "  JOIN COUNTRIES D"
					+ "    ON C.COUNTRY_ID = D.COUNTRY_ID"
					+ " WHERE D.COUNTRY_NAME = '" + countryList.get(countryNum-1).getName() + "'";
			oc.setQuery(query);
			rs = oc.execute();
			
			List<EmpInfo> empList = new ArrayList<EmpInfo>();
			while(rs.next()) {
				EmpInfo e = new EmpInfo();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDept(rs.getString(3));
				e.setJob(rs.getString(4));
				empList.add(e);
			}
			
			for(EmpInfo e: empList) {
				System.out.println(e);
			}
			
			String yesNo;
			while(true) {
				System.out.print("파일로 출력하겠습니까?(y/n) : ");
				yesNo = sc.nextLine().toLowerCase();
				if(yesNo.equals("y") || yesNo.equals("n")) {
					break;
				} else {
					System.out.println("y 또는 n 으로 입력하세요.");
				}
			}
			
			if(yesNo.equals("y")) {
				FileWriter fw = new FileWriter(countryList.get(countryNum-1).getName()
						+ "에 소속된 사원 목록.csv");
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write("사번,이름,소속부서,직무\r\n");
				for(EmpInfo e: empList) {
					bw.write(e.getId() + "," + e.getName() + "," + e.getDept()
							+ e.getJob() + "\r\n");
				}
				bw.close(); fw.close();
			}
			
			rs.close();	oc.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}

