package com.kh.exam1;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.conn.OracleConnect;

public class Sample1 {

	public static void main(String[] args) {
		String query = "SELECT FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES";
		
		// Database 에 연결된 객체 정보까지만 생성자를 통해 만든다.
		OracleConnect oc = null;
		try {
			oc = new OracleConnect();
		
			// 연결된 커넥션을 통해 SQL을 전송할 수 있도록 미리 Query 문자열을 설정한다.
			oc.setQuery(query);
			
			// 설정된 Query 문자열로 SQL 질의문이 전송되도록 하며, 결과물로 ResultSet을 반환받는다.
			ResultSet rs = oc.execute();
			
			// 반환 받은 데이터를 반복문을 사용하여 반복 출력한다.
			String fName, lName;
			int salary;
			while(rs.next()) {
				fName = rs.getString(1);
				lName = rs.getString(2);
				salary = rs.getInt(3);
				System.out.println(fName + " " + lName + ":" + salary);
			}
			// 모든 작업 완료후 객체를 반환한다.
			rs.close();
			oc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
