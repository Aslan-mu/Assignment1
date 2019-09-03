package com.example.baimu.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

    private static final String driver = "com.mysql.jdbc.Driver";

    /**
     * 如下是连接数据库的URL地址，
     * 其中，"jdbc:mysql://"   为固定写法
     * "localhost"是连接本机数据库时的写法，当不是连接本机数据库时，要写数据库所在计算机的IP地址。如：172.26.132.253
     * "shopping"是数据库的名称，一定要根据自己的数据库更改。
     * "?useUnicode=true&characterEncoding=UTF-8" 指定编码格式，无需时可省略，
     * 即地址直接为："jdbc:mysql://localhost:3306/shopping"
     */
    private static final String url="jdbc:mysql://database-1.ccxqtamsm5rg.us-east-2.rds.amazonaws.com:3306/database-1";

    private static final String username="admin";//数据库的用户名
    private static final String password="Aslanbaimu";//数据库的密码:这个是自己安装数据库的时候设置的，每个人不同。

    private static Connection conn=null;  //声明数据库连接对象

    //静态代码块负责加载驱动
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

    //单例模式返回数据库连接对象，供外部调用
    public static Connection getConnection() throws Exception
    {
        if(conn==null)
        {
            conn = DriverManager.getConnection(url, username, password); //连接数据库
            return conn;
        }
        return conn;
    }

    //写main方法测试是否连接成功，可将本类运行为Java程序先进行测试，再做后续的数据库操作。
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