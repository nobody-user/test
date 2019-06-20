package com.huake.model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.huake.pojo.Goods;

import utils.JdbcUtil;

public class UpdataProductDao {
	public int updata(Goods good) {
		try {
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql="UPDATE goods SET `title` = ?, `oldMoney` = ?,`money` = ? , `goodNumber` = ? , `goodIntroduction` = ? , `sellNumber` =? , `images` = ? WHERE `id` = ? ";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, good.getTitle());
			ps.setString(2, good.getOldMoney());
			ps.setString(3, good.getMoney());
			ps.setString(4, good.getGoodNumber());
			ps.setString(5, good.getGoodIntroduction());
			ps.setString(6, good.getSellNumber());
			ps.setString(7, good.getImages());
			ps.setInt(8, good.getId());
			
			int res=ps.executeUpdate();
			return res;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
