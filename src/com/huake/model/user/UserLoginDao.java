package com.huake.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.huake.pojo.User;

import utils.JdbcUtil;

public class UserLoginDao {
	public boolean userlogin(User user) {
		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql="select * from user where account=? and password=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			ResultSet  res=ps.executeQuery();
			if (res.next()) {
				return true;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
