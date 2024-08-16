package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AddBookBean;
import com.dao.AddBookDao;

public class AddBookServlet extends HttpServlet
{
    public AddBookServlet()
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
		
		
		//insert
		AddBookBean abobj = new AddBookBean();
		
		abobj.setBid(Integer.parseInt(request.getParameter("bid")));
		abobj.setBname(request.getParameter("bname"));
		abobj.setAuthor(request.getParameter("author"));
		abobj.setYear(Integer.parseInt(request.getParameter("year")));
		abobj.setPrice(Integer.parseInt(request.getParameter("price")));
		
		
		RequestDispatcher rd2 = request.getRequestDispatcher("./bookmaster.jsp");
		RequestDispatcher rd3 = request.getRequestDispatcher("./UpdateBook.jsp");
		RequestDispatcher rd4 = request.getRequestDispatcher("./DeleteBook.jsp");
		
		AddBookDao insert = new AddBookDao();
		AddBookDao update = new AddBookDao();
		AddBookDao delete = new AddBookDao();

		
		//insert
		
		
		try 
		{
			String str = insert.userAuthentication(abobj);
//			String str1 = update.updateAuthentication(abobj);
//			String str2 = delete.deleteAuthentication(abobj);


			if(str.equals("Insert"))
			{
				RequestDispatcher rd1 = request.getRequestDispatcher("./AddBook.jsp");
				rd1.forward(request, response);
			}
//			else if(str1.equals("Update"))
//			{
//				rd3.forward(request, response);
//			}
//			else if(str2.equals("Delete"))
//			{
//				rd4.forward(request, response);
//			}
			else
			{
				out.print(""+str);
				rd2.include(request, response);
			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}

	} 
}
