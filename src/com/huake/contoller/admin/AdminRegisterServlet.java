package com.huake.contoller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.huake.model.admin.RegisterDao;
import com.huake.pojo.Admin;

@WebServlet("/AdminRegisterServlet")
public class AdminRegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=accept(request);
		RegisterDao dao=new RegisterDao();
		
		int res=dao.register(admin);
		JSONObject  jo = new JSONObject() ; 
		
		
		jo.put("success", res);
		
		
		response.getWriter().print(jo);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	public Admin accept(HttpServletRequest request) {
		String userName=request.getParameter("userName");
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		Admin admin=new Admin();
		admin.setAdmin_name(userName);
		admin.setAdmin_password(password);
		admin.setAdmin_account(account);
		admin.setAdmin_phone(phone);
		return admin;
		
	}

}
