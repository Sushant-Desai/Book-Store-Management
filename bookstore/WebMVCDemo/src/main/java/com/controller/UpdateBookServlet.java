package com.controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.bean.AddBookBean;
import com.bean.UpdateBookBean;
import com.dao.UpdateBookDao;

public class UpdateBookServlet extends HttpServlet
{
    public UpdateBookServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UpdateBookBean ubb = new UpdateBookBean();
		
		ubb.setBid(Integer.parseInt(request.getParameter("bid")));
		ubb.setBname(request.getParameter("bname"));
//		ubb.setAuthor(request.getParameter("author"));
//		ubb.setYear(Integer.parseInt(request.getParameter("year")));
//		ubb.setPrice(Integer.parseInt(request.getParameter("price")));
		
		
		RequestDispatcher rd2 = request.getRequestDispatcher("./bookmaster.jsp");
		RequestDispatcher rd3 = request.getRequestDispatcher("./UpdateBook.jsp");
	
		UpdateBookDao update = new UpdateBookDao();	
		
		try 
		{
			String str1 = update.updateAuthentication(ubb);

			if(str1.equals("Update"))
			{
				rd3.forward(request, response);
			}
			else
			{
				out.print(""+str1);
				rd2.include(request, response);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	} 
}
