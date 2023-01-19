/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Close;
import config.Config;
import entity.Book_room;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class BookroomManagement {
    public static void add(Book_room bookroom) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean flag = false;

        String sql = "INSERT INTO book_room(id, book_id,room_id )VALUES(?,?,?)";
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, bookroom.getId());
            preparedStatement.setInt(2, bookroom.getBook_id());
            preparedStatement.setInt(3, bookroom.getRoom_id());
           
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
