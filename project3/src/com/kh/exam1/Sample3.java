package com.kh.exam1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.*;

import com.db.conn.OracleConnect;

public class Sample3 {

	public static void main(String[] args) {
		// 사용자 입력을 활용하여 입력한 부서코드에 해당하는 사원정보(사번, 이름, 부서명, 직무명)
		// 입력한 파일명으로 저장되도록 한다.(파일은 CSV 파일로 저장하여 엑셀로 열릴 수 있게 한다.)
		Scanner sc = new Scanner(System.in);
		
		String query = "SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES";
		
		OracleConnect oc = null;
		try {
			oc = new OracleConnect(true);
			oc.setQuery(query);
			ResultSet rs = oc.execute();
			
			List<String> deptList = new ArrayList<String>();
			
			while(rs.next()) {
				deptList.add(String.valueOf(rs.getInt(1)));
			}
			
			boolean dept_exists = false;
			String deptCode;
			while(true) {
				System.out.print("부서 코드 : ");
				deptCode = sc.nextLine();
				
				dept_exists = deptList.indexOf(deptCode) > 0 ? true : false;
				
				if(!dept_exists) {
					System.out.println("해당 부서코드가 존재하지 않습니다. 다시 입력하세요.");
				} else {
					break;
				}
			}
			
			query = "SELECT A.EMPLOYEE_ID"
				+ "     , A.FIRST_NAME || ' ' || A.LAST_NAME"
				+ "     , B.DEPARTMENT_NAME"
				+ "     , C.JOB_TITLE"
				+ "  FROM EMPLOYEES A JOIN DEPARTMENTS B"
				+ "    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID"
				+ "  JOIN JOBS C"
				+ "    ON A.JOB_ID = C.JOB_ID"
				+ " WHERE A.DEPARTMENT_ID = " + deptCode;
			oc.setQuery(query);
			rs = oc.execute();
			
			System.out.print("파일명을 입력하세요. : ");
			String filename = sc.nextLine();
			
			FileWriter fw = new FileWriter(filename + ".csv");
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("사번,이름,부서명,직무명\r\n");
			while(rs.next()) {
				bw.write(rs.getInt(1) + "," + rs.getString(2) + ","
						+ rs.getString(3) + "," + rs.getString(4) + "\r\n");
			}
			
			bw.close(); fw.close();
			rs.close();	oc.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
