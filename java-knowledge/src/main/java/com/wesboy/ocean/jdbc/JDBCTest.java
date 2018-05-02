package com.wesboy.ocean.jdbc;

import java.sql.*;

public class JDBCTest {

    public static final String URL = "jdbc:mysql://localhost:3306/test";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, "root", "root");


            String sql = "select * from student where sname=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "westboy");
            ResultSet rs = ps.executeQuery();
            String a = null;
            System.out.println(a.equals("as"));
            while (rs.next()){
                System.out.println(rs.getString("sname"));
                System.out.println(rs.getInt("age"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

