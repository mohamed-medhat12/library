package com.example.librarysystem;

import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    static String url="jdbc:sqlite:Data.db";
    static java.sql.Connection con;
    public static java.sql.Connection connect(){
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}