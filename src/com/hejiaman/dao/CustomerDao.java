package com.hejiaman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.hejiaman.model.Admin;
import com.hejiaman.model.Customer;
import com.hejiaman.model.Reserve;

public class CustomerDao extends BaseDao {
	/*
	 * 顾客登录
	 */
	public Customer login(Customer customer) {
		String sql = "select * from customer where customer_id=? and customer_password=?";
		Customer customerRst = null;
		try {
			PreparedStatement prest = con.prepareStatement(sql);//把SQL语句传给数据库操作对象
			prest.setString(1,customer.getCustomer_id());
			prest.setString(2,customer.getCustomer_password());
			ResultSet executeQuery = prest.executeQuery();
			if(executeQuery.next()) {
				customerRst = new Customer();
				customerRst.setCustomer_id(executeQuery.getString("customer_id"));
				customerRst.setCustomer_idcard(executeQuery.getString("customer_idcard"));
				customerRst.setCustomer_name(executeQuery.getString("customer_name"));
				customerRst.setCustomer_password(executeQuery.getString("customer_password"));
				customerRst.setCustomer_sex(executeQuery.getString("customer_sex"));
				customerRst.setCustomer_tel(executeQuery.getString("customer_tel"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return customerRst;
	}
	
	/*
	 * 用户注册
	 */
	public String Zhuce(Customer customer) {

		String Sqlstring = "select * from customer where customer_id=?";
		PreparedStatement prest = null;
		PreparedStatement prest1 = null;
		String Rststring = null;
		try{
			prest = con.prepareStatement(Sqlstring);
			prest.setString(1,customer.getCustomer_id());
			ResultSet executeQuery = prest.executeQuery();
			if(executeQuery.next()) {
				Rststring = "账号已存在";
				return Rststring;
//				JOptionPane.showMessageDialog(null, "账号已存在", "提示", 0);
//				return null;
			}
		}catch (SQLException el) {
				el.printStackTrace();
		}
		
		String sql2 = "insert into `customer`  VALUES (?,?,?,?,?,?)";
		try{

			prest1 = con.prepareStatement(sql2);
			prest1.setString(1,customer.getCustomer_id());
			prest1.setString(2,customer.getCustomer_name());
			prest1.setString(3,customer.getCustomer_sex());
			prest1.setString(4,customer.getCustomer_idcard());
			prest1.setString(5,customer.getCustomer_tel());
			prest1.setString(6,customer.getCustomer_password());

			int rst = prest1.executeUpdate();
			if(rst>0) {
			Rststring = "恭喜您，注册成功";
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return Rststring;
		
	}
	/*
	 * 更新密码（自我修改）
	 */
	public String editpassword(String oldPassword,String newPassword,String id) {
		String sql = "select* from customer where customer_id=? and customer_password=?";
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
		
		String sql1 = "update customer set customer_password =? where customer_id =?";
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
	 * 更新姓名（自我修改）
	 */
	public String changename(String changename,String id) {
		String sql = "update customer set customer_name =? where customer_id =?";
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
	/*
	 * 更新联系方式（自我修改）
	 */
	
	public String changetel(String changetel,String id) {
		String sql = "update customer set customer_tel =? where customer_id =?";
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
	
	/*
	 * 导出所有顾客的信息
	 */
	public List<Customer> queryAllCustomer(){
        String sql="select * from waiter_customerinfo";
        List<Customer> list=new ArrayList<Customer>();
        try {
        	 PreparedStatement prest= con.prepareStatement(sql);
        	 prest=con.prepareStatement(sql);
        	 ResultSet rs=prest.executeQuery();
             System.out.println(prest.toString());
             while(rs.next()){
            	 Customer customer = new Customer();
            	 customer.setCustomer_id(rs.getString(1));
            	 customer.setCustomer_idcard(rs.getString(2));
            	 customer.setCustomer_name(rs.getString(3));
            	 customer.setCustomer_sex(rs.getString(4));
            	 customer.setCustomer_tel(rs.getString(5));     
                 list.add(customer);
             }
             
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	
	/*
	 * 根据姓名查询顾客信息（管理员）
	 */
	public List<Customer> getcustomerList(Customer customer){
		List<Customer> retList= new ArrayList<Customer>();
		String sql = "SELECT * from customer WHERE customer_name =?";
		try{
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, customer.getCustomer_name());
			ResultSet executeQuery = prest.executeQuery();
			while(executeQuery.next()) {
			Customer cus = new Customer();
			cus.setCustomer_id(executeQuery.getString("customer_id"));
			cus.setCustomer_name(executeQuery.getString("customer_name"));
			cus.setCustomer_sex(executeQuery.getString("customer_sex"));
			cus.setCustomer_idcard(executeQuery.getString("customer_idcard"));
			cus.setCustomer_tel(executeQuery.getString("customer_tel"));
			cus.setCustomer_password(executeQuery.getString("customer_password"));
			retList.add(cus);
			}
		}catch (SQLException el) {
				el.printStackTrace();
		}
		
		return retList;
		
	}
	
	/*
	 * 删除顾客数据
	 */
	public boolean delete(String id) {
		String sql = "delete from customer where customer_id =?";
		
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
	 * 更新表数据（管理员）
	 */
	public boolean update(Customer customer) {
		String sql = "update customer set customer_name =?,customer_sex =?,customer_password=?,customer_tel =? where customer_id =?";
		
		try {
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, customer.getCustomer_name());
			prest.setString(2, customer.getCustomer_sex());
			prest.setString(3,customer.getCustomer_password());
			prest.setString(4,customer.getCustomer_tel());
			prest.setString(5, customer.getCustomer_id());
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
	public int getCount(String sql) {
		int count = 0;
		String sql1 = "select count(*) as totalCount from customer";
		 PreparedStatement st = null;
		 ResultSet rs;
		 try {
			 st = con.prepareStatement(sql1);
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
