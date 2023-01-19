/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Close;
import config.Config;
import entity.Bill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class BillManagement {
    public static void add(Bill billMn) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean flag = false;

        String sql = "INSERT INTO bill(id, book_id,user_id,price,time_out,"
                + "create_at,update_at )VALUES(?,?,?,?,?,?,?)";
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, billMn.getId());
            preparedStatement.setInt(2, billMn.getRoom_id());
            preparedStatement.setInt(3, billMn.getUser_id());
            preparedStatement.setFloat(4, billMn.getPrice());
            preparedStatement.setString(5, null);
            preparedStatement.setString(6, billMn.getCreate_at());
            preparedStatement.setString(7, billMn.getUpdate_at());
            
            
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("aaaa");
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);

        }

    }
}
