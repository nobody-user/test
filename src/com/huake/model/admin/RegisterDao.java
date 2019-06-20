package com.huake.model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.huake.pojo.Admin;

import utils.JdbcUtil;

public class RegisterDao {
	public int register(Admin admin) {
		try {
			Connection conn=JdbcUtil.getInstace().getConn();
			String sql="INSERT INTO admin(admin_name,admin_account,admin_password,admin_phone)values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			 
			ps.setString(1, admin.getAdmin_name());
			ps.setString(2, admin.getAdmin_account());
			ps.setString(3, admin.getAdmin_password());
			ps.setString(4, admin.getAdmin_phone());
		     
		     int res = ps.executeUpdate();
		     
		   
		     return  res;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
		
	}

}
