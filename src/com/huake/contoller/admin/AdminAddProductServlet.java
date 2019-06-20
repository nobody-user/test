package com.huake.contoller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.huake.model.admin.AddProductDao;
import com.huake.pojo.Goods;


@WebServlet("/AdminAddProductServlet")
public class AdminAddProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Goods goods = uploadImage(request, response);


		AddProductDao dao = new AddProductDao();

		int res = dao.add(goods);

		request.getRequestDispatcher("AdminShowProduct").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	private Goods uploadImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Goods goods = new Goods();

		// 判断上传表单是否为multipart/form-data类型
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
//			 1，2，3 步  、是 用来   把 request 转 成 一个     文件类型的 List 容器  
//		     4 步、 就是 循环  LIST 数据 
//			 7  ，8  步 、用来 判定是 普通数据， 还是  文件 数据 
				 
//			 6  步  、用来 判定  这次 循环 取出来的是 哪一个    普通数据  
//			 5  步 、把这个 图片写入  项目 的  goods文件夹 
//			 7步 、 拼接 达到这个图片的  网络 地址 ， 并且 把这个  路径 存到 数据库
				
				// 1. 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// 2. 创建ServletFileUpload对象，并设置上传文件的大小限制。
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setSizeMax(10 * 1024 * 1024);// 以byte为单位 不能超过10M 1024byte =
												// 1kb 1024kb=1M 1024M = 1G
				sfu.setHeaderEncoding("utf-8");

				// 3.调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
				List<FileItem> fileItemList = sfu.parseRequest(request);
				
				Iterator<FileItem> fileItems = fileItemList.iterator();
				
				// 4. 遍历list，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件
				while (fileItems.hasNext()) {
					FileItem fileItem = fileItems.next();
					//7  普通表单元素
					if (fileItem.isFormField()) {

						String name = fileItem.getFieldName();// name属性值
						String value = fileItem.getString("utf-8");// name对应的value值
//						6 、 通过  name 与  网页中的  name值 对比， 
						if (name.equals("title")) {
							goods.setTitle(value);
						}
						if (name.equals("oldMoney")) {
							goods.setOldMoney(value);
						}
						if (name.equals("money")) {
							goods.setMoney(value);
						}
						if (name.equals("goodNumber")) {
							goods.setGoodNumber(value);
						}
						if (name.equals("goodIntroduction")) {
							goods.setGoodIntroduction(value);
						}
						if (name.equals("sellNumber")) {
							goods.setSellNumber(value);
						}

					}
//					8 判定文件 类型 
					else {
						
						System.out.println("eee" + fileItems.hasNext());
						String fileName = fileItem.getName();// 文件名称
						System.out.println("原文件名：" + fileName);// Koala.jpg

						String suffix = fileName.substring(fileName.lastIndexOf('.'));
						System.out.println("扩展名：" + suffix);// .jpg

						// 新文件名（唯一）
						String newFileName = new Date().getTime() + suffix;
						System.out.println("新文件名：" + newFileName);// image\1478509873038.jpg

						// 5. 调用FileItem的write()方法，写入文件
						File file = new File(request.getServletContext().getRealPath("/goods") + "\\" + newFileName);
						fileItem.write(file);
//						9 /  拼接 图片 路径  保存到 数据库中 
						String url = "http://localhost:8080/finaltg/goods/" + newFileName;
						goods.setImages(url);

					}

				}
				return goods;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}

}
