package com.huake.contoller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huake.model.admin.ShowProductDao;
import com.huake.pojo.Goods;


@WebServlet("/AdminShowProduct")
public class AdminShowProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowProductDao dao=new ShowProductDao();
		List<Goods> showgoods=dao.show();
		request.setAttribute("producetList", showgoods);
		request.getRequestDispatcher("admin/project_list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
