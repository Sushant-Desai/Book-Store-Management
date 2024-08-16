package com.controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.bean.AddBookBean;
import com.bean.DeleteBookBean;
import com.dao.AddBookDao;
import com.dao.DeleteBookDao;

public class DeleteBookServlet extends HttpServlet
{
    public DeleteBookServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		int bid = Integer.parseInt(request.getParameter("bid"));
//		String bname = request.getParameter("bname");
//		String author = request.getParameter("author");
//		int year = Integer.parseInt(request.getParameter("year"));
//		int price = Integer.parseInt(request.getParameter("price"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		DeleteBookBean dbb = new DeleteBookBean();
		
		dbb.setBid(Integer.parseInt(request.getParameter("bid")));

		
		
		RequestDispatcher rd2 = request.getRequestDispatcher("./bookmaster.jsp");
		RequestDispatcher rd4 = request.getRequestDispatcher("./DeleteBook.jsp");
		
		
		DeleteBookDao delete = new DeleteBookDao();

		
		//insert
		
		
		try 
		{
			String str2 = delete.deleteAuthentication(dbb);

			if(str2.equals("Delete"))
			{
				rd2.forward(request, response);
			}
			else
			{
				//out.print(""+str2);
				rd4.include(request, response);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	} 
}
