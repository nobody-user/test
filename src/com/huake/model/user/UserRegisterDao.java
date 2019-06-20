package com.huake.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.huake.pojo.User;

import utils.JdbcUtil;

public class UserRegisterDao {
	public int userregister(User user) {
		
		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql="INSERT INTO user (account,password,email) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			int res=ps.executeUpdate();
			return res;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
		
	}

}
