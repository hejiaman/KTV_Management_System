package com.hejiaman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hejiaman.model.Customer;
import com.hejiaman.model.Room;
import com.hejiaman.model.waiter;

public class RoomDao extends BaseDao{

	/*
	 * 确认安排房间后，对应的房间号的room_condition变为使用中
	 */
	public String changecondition(String room_id) {
		String sql = "update room set room_condition =? where room_id =?";
		PreparedStatement prest = null;
		String using = "使用中";
		try {
			prest = con.prepareStatement(sql);
			prest.setString(1, using);
			prest.setString(2, room_id);
			int rst = prest.executeUpdate();
			if(rst >0) {
				String retString = "房间安排成功，请引导顾客前往";
				return retString;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "出错啦!";
		
	}
	
	/*
	 * 删除房间数据
	 */
	public boolean delete(String id) {
		String sql = "delete from room where room_id =?";
		
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
	 * 确认退房后，修改room-condition为空闲中
	 */
	public String changecondition1(String room_id) {
		String sql = "update room set room_condition =? where room_id =?";
		PreparedStatement prest = null;
		String using = "空闲中";
		try {
			prest = con.prepareStatement(sql);
			prest.setString(1, using);
			prest.setString(2, room_id);
			int rst = prest.executeUpdate();
			if(rst >0) {
				String retString = "退房成功，房间状态已变为空闲";
				return retString;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "出错啦!";
		
	}
	
	/*
	 * 查询所有房间的信息
	 */
	public List<Room> queryAllRoom(){
        String sql="select * from room";
        List<Room> list=new ArrayList<Room>();
        try {
        	 PreparedStatement prest= con.prepareStatement(sql);
        	 prest=con.prepareStatement(sql);
        	 ResultSet rs=prest.executeQuery();
             System.out.println(prest.toString());
             while(rs.next()){
            	 Room room = new  Room();
            	 room.setRoom_id(rs.getString(1));
            	 room.setRoom_price(rs.getString(2));
            	 room.setRoom_capacity(rs.getString(3));
            	 room.setRoom_condition(rs.getString(4));
       
                 list.add(room);
             }
             
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	/*
	 * 查询服务员信息（管理员）
	 */
	public List<Room> getroomList(Room room){
		List<Room> retList= new ArrayList<Room>();
		String sql = "SELECT * from room WHERE room_id =?";
		try{
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, room.getRoom_id());
			ResultSet executeQuery = prest.executeQuery();
			while(executeQuery.next()) {
			Room ro = new Room ();
			ro.setRoom_id(executeQuery.getString("room_id"));
			ro.setRoom_price(executeQuery.getString("room_price"));
			ro.setRoom_capacity(executeQuery.getString("room_capacity"));
			ro.setRoom_condition(executeQuery.getString("room_condition"));
			retList.add(ro);
			}
		}catch (SQLException el) {
				el.printStackTrace();
		}
		
		return retList;
		
	}
	/*
	 * 更新房间信息（管理员）
	 */
	public boolean update(Room room) {
		String sql = "update room set room_price=?,room_capacity=?,room_condition =? where room_id =?";
		
		try {
			PreparedStatement prest = con.prepareStatement(sql);
			prest.setString(1, room.getRoom_price());
			prest.setString(2, room.getRoom_capacity());
			prest.setString(3, room.getRoom_condition());
			prest.setString(4, room.getRoom_id());
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
	
	
}
