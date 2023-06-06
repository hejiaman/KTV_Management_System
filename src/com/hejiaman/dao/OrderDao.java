package com.hejiaman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hejiaman.model.Customer;
import com.hejiaman.model.Reserve;
import com.hejiaman.util.StringUtil;

public class OrderDao extends BaseDao{
	/*
	 * 提交预约订单
	 */
	
	public String Order(Reserve reserve){
		String Sqlstring = "select * from reserve where order_room=? and order_begintime=?";
		PreparedStatement prest = null;
		PreparedStatement prest1 = null;
		String Rststring = null;
		try{
			prest = con.prepareStatement(Sqlstring);
			prest.setString(1,reserve.getOrder_room());
			prest.setString(2,reserve.getOrder_begintime());
			ResultSet executeQuery = prest.executeQuery();
			if(executeQuery.next()) {
				Rststring = "该时间段该房间已被预约，请重新输入";
				return Rststring;
			}
		}catch (SQLException el) {
				el.printStackTrace();
		}
		
		String sql2 = "insert into reserve(order_user,order_room,order_begintime,order_endtime) VALUES (?,?,?,?)";
		try{

			prest1 = con.prepareStatement(sql2);
			prest1.setString(1,reserve.getOrder_user());
			prest1.setString(2,reserve.getOrder_room());
			prest1.setString(3,reserve.getOrder_begintime());
			prest1.setString(4,reserve.getOrder_endtime());

			int rst = prest1.executeUpdate();
			if(rst>0) {
			Rststring = "恭喜您，预约成功";
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Rststring;
		
	}
	
	/*
	 * 取消预约订单
	 */
	public String cancle(Reserve reserve) {
		String sql = "select * from reserve where order_user =?";
		PreparedStatement prest = null;
		String Rststring = null;
		try{
			prest = con.prepareStatement(sql);
			prest.setString(1,reserve.getOrder_user());
			ResultSet executeQuery = prest.executeQuery();
			if(!executeQuery.next()) {
				Rststring = "该账号还没有预约哦！";
				return Rststring;
			}
		}catch (SQLException el) {
				el.printStackTrace();
		}
		sql = "delete from reserve where order_user =? and order_room=?";
				try{

					prest = con.prepareStatement(sql);
					prest.setString(1,reserve.getOrder_user());
					prest.setString(2, reserve.getOrder_room());
					int rst = prest.executeUpdate();
					if(rst>0) {
					Rststring = "取消预约成功";
					}
				
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
				return Rststring;
		
		
	}
	
	
	
	
	/*
	 * 根据顾客姓名查询预约订单
	 */
	public List<Reserve> getClassList(Reserve reserve,String customer_name){
		List<Reserve> retList= new ArrayList<Reserve>();
		String sql = "SELECT customer_name,order_user,order_room,order_begintime,order_endtime from reserve,customer WHERE reserve.order_user = customer.customer_id AND customer_name =?";
		try{
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, customer_name);
			ResultSet executeQuery = prest.executeQuery();
			while(executeQuery.next()) {
			Reserve res = new Reserve();
			Customer cus = new Customer();
			cus.setCustomer_name(executeQuery.getString("customer_name"));
			res.setOrder_user(executeQuery.getString("order_user"));
			res.setOrder_room(executeQuery.getString("order_room"));
			res.setOrder_begintime(executeQuery.getString("order_begintime"));
			res.setOrder_endtime(executeQuery.getString("order_endtime"));
			retList.add(res);
			}
		}catch (SQLException el) {
				el.printStackTrace();
		}
		
		return retList;
		
	}
	
	
	
	
	}
	

