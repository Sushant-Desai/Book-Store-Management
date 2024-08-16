package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.AddBookBean;

public class AddBookDao
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
	
	public String userAuthentication(AddBookBean insert) throws SQLException,ClassNotFoundException
	{		
		//insert record
		PreparedStatement ps = con.prepareStatement("INSERT INTO books (BID,BNAME,AUTHOR,YEAR,PRICE) VALUES(?, ?, ?, ?, ?)");

		ps.setInt(1, insert.getBid());
		ps.setString(2, insert.getBname());
		ps.setString(3, insert.getAuthor());
		ps.setInt(4, insert.getYear());
		ps.setInt(5, insert.getPrice());
		
		//insert
		int i = ps.executeUpdate();
		if(i==1)
		{
			return "Insert";
		}
		else
		{
			return "Record not inserted...";
		}
	}
	
//	public String updateAuthentication(AddBookBean update) throws SQLException
//	{
//		//insert record
//		PreparedStatement ps1 = con.prepareStatement("UPDATE books SET bname=?, author=?, year=? WHERE bid=?;");
//
//		ps1.setInt(1, update.getBid());
//		ps1.setString(2, update.getBname());
//		ps1.setString(3, update.getAuthor());
//		ps1.setInt(4, update.getYear());
//				
//		//insert
//		int i = ps1.executeUpdate();
//		if(i==1)
//		{
//			return "Update";
//		}
//		else
//		{
//			return "Record not inserted...";
//		}
//	}
//	
//	public String deleteAuthentication(AddBookBean delete) throws SQLException
//	{
//		PreparedStatement ps2 = con.prepareStatement("Delete from books where bid=?");
//		
//		ps2.setInt(1, delete.getBid());
//		int i = ps2.executeUpdate();
//		if(i==1)
//		{
//			return "delete";
//		}
//		else
//		{
//			return "Record not inserted...";
//		}
//	}
}





//public class AddBookDao {
//    private static Connection con;
//
//    static {
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "omkar", "omkar");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String userAuthentication(AddBookBean insert) {
//        try (PreparedStatement ps = con.prepareStatement("INSERT INTO books (BID, BNAME, AUTHOR, YEAR, PRICE) VALUES(?, ?, ?, ?, ?)")) {
//            ps.setInt(1, insert.getBid());
//            ps.setString(2, insert.getBname());
//            ps.setString(3, insert.getAuthor());
//            ps.setInt(4, insert.getYear());
//            ps.setInt(5, insert.getPrice());
//
//            int i = ps.executeUpdate();
//            return (i == 1) ? "Insert" : "Record not inserted...";
//        } catch (SQLException e) {
//            // Handle or log the exception
//            e.printStackTrace();
//            return "Error in database operation";
//        }
//    }
//
//    public String updateAuthentication(AddBookBean update) {
//        try (PreparedStatement ps1 = con.prepareStatement("UPDATE books SET BNAME=?, AUTHOR=?, YEAR=?, PRICE=? WHERE BID=?")) {
//            ps1.setString(1, update.getBname());
//            ps1.setString(2, update.getAuthor());
//            ps1.setInt(3, update.getYear());
//            ps1.setInt(4, update.getPrice());
//            ps1.setInt(5, update.getBid());
//
//            int i = ps1.executeUpdate();
//            return (i == 1) ? "Update" : "Record not updated...";
//        } catch (SQLException e) {
//            // Handle or log the exception
//            e.printStackTrace();
//            return "Error in database operation";
//        }
//    }
//
//    public String deleteAuthentication(AddBookBean delete) {
//        try (PreparedStatement ps2 = con.prepareStatement("DELETE FROM books WHERE BID=?")) {
//            ps2.setInt(1, delete.getBid());
//            int i = ps2.executeUpdate();
//            return (i == 1) ? "Delete" : "Record not deleted...";
//        } catch (SQLException e) {
//            // Handle or log the exception
//            e.printStackTrace();
//            return "Error in database operation";
//        }
//    }
//
//}
//
