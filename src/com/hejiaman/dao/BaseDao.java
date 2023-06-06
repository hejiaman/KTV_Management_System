package com.hejiaman.dao;

import java.sql.Connection;

import com.hejiaman.util.DbUtil;

/**
 * 
 * @author 13488
 *创建对数据库连接对象，整个项目与数据库打交道都用这个对象
 */
public class BaseDao {
	public Connection con = new DbUtil().getCon();

}
