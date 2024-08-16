package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.UpdateBookBean;

public class UpdateBookDao
{
	public static Connection con;
	 static
	  {
	    try 
	    {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con= DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-EEI1EJM:1521:XE","system","sushant");
		} 
	    catch (ClassNotFoundException | SQLException e) 
	    {
		  e.printStackTrace();
		}
	  }
	
	
	public String updateAuthentication(UpdateBookBean update) throws SQLException
	{
		PreparedStatement ps1 = con.prepareStatement("UPDATE books SET bname=?,author=?,year=?,price=? WHERE bid=?");

		ps1.setString(1, update.getBname());
		ps1.setString(2, update.getAuthor());
		ps1.setInt(3, update.getYear());
		ps1.setInt(4, update.getPrice());
		ps1.setInt(5, update.getBid());
		
		
				
		int i = ps1.executeUpdate();
		if(i==1)
		{
			return "Update";
		}
		else
		{
			return "Record not updated...";
		}
	}
	

}
