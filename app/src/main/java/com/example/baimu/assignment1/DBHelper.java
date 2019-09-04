package com.example.baimu.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

    private static final String driver = "com.mysql.cj.jdbc.Driver";


    private static final String url="jdbc:mysql://database-2.ccxqtamsm5rg.us-east-2.rds.amazonaws.com:3306/mobile";

    private static final String username="admin";
    private static final String password="Aslanbaimu";

    private static Connection conn=null;

    static
    {
        try
        {
            Class.forName(driver);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception
    {
        if(conn==null)
        {
            conn = DriverManager.getConnection(url, username, password); //连接数据库
            return conn;
        }
        return conn;
    }

    public static void main(String[] args) {

        try
        {
            Connection conn = DBHelper.getConnection();
            if(conn!=null)
            {
                System.out.println("Working now！");
                //Log.i("Test","Working now！");
            }
            else
            {
                System.out.println("Error！");
                //Log.i("Test","Error！");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }
}