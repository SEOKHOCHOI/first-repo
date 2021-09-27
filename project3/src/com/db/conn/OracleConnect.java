package com.db.conn;

import java.io.*;
import java.sql.*;
import java.util.*;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleConnect {
	// 1. 데이터베이스 연결 구성 정보 생성
	//어느 데이터 베이스를 생성할거냐.
	//클라우드>> private final String DB_URL = "jdbc:oracle:thin:@testdb_medium?TNS_ADMIN";
	//로컬인 경우
	private final String LOCAL_URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	//계정명은?
	private final String USERNAME = "user1";
	//암호는?
	private final String PASSWORD = "user1";
	
	private Properties info = new Properties();
	private OracleDataSource ods = null;
	//private OracleConnection conn1 = null;
	//private Statement stat1 = null;
	
	private Connection conn2 = null;
	private Statement stat2 = null;
	private String query;
	
	public OracleConnect() throws Exception {
		/*
		 * Oracle Database 연결을 위한 과정
		 *  1. 데이터베이스 연결 구성 정보 생성
		 *  2. 연결 구성 정보로 데이터베이스 연결
		 *  3. 생성된 연결정보로 Statement 생성
		 *  4. 생성된 Statement로 Query 전송
		 *  5. ResultSet 받아서 필요한 내부 처리 진행
		 *  6. 모든 내부 처리 완료 후 지원 반납.(close 작업) 
		 */
		
		
		  //2. 연결 구성 정보로 데이터베이스 연결(OracleCloud에 접속하기 위한 코드) 
		  //월렛사용했냐 안했냐의 차이임 사실.
		  //this.info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, this.USERNAME);
		  //this.info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, this.PASSWORD);
		 // this.ods = new OracleDataSource();
		  //this.ods.setURL(DB_URL);
		 //this.ods.setConnectionProperties(this.info);
		 // this.conn1 = (OracleConnection) ods.getConnection();
		 
		
		// 2. 연결 구성 정보로 데이터베이스 연결(로컬에 설치한 Oracle에 접속하기 위한 코드)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		this.conn2 = DriverManager.getConnection(LOCAL_URL, USERNAME, PASSWORD);
		
		// 3. 생성된 연결정보로 Statement 생성
		//this.stat1 = this.conn1.createStatement();
		this.stat2 = this.conn2.createStatement();
		
	
		
		
		

		
	}
	
	// 실행한 SQL Query를 외부에서 설정하게 한다.
	public void setQuery(String query) {
		this.query = query;
	}

	// 설정된 SQL Query를 실행후 결과를 반환한다.
	public ResultSet execute() {
		ResultSet rs = null;
		
		if(this.query == null) {
			return rs;
		}
		
		try {
			rs = this.stat2.executeQuery(this.query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close() throws SQLException {
		// 6. 모든 내부 처리 완료 후 자원 반납.(close 작업)
		this.stat2.close();	// this.stat2.close();
		this.conn2.close();	// this.conn2.close();
	}
	
	public static void main(String[] args) {
		try {
			OracleConnect oc = new OracleConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
