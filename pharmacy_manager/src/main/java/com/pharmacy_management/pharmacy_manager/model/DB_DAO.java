package com.pharmacy_management.pharmacy_manager.model;

import java.sql.*;

public class DB_DAO {
    private Connection conn=null;
    private  static  final  String DB_URL="jdbc:sqlserver://localhost:1433;databaseName=pharmacyApp_DB";
    private  static   final  String userName="sa";
    private  static   final  String pass="100199";
    public Connection getConn() {
        try {
            conn= DriverManager.getConnection(DB_URL,userName,pass);
            System.out.println("Login successful!\n+++++++++++++++++++++");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
