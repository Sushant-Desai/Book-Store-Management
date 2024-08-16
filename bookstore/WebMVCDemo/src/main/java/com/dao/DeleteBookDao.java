package com.dao;

import java.sql.*;

import com.bean.AddBookBean;
import com.bean.DeleteBookBean;

public class DeleteBookDao
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
		

	public String deleteAuthentication(DeleteBookBean delete) throws SQLException
	{
		PreparedStatement ps2 = con.prepareStatement("Delete from books where bid=?");
		
		ps2.setInt(1, delete.getBid());
		int i = ps2.executeUpdate();
		if(i==1)
		{
			return "Record not inserted...";
			
		}
		else
		{
			return "delete";
		}
	}
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