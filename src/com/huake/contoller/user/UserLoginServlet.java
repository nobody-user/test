package com.huake.contoller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.huake.model.user.UserLoginDao;
import com.huake.pojo.User;


@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user=accept(request);
		UserLoginDao dao=new UserLoginDao();
		boolean result=dao.userlogin(user);
		JSONObject jo=new JSONObject();
		if(result) {
			jo.put("resultCode", "1");
			jo.put("message", "登陆成功");
			
		
		}else {
			jo.put("resultCode", "0");
			jo.put("message", "登陆失败");
		}
		
		response.getWriter().print(jo);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	public User accept(HttpServletRequest request) {
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		User user=new User();
		user.setAccount(account);
		user.setPassword(password);
		return user;
		
	}
}
