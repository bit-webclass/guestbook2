package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestbookVo;

@WebServlet("/gb")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String actionName = request.getParameter("action");

		if ("add".equals(actionName)) {

			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");

			GuestbookDao dao = new GuestbookDao();
			GuestbookVo vo = new GuestbookVo(name, password, content);
			dao.insert(vo);
			System.out.println(vo.toString());

			//response.sendRedirect("/guestbook2/gb");
			WebUtil.redirect(request, response, "/guestbook2/gb");

		} else if ("deleteform".equals(actionName)) {
			
			WebUtil.forward(request, response, "/WEB-INF/deleteForm.jsp");
			
			//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/deleteform.jsp");
			//rd.forward(request, response);

		} else if ("delete".equals(actionName)) {
			int no = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");

			GuestbookVo vo = new GuestbookVo();
			vo.setNo(no);
			vo.setPassword(password);

			GuestbookDao dao = new GuestbookDao();
			dao.delete(vo);
			
			WebUtil.redirect(request, response, "/guestbook2/gb");
			//response.sendRedirect("/guestbook2/gb");
		} else {
			GuestbookDao dao = new GuestbookDao();
			List<GuestbookVo> list = dao.getList();

			request.setAttribute("list", list);
			
			WebUtil.forward(request, response, "/WEB-INF/addList.jsp");
			//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/guestbook/list.jsp");
			//rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
