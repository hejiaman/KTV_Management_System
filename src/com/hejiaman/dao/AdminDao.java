package com.hejiaman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.hejiaman.model.Admin;

public class AdminDao extends BaseDao {
	/*
	 * 管理员登录
	 */
	public Admin login(Admin admin) {
		String sql = "select * from admin where manager_id=? and manager_password=?";
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把SQL语句传给数据库操作对象
			prst.setString(1,admin.getId());
			prst.setString(2,admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()) {
				adminRst = new Admin();
				adminRst.setNo(executeQuery.getInt("manager_no"));
				adminRst.setId(executeQuery.getString("manager_id"));
				adminRst.setPassword(executeQuery.getString("manager_password"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return adminRst;
	}
	/*
	 * 查询总人数
	 */
	public int getCount(String sql) {
		int count = 0;
		String sql2 = "select count(*) as totalCount from admin";
		 PreparedStatement st = null;
		 ResultSet rs;
		 try {
			 st = con.prepareStatement(sql2);
			 rs = st.executeQuery();
			 if(rs.next()) {  
		           count=rs.getInt("totalCount");  
		        } 
		 }catch (SQLException e) {
				e.printStackTrace();
			}
		return count;
	}
}
