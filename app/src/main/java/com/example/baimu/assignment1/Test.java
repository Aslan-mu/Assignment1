package com.example.baimu.assignment1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Test {

    private static Connection conn = null;

    private static PreparedStatement pst = null;

    private static ResultSet rs = null;

    List list = null;

    public List getUsers(){
        list = new ArrayList<User>();

//        Log.i("Test","In test now");
        try {
            conn=DBHelper.getConnection();
            pst = conn.prepareStatement("SELECT * FROM User");

            rs = pst.executeQuery();

            while (rs.next()) {

                User user=new User();

                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPwd(rs.getString(3));

                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            try {
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
				/*if (conn != null)
					conn.close(); */
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return list;
    }

}
