package com.kh.exam1;

import java.io.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.db.conn.OracleConnect;

class Employee {
	private String name;
	private int salary;
	private double commission;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public double getCommission() {
		return commission;
	}
	
	public void setCommission(double commission) {
		this.commission = commission;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary
				+ ", commission=" + commission + "]";
	}
	
}

public class Sample2 {

	public static void main(String[] args) {
		String query = "SELECT FIRST_NAME || ' ' || LAST_NAME AS NAME"
				+ "     , SALARY"
				+ "     , COMMISSION_PCT"
				+ "  FROM EMPLOYEES"
				+ " WHERE SALARY >= 8000";
		
		OracleConnect oc = null;
		try {
			oc = new OracleConnect();
			oc.setQuery(query);
			ResultSet rs = oc.execute();
			List<Employee> empList = new ArrayList<Employee>();
			
			while(rs.next()) {
				Employee e = new Employee();
				e.setName(rs.getString(1));
				e.setSalary(rs.getInt(2));
				e.setCommission(rs.getDouble(3));
				empList.add(e);
			}
			
			// 콘솔에 출력하는 것이 아닌 파일로 출력하는 것으로 변경한다.
			// 파일명은 Employee.txt
			// FileWriter 스트림 객체에 BufferedWriter 보소 스트림을 사용하여 파일출력
			FileWriter fw = new FileWriter("./Employee.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("NAME,SALARY,COMMISSION\r\n");
			for(Employee e: empList) {
				bw.write(e.getName() + "," + e.getSalary() + "," + e.getCommission() + "\r\n");
			}
			
			bw.close();	fw.close();
			rs.close();	oc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}