package com.huake.model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.JdbcUtil;

public class DeleteProductDao {
	public int  delete(String id) {
		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql="delete from goods where id=?";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			
			int res=ps.executeUpdate();
			return res;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
