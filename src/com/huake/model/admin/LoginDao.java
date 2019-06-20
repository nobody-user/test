package com.huake.model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.huake.pojo.Admin;

import utils.JdbcUtil;

public class LoginDao {
	public boolean login(Admin admin) {
		
		try {
			 Connection conn=JdbcUtil.getInstace().getConn();
			 String sql="select * from  admin where admin_name=? and admin_password=?";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setString(1,admin.getAdmin_name());
			 ps.setString(2,admin.getAdmin_password());
			 ResultSet res=ps.executeQuery();
				if (res.next()) {
					return true;
				}
				
			 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}

}
