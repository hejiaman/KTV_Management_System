package com.hejiaman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hejiaman.model.Customer;
import com.hejiaman.model.waiter;

public class WaiterDao extends BaseDao{
	/*
	 * 服务员登录
	 */
	public waiter login(waiter waiter) {
		String sql = "select * from waiter where waiter_id=? and waiter_password=?";
		waiter waiterRst = null;
		try {
			PreparedStatement prest = con.prepareStatement(sql);//把SQL语句传给数据库操作对象
			prest.setString(1,waiter.getWaiter_id());
			prest.setString(2,waiter.getWaiter_password());
			ResultSet executeQuery = prest.executeQuery();
			if(executeQuery.next()) {
				waiterRst = new waiter();
				waiterRst.setWaiter_id(executeQuery.getString("waiter_id"));
				waiterRst.setWaiter_name(executeQuery.getString("waiter_name"));
				waiterRst.setWaiter_sex(executeQuery.getString("waiter_sex"));
				waiterRst.setWaiter_tel(executeQuery.getString("waiter_tel"));
				waiterRst.setWaiter_password(executeQuery.getString("waiter_password"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return waiterRst;
	}
	
	public String changename(String changename,String id) {
		String sql = "update waiter set waiter_name =? where waiter_id =?";
		String retString = null;
		try {
			PreparedStatement prest= con.prepareStatement(sql);
			prest.setString(1,changename);
			prest.setString(2,id);
			int rst = prest.executeUpdate();
			if(rst > 0) {
				retString = "姓名修改成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retString;
				
	}
	
	public String changetel(String changetel,String id) {
		String sql = "update waiter set waiter_tel =? where waiter_id =?";
		String retString = null;
		try {
			PreparedStatement prest= con.prepareStatement(sql);
			prest.setString(1,changetel);
			prest.setString(2,id);
			int rst = prest.executeUpdate();
			if(rst > 0) {
				retString = "联系方式修改成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retString;
		
	}
	
	public String editpassword(String oldPassword,String newPassword,String id) {
		String sql = "select * from waiter where waiter_id=? and waiter_password=?";
		PreparedStatement prest = null;
		PreparedStatement prest1 = null;
		String retString = null;
		try {
		prest= con.prepareStatement(sql);//把SQL语句传给数据库操作对象
		prest.setString(1,id);
		prest.setString(2,oldPassword);
		ResultSet executeQuery = prest.executeQuery();
		if(!executeQuery.next()) {
				retString = "旧密码错误！";
				return retString; 
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql1 = "update waiter set waiter_password =? where waiter_id =?";
		try {
		prest1= con.prepareStatement(sql1);//把SQL语句传给数据库操作对象
		prest1.setString(1,newPassword);
		prest1.setString(2,id);
		int rst = prest1.executeUpdate();
		if(rst > 0) {
			retString = "密码修改成功！";
		}
		}catch (SQLException e) {
			e.printStackTrace();
     	}
		return retString;
	}
	/*
	 * 查询服务员信息（管理员）
	 */
	public List<waiter> getwaiterList(waiter waiter1){
		List<waiter> retList= new ArrayList<waiter>();
		String sql = "SELECT * from waiter WHERE waiter_name =?";
		try{
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, waiter1.getWaiter_name());
			ResultSet executeQuery = prest.executeQuery();
			while(executeQuery.next()) {
			waiter wai = new waiter();
			wai.setWaiter_id(executeQuery.getString("waiter_id"));
			wai.setWaiter_name(executeQuery.getString("waiter_name"));
			wai.setWaiter_sex(executeQuery.getString("waiter_sex"));
			wai.setWaiter_tel(executeQuery.getString("waiter_tel"));
			wai.setWaiter_password(executeQuery.getString("waiter_password"));
			retList.add(wai);
			}
		}catch (SQLException el) {
				el.printStackTrace();
		}
		
		return retList;
		
	}
	
	/*
	 * 删除服务员数据
	 */
	public boolean delete(String id) {
		String sql = "delete from waiter where waiter_id =?";
		
		try {
			PreparedStatement prest= con.prepareStatement(sql);
			prest.setString(1, id);
			if(prest.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	/*
	 * 记录迟到员工
	 */
	public boolean late(String id) {
		String sql = "update waiter_absence set waiter_ab = waiter_ab +1 where waiter_id=?";
		try {
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, id);
			if(prest.executeUpdate()>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * 更新表数据（管理员）
	 */
	public boolean update(waiter waiter1) {
		String sql = "update waiter set waiter_name =?,waiter_sex =?,waiter_password=?,waiter_tel =? where waiter_id =?";
		
		try {
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, waiter1.getWaiter_name());
			prest.setString(2, waiter1.getWaiter_sex());
			prest.setString(3,waiter1.getWaiter_password());
			prest.setString(4,waiter1.getWaiter_tel());
			prest.setString(5, waiter1.getWaiter_id());
			if(prest.executeUpdate()>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	/*
	 * 查询总人数
	 */
	public int getCount() {
		int count = 0;
		String sql = "select count(*) as totalCount from waiter";
		 PreparedStatement st = null;
		 ResultSet rs;
		 try {
			 st = con.prepareStatement(sql);
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
