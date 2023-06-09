package com.hejiaman.util;
/*
 * 顾客预约表中KTV房间信息表的连接
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
 
import javax.swing.JOptionPane;
 
public class PutinStorage {
	// 得到数据库表数据
	public static Vector getRows(){
		String sql_url = "jdbc:mysql://localhost:3306/ktv";	//数据库路径（一般都是这样写），test是数据库名称
		String name = "root";		//用户名
		String password = "hjm861303";	//密码
		Connection conn;
		PreparedStatement preparedStatement = null;
 
		Vector rows = null;
		Vector columnHeads = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//连接驱动
			conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库
//			if(!conn.isClosed())
//				System.out.println("成功连接数据库");
			preparedStatement = conn.prepareStatement("select * from room");
			ResultSet result1 = preparedStatement.executeQuery();
			
//			if(result1.wasNull())
//				JOptionPane.showMessageDialog(null, "结果集中无记录");
			
			rows = new Vector();
			
			ResultSetMetaData rsmd = result1.getMetaData();
					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功加载驱动。");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
			e.printStackTrace();
		}
		return rows;
	}
	
	// 得到数据库表头
	public static Vector getHead(){
		String sql_url = "jdbc:mysql://localhost:3306/ktv";	//数据库路径（一般都是这样写），test是数据库名称
		String name = "root";		//用户名
		String password = "hjm861303";	//密码
		Connection conn;
		PreparedStatement preparedStatement = null;
 
		Vector columnHeads = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//连接驱动
			conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库
//			if(!conn.isClosed())
//				System.out.println("成功连接数据库");
			preparedStatement = conn.prepareStatement("select * from room");
			ResultSet result1 = preparedStatement.executeQuery();
			
			boolean moreRecords = result1.next();
			if(!moreRecords)
				JOptionPane.showMessageDialog(null, "结果集中无记录");
			
			columnHeads = new Vector();
			ResultSetMetaData rsmd = result1.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
				columnHeads.addElement(rsmd.getColumnName(i));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功加载驱动。");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
			e.printStackTrace();
		}
		return columnHeads;
	}
	
	// 得到数据库中下一行数据
	private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
		Vector currentRow = new Vector();
		for(int i = 1; i <= rsmd.getColumnCount(); i++){
			currentRow.addElement(rs.getString(i));
		}
		return currentRow;
	}
	
	/*//主函数
	 public static void main(String[] args){
		 getRows();
	}*/
}