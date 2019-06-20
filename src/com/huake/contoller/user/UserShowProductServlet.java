package com.huake.contoller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.huake.model.user.UserShowProductDao;
import com.huake.pojo.Goods;


@WebServlet("/UserShowProductServlet")
public class UserShowProductServlet extends HttpServlet {
	
   
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		UserShowProductDao dao=new UserShowProductDao();
		List<Goods> showgoods=dao.show();
		JSONObject jo = new JSONObject();
		jo.put("data", showgoods);
		response.getWriter().print(jo);
		
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
