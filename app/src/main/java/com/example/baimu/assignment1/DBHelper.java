package com.example.baimu.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class DBHelper {



    public static Connection getConnection()
    {
        String driver = "com.mysql.cj.jdbc.Driver";


        String url="jdbc:mysql://database-1.ccxqtamsm5rg.us-east-2.rds.amazonaws.com:3306/innodb";

        String username="admin";
        String password="Aslanbaimu";

        Connection conn=null;

        try
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
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
        Test t = new Test();
        List<User> temp = t.getUsers();
        for (int i = 0; i< temp.size(); i++){
            System.out.println(temp.get(i).getId());
            System.out.println(temp.get(i).getName());
            System.out.println(temp.get(i).getPwd());
        }

    }
}