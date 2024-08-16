package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.ShowBookBean;
import com.util.DBConnection;

public class ShowBookDao {
    public static Connection con;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-EEI1EJM:1521:XE","system","sushant");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ShowBookBean> getBooks() throws SQLException, ClassNotFoundException {
        con = DBConnection.getDbConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM books");

        List<ShowBookBean> bookList = new ArrayList<>();

        while (rs.next()) {
            ShowBookBean book = new ShowBookBean();
            book.setBid(rs.getInt("bid"));
            book.setBname(rs.getString("bname"));
            book.setAuthor(rs.getString("author"));
            book.setYear(rs.getInt("year"));
            book.setPrice(rs.getInt("price"));
            bookList.add(book);
        }

        return bookList;
    }
}
