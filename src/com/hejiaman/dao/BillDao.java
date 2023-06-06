package com.hejiaman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hejiaman.model.Customer;

public class BillDao extends BaseDao{
	
	/*
	 * 提交bill表单
	 */
	public String checkout(String customer_id,String room_id,String bill_price) {
		String sql = "insert into bill(customer_id,room_id,bill_price) VALUES (?,?,?)";
		PreparedStatement prest = null;
		try {
			prest = con.prepareStatement(sql);
			prest.setString(1, customer_id);
			prest.setString(2, room_id);
			prest.setString(3, bill_price);	
			int rst = prest.executeUpdate();
			if(rst>0) {
				String Rststring = "消费订单记录成功！";
				return Rststring;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
	
	public Double sum() {
		String sql = "call summary(@sum)";
		double sum =0;
		try {
			PreparedStatement prest = con.prepareStatement(sql);
			 prest=con.prepareStatement(sql);
			 ResultSet rs=prest.executeQuery();
			 while(rs.next()){
				 sum=rs.getDouble(1);
      	
             }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sum;
		
	}
	public Double avg() {
		String sql = "call average(@avg)";
		double avg =0;
		try {
			PreparedStatement prest = con.prepareStatement(sql);
			 prest=con.prepareStatement(sql);
			 ResultSet rs=prest.executeQuery();
			 while(rs.next()){
				 avg=rs.getDouble(1);        	
             }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return avg;
		
	}

}
