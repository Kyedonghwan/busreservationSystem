package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	static {
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}		
	}//static 초기화 블럭
	
	public static Connection getConnection(String url, String user, 
			String upwd) 
			throws SQLException {
		Connection conn=DriverManager.getConnection(url, user, upwd);
		System.out.println("db 연결, conn="+conn);
		
		return conn;
	}
	
	public static Connection getConnection(String user, String upwd) 
			throws SQLException {
		String url="jdbc:oracle:thin:@DESKTOP-PJ03E7Q:1521:xe";
		Connection conn=getConnection(url, user, upwd);
		return conn;
	}
	
	public static Connection getConnection() throws SQLException {
		String url="jdbc:oracle:thin:@DESKTOP-PJ03E7Q:1521:xe";
		String user="kyedonghwan", upwd="kyedonghwan123";
		Connection conn=getConnection(url, user, upwd);
		return conn;
	}
	
	public static void dbClose(PreparedStatement ps, Connection conn) 
			throws SQLException {
		if(ps!=null) ps.close();
		if(conn !=null) conn.close();
	}
	
	public static void dbClose(ResultSet rs, PreparedStatement ps, Connection conn) 
			throws SQLException {
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(conn !=null) conn.close();
	}
	
	
}
