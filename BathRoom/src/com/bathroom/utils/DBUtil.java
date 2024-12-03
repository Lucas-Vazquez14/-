package com.bathroom.utils;


import java.sql.*;
import java.util.ResourceBundle;

//工具类
public class DBUtil {
    //静态变量及方法
    public static ResourceBundle bundle = ResourceBundle.getBundle("resources/jdbc");
    public static String driver = bundle.getString("driver");
    public static String url = bundle.getString("url");
    public static String user = bundle.getString("user");
    public static String password = bundle.getString("password");

    private DBUtil() {}

    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    public static Connection getConnection() throws SQLException {
        Connection conn = threadLocal.get();
        if(conn == null){
            conn = DriverManager.getConnection(url,user,password);
            threadLocal.set(conn);
        }
        return conn;
    }
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if(conn != null) {
            try {
                conn.close();
                threadLocal.remove();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
