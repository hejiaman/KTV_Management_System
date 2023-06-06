package com.hejiaman.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/ktv";//数据库链接地址
	private String dbUserName="root";//用户名
	private String dbPassword="hjm861303";//密码
	private String jdbcName="com.mysql.cj.jdbc.Driver";//驱动名称
	/*
	 * 获取数据库连接
	 * @return
	 * @throws exception
	 */
	public Connection getCon() {
		try {
			Class.forName(jdbcName);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/*
	 * 关闭数据库连接
	 * @path con
	 * @throws Excwption
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
		    System.out.println("Connection successed");	
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection failed");
		}
	}
}
