package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ShowBookBean;
import com.dao.ShowBookDao;

public class ShowBookServlet extends HttpServlet {

    public ShowBookServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        ShowBookDao sbd = new ShowBookDao();

        try {
            // Retrieve the list of books from the database
            List<ShowBookBean> bookList = sbd.getBooks();

            // Set the bookList as an attribute in the request
            request.setAttribute("bookList", bookList);

            // Forward the request to the JSP page for displaying the books
            RequestDispatcher rd1 = request.getRequestDispatcher("./Show.jsp");
            rd1.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

            // If there's an exception, you might want to handle it accordingly
            // For now, just forwarding to an error page
            RequestDispatcher rd2 = request.getRequestDispatcher("./error.jsp");
            rd2.forward(request, response);
        }
    }
}
