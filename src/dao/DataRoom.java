/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Close;
import config.Config;
import entity.Room;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DataRoom {

    public static List<Room> getRoom(int room_number) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        List<Room> RoomList = new ArrayList<>();
        String sql = "SELECT*FROM room where room_number";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, room_number);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Room rm = new Room(
                        rs.getInt("id"),
                        rs.getString("room_number"),
                        rs.getString("room_type"),
                        rs.getString("floor"),
                        rs.getBoolean("status"),
                        rs.getFloat("price"),
                        rs.getString("image")
                );

                RoomList.add(rm);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closeResultSet(rs);
            Close.closePreparedStatement(preparedStatement);

        }
        return RoomList;

    }
        public static void UpdateStatus(Room rm) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        
        String sql = "UPDATE room set status= ? where id=?";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setBoolean(1, rm.getStatus());
            preparedStatement.setInt(2, rm.getId());
            preparedStatement.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            
            Close.closePreparedStatement(preparedStatement);

        }
        
        
    }
}
