package com.huake.contoller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.huake.model.admin.LoginDao;
import com.huake.pojo.Admin;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=accept(request);
		LoginDao dao=new LoginDao();
		boolean result=dao.login(admin);
		JSONObject jo=new JSONObject();
		if(result) {
			jo.put("flag", "success");
			
		}
		response.getWriter().print(jo);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
public Admin accept(HttpServletRequest request) {
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		Admin admin=new Admin();
		
		admin.setAdmin_name(name);
		admin.setAdmin_password(password);
		return admin;
	}
}
