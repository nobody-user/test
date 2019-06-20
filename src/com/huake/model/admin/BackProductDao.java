package com.huake.model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.huake.pojo.Goods;

import utils.JdbcUtil;

public class BackProductDao {
	public Goods back(String pid) {
		
		try {
			
			Connection conn = JdbcUtil.getInstace().getConn();
			String sql="select * from goods where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			ResultSet res=ps.executeQuery();
			
			
			
			if(res.next()) {
				int id = res.getInt("id");
				String title = res.getString("title");
				String oldMoney = res.getString("oldMoney");
				String money = res.getString("money");
				String goodNumber = res.getString("goodNumber");
				String goodIntroduction = res.getString("goodIntroduction");
				String sellNumber = res.getString("sellNumber");
				String images = res.getString("images");

				Goods goods = new Goods();

				goods.setId(id);
				goods.setTitle(title);
				goods.setOldMoney(oldMoney);
				goods.setMoney(money);
				goods.setGoodNumber(goodNumber);
				goods.setGoodIntroduction(goodIntroduction);
				goods.setSellNumber(sellNumber);
				goods.setImages(images);

				
				return goods;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
