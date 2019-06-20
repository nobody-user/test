package com.huake.contoller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huake.model.admin.BackProductDao;
import com.huake.pojo.Goods;


@WebServlet("/AdminBackProductServlet")
public class AdminBackProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("projectId");
		BackProductDao dao=new BackProductDao();
		Goods res=dao.back(id);
		
		request.setAttribute("producetList", res);
		
		request.getRequestDispatcher("admin/project_update.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
