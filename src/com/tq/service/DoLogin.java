package com.tq.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tq.entity.User;
import com.tq.util.DBUtils;

public class DoLogin {

	/**
	 * 根据用户名和密码查询用户对象信息
	 * @param name
	 * @param pwd
	 * @return u
	 */
	public User findUser(String name,String pwd){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User u = null;
		try {
			conn = DBUtils.getConnection();//得到连接对象Connection
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery("select * from users where name = '"+name+"' and password = '"+pwd+"'");
			String sql ="SELECT * FROM users WHERE NAME=? AND PASSWORD=?";
			stmt = conn.prepareStatement(sql);//得到执行sql语句的对象Statement
			//给？赋值
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			
			rs = stmt.executeQuery();//执行sql语句
			if(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, stmt, conn);
		}
		
		return u;
	}

}
