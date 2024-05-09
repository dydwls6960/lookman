package com.lookman.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "C##LOOKMAN";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, user, pwd);

		conn.setAutoCommit(false);

		return conn;
	}
}
